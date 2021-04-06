package com.example.homework2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main_menu.view.*
import kotlinx.android.synthetic.main.my_message.view.*

class RvAdapter(private val context: Context, private val myList: ArrayList<String>):RecyclerView.Adapter<RvAdapter.ViewHolder>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        val myListItem = if(position == 0){
            LayoutInflater.from(context).inflate(R.layout.my_message, viewGroup, false)
        } else {
            LayoutInflater.from(context).inflate(R.layout.buddys_message, viewGroup, false)
        }

        return ViewHolder(myListItem)
    }

    override fun getItemCount(): Int {
        return myList.count()
    }
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(myList[position])
    }

    override fun getItemViewType(position: Int) = position%3

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(myItem: String){
            itemView.tvMessage.text = myItem
        }
    }
}






