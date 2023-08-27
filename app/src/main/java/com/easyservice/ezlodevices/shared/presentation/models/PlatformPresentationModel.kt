package com.easyservice.ezlodevices.shared.presentation.models

import com.easyservice.ezlodevices.R

enum class PlatformPresentationModel(val value: String, val imageRes: Int) {
    SERCOMM_G450("Sercomm G450", R.drawable.vera_plus_big),
    SERCOMM_G550("Sercomm G550", R.drawable.vera_secure_big),
    MICASAVERDE_VERALITE("MiCasaVerde VeraLite", R.drawable.vera_edge_big),
    SERCOMM_NA900("Sercomm NA900", R.drawable.vera_edge_big),
    SERCOMM_NA301("Sercomm NA301", R.drawable.vera_edge_big),
    SERCOMM_NA930("Sercomm NA930", R.drawable.vera_edge_big),
    UNKNOWN("no platform key", R.drawable.vera_edge_big)
}