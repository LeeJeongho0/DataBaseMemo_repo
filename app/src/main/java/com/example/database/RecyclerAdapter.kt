package com.example.database

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.database.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

class RecyclerAdapter : RecyclerView.Adapter<Holder>() {
    var listData = mutableListOf<Memo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val itemRecyclerBinding =  ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return Holder(itemRecyclerBinding)
    }

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val memo = listData.get(position)
        holder.setMemo(memo)
    }

}

class Holder(val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root){
    fun setMemo(memo: Memo){
        binding.tvNo.text = "${memo.no}"
        binding.tvContent.text = "${memo.content}"
        val sdf = SimpleDateFormat("yyyy/MM/dd hh:mm")
        val datetime = sdf.format(memo.datetime)
        binding.tvDatetime.text = "${datetime}"
    }
}