package com.sssports.app.users.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
        val gender: String,
        val email: String,
        val phone: String,
        val cell: String,
        val nat: String,
        val name: Name,
        val dob: Date,
        val registered: Date,
        val location: Address,
        val picture: Picture,
        val id: ID
) : Parcelable

@Parcelize
data class Name(
        val title: String,
        val first: String,
        val last: String
) : Parcelable {
    override fun toString(): String {
        return "$first $last"
    }
}

@Parcelize
data class Address(
        val city: String,
        val state: String,
        val country: String,
        val postcode: String,
        val street: Street,
        val coordinates: Coordinates,
        val timezone: Timezone
) : Parcelable {
    override fun toString(): String {
        return "${street.name} ${street.number}, $postcode $city, $state"
    }
}

@Parcelize
data class Street(
        val number: Int,
        val name: String
) : Parcelable

@Parcelize
data class Coordinates(
        val latitude: Double,
        val longitude: Double
) : Parcelable

@Parcelize
data class Timezone(
        val offset: String,
        val description: String
) : Parcelable

@Parcelize
data class Date(
        val date: String,
        val age: Int
) : Parcelable

@Parcelize
data class Picture(
        val large: String,
        val medium: String,
        val thumbnail: String
) : Parcelable

@Parcelize
data class ID(
        val name: String,
        val value: String
) : Parcelable {
    override fun toString(): String {
        return "$name $value"
    }
}