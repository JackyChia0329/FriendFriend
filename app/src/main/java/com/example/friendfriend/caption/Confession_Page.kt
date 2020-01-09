package com.example.friendfriend.caption

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.friendfriend.R
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_confession__page.*

class Confession_Page : AppCompatActivity() {


    lateinit var ref: DatabaseReference
    //    lateinit var db:DatabaseReference
    val TAG = "MainActivity"

    val mId = arrayListOf<String>()
    val mCap = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
//        ref = FirebaseDatabase.getInstance().getReference("Captions")
//        ref.keepSynced(true)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confession__page)
        Log.d(TAG,"on create start")
//        Thread.sleep(5000)
        initCaption()
        floatingButton.setOnClickListener(){
            createCaption()
        }


    }

    private fun createCaption(){
        var exampleCaption = ExampleCaption()
        exampleCaption.show(supportFragmentManager,"example caption")
    }
    private fun initCaption(){

//        ref.addValueEventListener(object: ValueEventListener {
//            override fun onCancelled(p0: DatabaseError) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onDataChange(p0: DataSnapshot) {
//
//                mId.clear()
//                mCap.clear()
//
//                if(p0.exists()){
//                    for (h in p0.children) {
//
//                        val caption = h.getValue(Caption::class.java)
//                        mId.add(caption?.id.toString())
//                        mCap.add(caption!!.caption)
//                    }
//                }}
//        })
        mId.add("123")
        mCap.add("123")
        initRecyclerView()

    }
    private fun initRecyclerView(){

        Log.d(TAG,"init recyclerview")
        val  recyclerView  =findViewById<RecyclerView>(R.id.cap_recyclerView)
        val adapter = RecylcerViewAdapter(this,mId,mCap)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
