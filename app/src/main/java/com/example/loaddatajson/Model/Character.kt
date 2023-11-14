package com.example.loaddatajson.Model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Character(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("slug")
    val slug:String,
    @SerialName("birthday")
    val birthday:String,
    @SerialName("gender")
    val gender: String,
    @SerialName("description")
    val description:String,
    @SerialName("vision")
    val vision: String,
    @SerialName("rarity")
    val rarity: Int,
    @SerialName("weapon")
    val weapon: String,
    @SerialName("obtain")
    val obtain:String,
)

