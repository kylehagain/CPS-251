package com.example.contactsproject

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
class Contact {


    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "contactId")
    var id: Int = 0

    var name: String? = null
    var number: String? = null

    constructor(id: Int, name: String, number: String){
        this.id = id
        this.name = name
        this.number = number
    }

    constructor(name: String, number: String){
        this.name = name
        this.number = number
    }

    override fun toString(): String {
        return "Contact(id=$id, name=$name, number=$number)"
    }


}