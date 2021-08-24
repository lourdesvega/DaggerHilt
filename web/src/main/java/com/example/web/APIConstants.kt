package com.example.web

object APIConstants {
    private const val serverPath = "https://e-nekiespress.dev.satoritech.com.mx/"
    private const val serverPathProduction = "https://deaquipaalla.com/"
    const val wsPath = "api/client/"



    private const val production: Boolean = true

    fun getServerPath(): String {
        return if(production)  serverPathProduction else serverPath
    }

}