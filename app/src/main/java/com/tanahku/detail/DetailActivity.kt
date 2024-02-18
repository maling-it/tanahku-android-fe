package com.tanahku.detail

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.tanahku.R
import com.tanahku.core.domain.model.DataItemDomain
import com.tanahku.core.domain.model.SensorDataDomain
import com.tanahku.core.utils.Constants
import com.tanahku.core.utils.vo.Resource
import com.tanahku.core.utils.vo.Status
import com.tanahku.databinding.ActivityDetailBinding
import org.koin.android.ext.android.inject
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val viewModel by inject<DetailViewModel>()
    private lateinit var barData: BarData
    private lateinit var barDataSet: BarDataSet
    private lateinit var barEntriesList: MutableList<BarEntry>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setAppBar()

        val data = intent.getParcelableExtra<DataItemDomain>(Constants.DATA)
        if (data != null) {
            showDetailSoil(data.id)
        }

    }

    private fun showDetailSoil(id: Int?) {

        if (id != null) {
            viewModel.getSoilData(id).observe(this) { resource ->
                loadDetail(resource, binding.soilGraph)
            }
            viewModel.getWindData(id).observe(this) { resource ->
                loadDetail(resource, binding.windGraphView)
            }
            viewModel.getHumidData(id).observe(this) { resource ->
                loadDetail(resource, binding.humidGraph)
            }
            viewModel.getAirtempData(id).observe(this) { resource ->
                loadDetail(resource, binding.airtempGraph)
            }
            viewModel.getRainfallData(id).observe(this) { resource ->
                loadDetail(resource, binding.rainfallGraph)
            }
            viewModel.getSoilphData(id).observe(this) { resource ->
                loadDetail(resource, binding.soilphGraph)
            }
            viewModel.getSolarradiationData(id).observe(this) { resource ->
                loadDetail(resource, binding.solarradiationGraph)
            }
        }
    }

    private fun loadDetail(resource: Resource<List<SensorDataDomain>>?, barChart: BarChart) {
        when (resource?.status) {
            Status.LOADING -> {}
            Status.SUCCESS -> {
                val data = ArrayList<Pair<Float, Int?>>()
                val resourceData = resource.data as List<SensorDataDomain>
                val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.getDefault())
                for (i in resourceData) {
                    val date = sdf.parse(i.createdOn.toString())
                    val pair = Pair(date.time.toFloat(), i.value)
                    data.add(pair)
                }
                createChart(barChart, data)
            }

            Status.ERROR -> {
                Log.e("errorWind", "showDetail: ${resource.message}")
            }
            else -> {}
        }
    }

    private fun createChart(barChart: BarChart, data: MutableList<Pair<Float, Int?>>) {

        // Refresh the chart
        barChart.invalidate()

        barEntriesList = ArrayList()
        val xAxis = barChart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.textSize = 11f
        xAxis.setDrawGridLines(false)
        xAxis.labelRotationAngle = -45f
        xAxis.granularity = 1f
        if(isDarkMode(this)){
            xAxis.textColor = ContextCompat.getColor(this, R.color.white)
            xAxis.axisLineColor = ContextCompat.getColor(this, R.color.white)
            barChart.axisLeft.textColor = ContextCompat.getColor(this, R.color.white)
        }else {
            xAxis.textColor = ContextCompat.getColor(this, R.color.black)
            xAxis.axisLineColor = ContextCompat.getColor(this, R.color.black)
            barChart.axisLeft.textColor = ContextCompat.getColor(this, R.color.black)
        }
        //iterasi data
        data.forEachIndexed { index, pair ->
            pair.second?.let { BarEntry(index.toFloat(), it.toFloat()) }
                ?.let { barEntriesList.add(it) }
        }

        barDataSet = BarDataSet(barEntriesList, "")
        barData = BarData(barDataSet)
        barChart.data = barData


        // on below line we are setting color for our bar data set
        barDataSet.color = ContextCompat.getColor(this, R.color.green)

        // on below line we are disable value above
        barDataSet.setDrawValues(false)

        // on below line we are enabling description as false
        barChart.description.isEnabled = false
        xAxis.valueFormatter = object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                val timeZone = TimeZone.getTimeZone("Asia/Jakarta")
                val dateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
                dateFormat.timeZone = timeZone
                val timeStamp = data.getOrNull(value.toInt())?.first ?: 0
                return dateFormat.format(Date(timeStamp.toLong()))
            }
        }

        // Refresh the chart
        barChart.invalidate()

    }

    fun isDarkMode(context: Context?): Boolean {
        val currentNightMode = context?.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)
        return currentNightMode == Configuration.UI_MODE_NIGHT_YES
    }


    private fun setAppBar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationIcon(R.drawable.back)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}