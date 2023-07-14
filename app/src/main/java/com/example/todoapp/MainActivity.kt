package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    // declaring views and array list
    private lateinit var editText: EditText
    private lateinit var addButton: Button
    private lateinit var listView: ListView
    private lateinit var items: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initializing the views and array list
        editText = findViewById(R.id.editText)
        addButton = findViewById(R.id.button)
        listView = findViewById(R.id.list_view)
        items = ArrayList()

        // we have decided to use adapter to connect the data source to the list view
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)

        //setting the adapter to the list view
        listView.adapter = adapter

        // setting on-click listener for the button
        addButton.setOnClickListener {
            val newItem = editText.text.toString()
            if (newItem.isNotEmpty()) {
                items.add(newItem)
                adapter.notifyDataSetChanged()// this notifies the adapter of data change
                editText.text.clear()// clears the input field
            }
        }

        // we decided to set an on-click-listener for removing an item from the list items
        listView.setOnItemClickListener { _, _, position, _ ->
            items.removeAt(position) // removes the item from the array list at the 'position'
            adapter.notifyDataSetChanged() // notify the adapter of the data change in the data source
            true// set to true to indicate that the long click was handled
        }

    }
}


