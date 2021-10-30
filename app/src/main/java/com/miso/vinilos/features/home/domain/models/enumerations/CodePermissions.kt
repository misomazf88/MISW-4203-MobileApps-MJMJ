package com.miso.vinilos.features.home.domain.models.enumerations

/****
 * Project: kalunga
 * From: com.jhonnatan.kalunga.domain.models
 * Created by Jhonnatan E. Zamudio P. on 1/07/2021 at 9:31 p. m.
 * More info:  https://venecambios-kalunga.com/
 * All rights reserved 2021.
 ****/

enum class CodePermissions(val code: Int) {
    DEFAULT(0x0),
    WRITE_STORAGE(0x1),
    CAMERA(0x2)
}