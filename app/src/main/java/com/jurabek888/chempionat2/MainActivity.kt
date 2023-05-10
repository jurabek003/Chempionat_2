package com.jurabek888.chempionat2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.RawContacts.Data
import androidx.appcompat.app.AlertDialog
import com.jurabek888.chempionat2.Models.User
import com.jurabek888.chempionat2.adabter.Chekked
import com.jurabek888.chempionat2.adabter.MyRVadapter
import com.jurabek888.chempionat2.databinding.ActivityMainBinding
import com.jurabek888.chempionat2.databinding.DialogItemBinding
import com.jurabek888.chempionat2.db.MyDataBase
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var myRVadapter: MyRVadapter
    private lateinit var myDataBase: MyDataBase
    private lateinit var list: ArrayList<User>
    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadData()

        binding.btnAdd.setOnClickListener {
            val dialog=AlertDialog.Builder(this).create()
            val dialogItemBinding=DialogItemBinding.inflate(layoutInflater)
            dialog.setView(dialogItemBinding.root)
            dialog.show()

            dialogItemBinding.btnSave.setOnClickListener {
                val user= User(dialogItemBinding.edtName.text.toString())
                myDataBase.addItem(user)
                loadData()
                dialog.cancel()
            }

        }

    }

    private fun loadData() {
        myDataBase= MyDataBase(this)
        list= ArrayList()
        list.addAll(myDataBase.getItem())
        myRVadapter=MyRVadapter(list,object :Chekked{
            override fun chekkeds(user: User, position: Int) {
                list[position].ischekked=1
            }
        })
        binding.rv.adapter=myRVadapter
        binding.rv.scrollToPosition(12)
        myRVadapter.notifyDataSetChanged()
    }
}