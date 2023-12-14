package com.example.contactsproject

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDao {

    @Insert
    fun insertContact(contact: Contact)

    @Query("SELECT * FROM contacts WHERE name LIKE '%' || :name || '%'")
    fun searchContactsByName(name: String): List<Contact>

    @Query("DELETE FROM contacts WHERE contactId = :id")
    fun deleteContactById(name: String)

    @Query("SELECT * FROM contacts")
    fun getAllContacts(): LiveData<List<Contact>>

// TODO
    @Query("SELECT * FROM contacts ORDER BY name ASC")
    fun getAllContactsSortedByNameAsc(): List<Contact>

// TODO
    @Query("SELECT * FROM contacts ORDER BY name DESC")
    fun getAllContactsSortedByNameDesc(): List<Contact>


}