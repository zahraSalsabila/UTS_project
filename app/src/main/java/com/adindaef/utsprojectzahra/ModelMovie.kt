package com.adindaef.utsprojectzahra

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ModelMovie (
    var photo: Int,
    var title: String,
    var desc: String
) : Parcelable