package com.tanahku.beranda

import android.content.Intent
import android.graphics.drawable.Drawable
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import com.google.gson.Gson
import com.tanahku.R
import com.tanahku.core.domain.model.DataItemDomain
import com.tanahku.core.utils.Constants
import com.tanahku.core.utils.vo.Status
import com.tanahku.databinding.FragmentBerandaBinding
import com.tanahku.detail.DetailActivity
import org.koin.android.ext.android.inject
import java.io.IOException
import java.util.Locale

class BerandaFragment : Fragment(), OnMapReadyCallback {

    private var _binding: FragmentBerandaBinding? = null
    private val binding get() = _binding
    private val viewModelDevice by inject<LocationMapViewModel>()
    private val adapterDevice by inject<ListDeviceAdapter>()
    private lateinit var mMap: GoogleMap
    private val boundsBuilder = LatLngBounds.Builder()
    private var isShow: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBerandaBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        binding?.buttonSet?.setOnClickListener {
            isShow = !isShow
            val drawable: Drawable? = resources.getDrawable(R.drawable.baseline_close_24)
            if(isShow){
                binding?.rvDevice?.visibility = View.VISIBLE
                binding?.buttonSet?.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null)
                showRv()
            }
            else {
                binding?.rvDevice?.visibility = View.GONE
                binding?.buttonSet?.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
            }
        }
        Log.e("tampil", "onViewCreated: $isShow")
        getData()
    }

    private fun getData() {
        viewModelDevice.getDevice().observe(viewLifecycleOwner) { resource ->
            when (resource.status) {
                Status.SUCCESS -> {
                    adapterDevice.submitList(resource.data)
                }

                Status.LOADING -> {}
                Status.ERROR -> {}
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isIndoorLevelPickerEnabled = true
        mMap.uiSettings.isCompassEnabled = true
        mMap.uiSettings.isMapToolbarEnabled = true

        addLocationMarker()
    }

    private fun showRv() {
        binding?.rvDevice?.visibility = View.VISIBLE
        binding?.rvDevice?.apply {
            layoutManager = LinearLayoutManager(
                this@BerandaFragment.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)
            adapter = adapterDevice
        }
        adapterDevice.setOnClickCallback(object : ListDeviceAdapter.OnItemClickCallback {
            override fun onClick(data: DataItemDomain) {
                goToDetail(data)
            }
        })

    }

    private fun goToDetail(data: DataItemDomain) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(Constants.DATA, data)
        startActivity(intent)
    }

    private fun addLocationMarker() {
        Log.e("tes4", "addLocationMarker: ")
        viewModelDevice.getDevice().observe(this) { resource ->
            resource.data?.map { device ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        Log.e("berhasil", "addLocationMarker: $device")
                        val gson = Gson()
                        val latLng = device.latitude?.toDouble()
                            ?.let {
                                device.longitude?.toDouble()
                                    ?.let { it1 -> LatLng(it, it1) }
                            }
                        val addresses = device.latitude?.toDouble()
                            ?.let {
                                device.longitude?.toDouble()?.let { it1 -> getAddress(it, it1) }
                            }
                        latLng?.let {
                            MarkerOptions()
                                .position(it)
                                .title(device.name)
                                .snippet(gson.toJson(device))
//                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_icon))
                        }?.let {
                            mMap.addMarker(
                                it
                            )
                        }
                        mMap.setOnMarkerClickListener {
                            val deviceSnippet = it.snippet
                            val deviceData =
                                gson.fromJson(deviceSnippet, DataItemDomain::class.java)
                            Log.e("clic", "addLocationMarker: ${it.snippet}")
                            goToDetail(deviceData)
                            true
                        }
                        latLng?.let { CameraUpdateFactory.newLatLng(it) }
                            ?.let { mMap.moveCamera(it) }
                        if (latLng != null) {
                            boundsBuilder.include(latLng)
                        }
                        val bounds: LatLngBounds = boundsBuilder.build()
                        mMap.animateCamera(
                            CameraUpdateFactory.newLatLngBounds(
                                bounds,
                                resources.displayMetrics.widthPixels,
                                resources.displayMetrics.heightPixels,
                                100
                            )
                        )
                    }

                    Status.LOADING -> {}
                    Status.ERROR -> {
                        Log.e("errorGuys", "addLocationMarker: ${resource.message}")
                    }

                    else -> {
                        Log.e("tes5", "addLocationMarker: ")
                    }
                }
            }
        }
    }

    private fun getAddress(lat: Double, lon: Double): String? {
        var address: String? = null
        val geocoder = Geocoder(this.requireContext(), Locale.getDefault())
        try {
            val list = geocoder.getFromLocation(lat, lon, 1)
            if (list != null && list.size != 0) {
                address = list[0].getAddressLine(0)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return address
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}