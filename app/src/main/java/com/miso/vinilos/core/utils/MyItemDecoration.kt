package com.miso.vinilos.core.utils

import android.graphics.Rect
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

/****
 * Project: vinilos
 * From: com.miso.vinilos.core.utils
 * Created by Jhonnatan E. Zamudio P. on 4/11/2021 at 3:03 p. m.
 * All rights reserved 2021.
 ****/

class MyItemDecoration(type: Int) : ItemDecoration() {

    val typeDecoration = type

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view)
        if (typeDecoration == 1)
            if (position == 0 || position == 1)
                outRect.top = 50
    }
}