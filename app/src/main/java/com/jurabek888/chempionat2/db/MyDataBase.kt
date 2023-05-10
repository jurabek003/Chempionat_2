package com.jurabek888.chempionat2.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.jurabek888.chempionat2.Models.User

class MyDataBase(context: Context):SQLiteOpenHelper(context, DB_NAME,null,1),MyInterfase{

    companion object{
        const val DB_NAME="allambalo"
        const val TABLE_NAME="table_name"
        const val ID="id"
        const val NAME="name"
        const val DATA="data"
        const val ISCHEKKED="ischeked"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val query="create table $TABLE_NAME($ID integer not null primary key autoincrement unique,$NAME  text not null, $DATA text not null,$ISCHEKKED integer not null )"
        p0?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    override fun addItem(user: User) {
        val db=writableDatabase
        val values=ContentValues()
        values.put(NAME,user.name)
        values.put(DATA,user.data)
        values.put(ISCHEKKED,user.ischekked)
        db.insert(TABLE_NAME,null,values)
        db.close()
    }

    override fun getItem(): ArrayList<User> {
        val db=readableDatabase
        val query="select *from $TABLE_NAME"
        val list=ArrayList<User>()
        val cursor=db.rawQuery(query,null)
        if (cursor.moveToFirst()){
            do {
                list.add(User(
                  cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3)
                ))
            }while (cursor.moveToNext())
        }


        return list
    }

}