/*
 *
 * Written By Muhamad Angga
 *
 */

package com.muhangga.inventory_app.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RokokModel (
    var id : Int? = 0,
    var nama : String? = "",
    var harga : String? = "",
    var pcs : Int = 0
): Parcelable