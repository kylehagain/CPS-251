package com.example.contactsproject

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactsproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var adapter: ContactListAdapter? = null
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listenerSetup()
        oberseverSetup()
        recyclerSetup()
    }

    private fun clearFields(){
        binding.editTextText.setText("")
        binding. editTextText2.setText("")
    }

    private fun listenerSetup(){
        binding.buttonAdd.setOnClickListener{
            val name = binding.editTextText.text.toString()
            val number = binding.editTextText2.text.toString()

            if (name != "" && number != ""){
                val contact = Contact(name, number)
                viewModel.insertContact(contact)
                Log.d("Contacts", "Contact sent on its way!")
                clearFields()
            }else{
                binding.editTextText.hint = "Incomplete Information!"
            }
        }

        binding.buttonFind.setOnClickListener {
            viewModel.findContact(binding.editTextText.text.toString())
        }
        binding.buttonDelete.setOnClickListener {
            viewModel.deleteContact(binding.editTextText.text.toString())
            clearFields()
        }
    }

    private fun oberseverSetup(){
        viewModel.getAllContacts()?.observe(this) { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        }
        viewModel.getSearchResults().observe(this) { contacts ->
            contacts?.let {
                if (it.isNotEmpty()) {
                    binding.feedbackMessage.text = "Search is working, but no data obtained"
                } else {
                    binding.feedbackMessage.text = "No Match and/or Empty"
                }
            }
        }
    }

    private fun recyclerSetup(){
        adapter = ContactListAdapter(R.layout.card_layout)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }
}