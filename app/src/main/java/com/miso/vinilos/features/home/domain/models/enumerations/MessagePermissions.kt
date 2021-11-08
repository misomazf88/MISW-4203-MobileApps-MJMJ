package com.miso.vinilos.features.home.domain.models.enumerations

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.home.domain.models.enumerations
 * Created by Jhonnatan E. Zamudio P. on 29/10/2021 at 8:35 p. m.
 * All rights reserved 2021.
 ****/

enum class MessagePermissions (val value: String) {
    DEFAULT("Esta aplicación requiere un permiso adicional"),
    WRITE_STORAGE("Esta aplicación necesita acceso a su archivos para que pueda crear álbumes"),
    CAMERA("Esta aplicación necesita acceso a su cámara para que pueda tomar fotografías")
}