package com.teamttdvlp.memolang.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.teamttdvlp.memolang.R
import com.teamttdvlp.memolang.model.model.Flashcard

class RecentSearchFlashcardRCVAdapter (var context : Context, var list : ArrayList<Flashcard> = ArrayList()) : RecyclerView.Adapter<RecentSearchFlashcardRCVAdapter.ViewHolder> () {

    private var onItemClickListener : OnItemClickListener? = null

    class ViewHolder (item : View): RecyclerView.ViewHolder(item) {
        var txtText = item.findViewById<TextView>(R.id.txt_text)
        var txtTranslation = item.findViewById<TextView>(R.id.txt_language)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recent_search_flashcard_rcv, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.txtText.text = item.text
        holder.txtTranslation.text = item.translation
        holder.itemView.setOnClickListener {
                onItemClickListener?.onClick(item)
        }
    }

    fun setOnItemClickListener (onItemClickListener: (item: Flashcard) -> Unit) {
        this.onItemClickListener = object : OnItemClickListener {
            override fun onClick(item: Flashcard) {
                onItemClickListener(item)
            }
        }
    }

    fun setOnItemClickListener (onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    fun setData (dataList : ArrayList<Flashcard>) {
        list = dataList
        notifyDataSetChanged()
    }

    fun addFlashcardAtTheFirstPosition (newFlashcard : Flashcard) {
        list.add(0, newFlashcard)
        notifyItemInserted(0)
    }

    fun addFlashcard (newFlashcard : Flashcard) {
        list.add(newFlashcard)
        notifyItemInserted(list.size - 1)
    }

    override fun getItemCount(): Int = list.size

    interface OnItemClickListener {
        fun onClick (item : Flashcard)
    }
}