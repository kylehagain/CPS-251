package com.example.contactsproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ContactRepository = ContactRepository(application)
    private val allContacts: LiveData<List<Contact>>?
    private val searchResults: MutableLiveData<List<Contact>>

    init {
        allContacts = repository.allContacts
        searchResults = repository.searchResults
    }

    fun insertContact(contact: Contact) {
        repository.insertContact(contact)
    }
    fun findContact(name: String) {
        repository.findContact(name)
    }
    fun deleteContact(name: String) {
        repository.deleteContact(name)
    }
    fun getSearchResults(): MutableLiveData<List<Contact>> {
        return searchResults
    }
    fun getAllContacts(): LiveData<List<Contact>>? {
        return allContacts
    }








    /*
    fun insertContact(contact: Contact) {
        contactRepository.insertContact(contact)
    }

    fun searchContactsByName(name: String): List<Contact>? {
        // Assuming you have a LiveData<List<Contact>> method in your repository for searching by name
        return contactRepository.searchContactsByName(name)
    }

    fun deleteContactById(id: Long) {
        // You can add a similar method in your repository to delete by ID if needed
        contactRepository.deleteContactById(id)
    }

    fun getAllContacts(): List<Contact>? {
        // Assuming you have a LiveData<List<Contact>> method in your repository for getting all contacts
        return contactRepository.getAllContacts()
    }
*/
}
