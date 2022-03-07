package com.test.synchronyapp.models.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile")
class UserProfileEntity (
    @PrimaryKey(autoGenerate = true)@ColumnInfo(name = "id")val id: Int = 0,
    @ColumnInfo(name = "fname")val fName: String?,
    @ColumnInfo(name = "lname")val lName: String?,
    @ColumnInfo(name = "email")val email: String?,
    @ColumnInfo(name = "phone")val phone: String?,
    @ColumnInfo(name = "education")val education: String?,
    @ColumnInfo(name = "work")val work: String?,
    @ColumnInfo(name = "about")val about: String?,
    @ColumnInfo(name = "image")val image: String?
)