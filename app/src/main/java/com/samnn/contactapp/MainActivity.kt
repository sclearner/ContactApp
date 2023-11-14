package com.samnn.contactapp

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.samnn.contactapp.adapters.ListContactAdapter
import com.samnn.contactapp.models.Contact

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contacts = arrayListOf<Contact>()
        val contactListView: RecyclerView = findViewById(R.id.contact_list)
        repeat(100) {
            val name = "${(65..90).random().toChar()} Rapper"
            val contact = Contact("13u2394698289", name, "hello@gmail.com", "0123456789")
            contacts.add(contact)
        }

        contactListView.layoutManager = LinearLayoutManager(this)
        contactListView.adapter = ListContactAdapter(this, contacts)
        registerForContextMenu(contactListView)
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View,
                                     menuInfo: ContextMenu.ContextMenuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.hold_action, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        return when (item.itemId) {
            R.id.call -> {
                true
            }
            R.id.message -> {
                true
            }
            R.id.email -> true
            else -> super.onContextItemSelected(item)
        }
    }
}