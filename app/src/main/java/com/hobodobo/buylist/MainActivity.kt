package com.hobodobo.buylist

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.hobodobo.buylist.grocery.Grocery
import com.hobodobo.buylist.grocery.GroceryAdapter
import com.hobodobo.buylist.grocery.GroceryData

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var groceryData: GroceryData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val adapter = GroceryAdapter()
        groceryData = GroceryData(adapter)
        groceryData.setup()
        recyclerview_main.adapter = adapter
        recyclerview_main.layoutManager = LinearLayoutManager(this)

        fab.setOnClickListener { view ->
            val text = edt_grocery_title.text.toString()
            groceryData.writeNewGrocery(text, text)

            Snackbar.make(view, "Added grocery", Snackbar.LENGTH_LONG).show()
        }

        btn_grocery_delete.setOnClickListener {
            groceryData.clearGroceries()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
