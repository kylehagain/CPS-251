package com.example.contactsproject

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ContactRepository(application: Application) {

    private var contactDao: ContactDao?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allContacts: LiveData<List<Contact>>?
    val searchResults = MutableLiveData<List<Contact>>()

    init{
        val db: ContactRoomDatabase? =
            ContactRoomDatabase.getDatabase(application)
        contactDao = db?.contactDao()
        allContacts = contactDao?.getAllContacts()
    }

    fun insertContact(newcontact: Contact) {
        coroutineScope.launch(Dispatchers.IO){
            asyncInsert(newcontact)
            Log.d("Database", "${newcontact.toString()}")
            Log.d("Database", "New Contact Inserted!")
        }

    }
    private fun asyncInsert(contact: Contact){
        contactDao?.insertContact(contact)
    }

    fun deleteContact(name: String) {
        coroutineScope.launch(Dispatchers.IO){
            asyncDelete(name)
            Log.d("Database", "${name.toString()}")
            Log.d("Database", "New Contact Deleted!")
        }
    }
    private fun asyncDelete(name: String){
        contactDao?.deleteContactById(name)
    }

    fun findContact(name: String){
        coroutineScope.launch(Dispatchers.Main){
            searchResults.value = asyncFind(name).await()
        }
    }
    private fun asyncFind(name: String): Deferred<List<Contact>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async contactDao?.searchContactsByName(name)
        }
}