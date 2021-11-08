package com.miso.vinilos.core.models.enumerations

/****
 * Project: vinilos
 * From: com.miso.vinilos.features.home.ui.viewModels
 * Created by Jhonnatan E. Zamudio P. on 26/10/2021 at 10:50 p. m.
 * All rights reserved 2021.
 ****/

enum class TypeSnackBar (val code: Int) {
    CLOSE_APP(0x1),
    ERROR(0X2),
    INFO(0x3),
    WARNING(0X4),
    SUCCESS(0X5)
}