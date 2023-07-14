package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    // declaring the views and array list
    private lateinit var editText: EditText // Input field for new items
    private lateinit var addButton: Button // Button to add new items
    private lateinit var listView: ListView // List view to display items
    private lateinit var items: ArrayList<String> // Data source for items

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialize the views and data source
        editText = findViewById(R.id.editText)
        addButton = findViewById(R.id.button)
        listView = findViewById(R.id.list_view)
        items = ArrayList()

        // Set up adapter to connect data source with list view
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)

        //setting the adapter to the list view
        listView.adapter = adapter

        // Set onClickListener for the add button
        addButton.setOnClickListener {
            val newItem = editText.text.toString()
            if (newItem.isNotEmpty()) {
                items.add(newItem)
                adapter.notifyDataSetChanged() // Notify adapter of data change
                editText.text.clear() // Clear input field
            }
        }

        // Set click listener for removing an item from the list
        listView.setOnItemClickListener { _, _, position, _ ->
            items.removeAt(position) // removes the item from the array list at the 'position'
            adapter.notifyDataSetChanged() // Notify adapter of data change
            true// set to true to indicate that the long click was handled
        }

    }
}


