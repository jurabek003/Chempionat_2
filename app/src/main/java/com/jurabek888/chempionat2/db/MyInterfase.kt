package com.jurabek888.chempionat2.db

import com.jurabek888.chempionat2.Models.User

interface MyInterfase {
    fun addItem(user: User)
    fun getItem():ArrayList<User>

}