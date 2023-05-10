package com.jurabek888.chempionat2.adabter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.jurabek888.chempionat2.Models.User
import com.jurabek888.chempionat2.databinding.ItemRvBinding

class MyRVadapter(val list: List<User>,val chekked: Chekked) :
    RecyclerView.Adapter<MyRVadapter.Vh>() {
    inner class Vh(val itemRvBinding: ItemRvBinding) : ViewHolder(itemRvBinding.root) {
        fun onBind(user: User,position: Int) {
           itemRvBinding.itemName.text=user.name.toString()
            itemRvBinding.itemData.text = user.data.toString()

            val chek= itemRvBinding.chekBtn.isChecked

            if (itemRvBinding.chekBtn.isChecked){
                if (user.ischekked==0){
                    chekked.chekkeds(user,position)
                    user.ischekked=1
                }
                if (user.ischekked==1){
                    user.ischekked=0
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position],position)
    }


}
interface Chekked{
    fun chekkeds(user: User,position: Int)
}