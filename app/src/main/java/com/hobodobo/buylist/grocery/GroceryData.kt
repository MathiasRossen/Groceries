package com.hobodobo.buylist.grocery

import android.util.Log
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase

class GroceryData(val adapter: GroceryAdapter) {
    private val database = FirebaseDatabase.getInstance().reference

    fun setup() {
        val childListener = object : ChildEventListener {
            override fun onChildAdded(dataSnapshot: DataSnapshot, previousChildName: String?) {
                val grocery = dataSnapshot.getValue(Grocery::class.java)

                if (grocery != null) {
                    adapter.items.add(grocery)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onChildChanged(dataSnapshot: DataSnapshot, previousChildName: String?) {
                Log.d("HEST", "onChildChanged: ${dataSnapshot.key}")
            }

            override fun onChildMoved(dataSnapshot: DataSnapshot, previousChildName: String?) {
                Log.d("HEST", "onChildMoved:" + dataSnapshot.key!!)
            }

            override fun onChildRemoved(dataSnapshot: DataSnapshot) {
                val grocery = dataSnapshot.getValue(Grocery::class.java)

                if (grocery != null) {
                    adapter.items.remove(grocery)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("HEST", "postComments:onCancelled", error.toException())
            }
        }

        database.child("groceries").addChildEventListener(childListener)
    }

    fun writeNewGrocery(title: String, description: String) {
        val key = database.child("groceries").push().key
        if (key == null) {
            Log.w("HEST", "Couldn't get push key for posts")
            return
        }

        val grocery = Grocery(title, description)
        val groceryValues = grocery.toMap()

        val childUpdates = HashMap<String, Any?>()
        childUpdates["groceries/$key"] = groceryValues

        database.updateChildren(childUpdates)
    }

    fun clearGroceries(){
        database.child("groceries").removeValue()
    }
}