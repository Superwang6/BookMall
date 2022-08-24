package com.fudges.bookmall.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fudges.bookmall.R
import com.fudges.bookmall.entity.Book

class BookAdapter(val bookList: List<Book>) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val bookImg: AppCompatImageView = view.findViewById(R.id.bookImg)
        val bookName: TextView = view.findViewById(R.id.bookName)
        val state: TextView = view.findViewById(R.id.state)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.book_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = bookList[position]
        Glide.with(holder.itemView).load(book.bookImage).into(holder.bookImg)
        val bookNameStr = "${book.author}·${book.notReadNumber}章未读"
        holder.bookName.text = bookNameStr
        val bookState = when(book.state) {
            0 -> "未连载"
            1 -> "连载"
            2 -> "完结"
            else -> ""
        }
        val state = "${bookState}·${book.newChapterName}"
        holder.state.text = state
    }


}