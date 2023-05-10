package com.jurabek888.chempionat2.Models

import java.text.SimpleDateFormat
import java.util.Date

class User {
    var id:Int?=null
    var name:String?=null
    var ischekked:Int=0
    var data:String=SimpleDateFormat("dd.MM.yyyy ⌚ HH:mm:ss").format(Date())


    constructor(name: String?) {
        this.name = name
        this.data = data
    }

    constructor(id: Int?, name: String?, data: String, ischekked:Int) {
        this.id = id
        this.name = name
        this.data = data
        this.ischekked=ischekked
    }


}