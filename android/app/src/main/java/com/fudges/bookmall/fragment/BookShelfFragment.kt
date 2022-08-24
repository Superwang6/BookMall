package com.fudges.bookmall.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.fudges.bookmall.R
import com.fudges.bookmall.adapter.BookAdapter
import com.fudges.bookmall.entity.Book
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class BookShelfFragment : Fragment() {

    private val MSG_QUERY_BOOKLIST = 0
    private lateinit var recyclerView: RecyclerView
    private lateinit var bookList: List<Book>

    private val handler = object: Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            when(msg.what) {
//                MSG_QUERY_BOOKLIST -> bookList =
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.book_shelf_fragment, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        initRecyclerView(view)

        return view
    }

    private fun initRecyclerView(view: View) {
        val layoutManager = LinearLayoutManager(view.context)
        val bookList = initBookList()
        recyclerView.layoutManager = layoutManager
        val bookAdapter = BookAdapter(bookList)
        recyclerView.adapter = bookAdapter
    }

    private fun initBookList():List<Book> {
//        val bookList:ArrayList<Book> = ArrayList()
//        val bookImageUrl = "https://ts1.cn.mm.bing.net/th/id/R-C.901f8ebdab22d065baefeae6c2701cc0?rik=Z3Hew18zFaF%2bLQ&riu=http%3a%2f%2fwww.pp3.cn%2fuploads%2f20120418lw%2f13.jpg&ehk=Es5ZGH90h%2foCghvlIwdKfUiqpO05gLSgOEBU2i0Mwok%3d&risl=&pid=ImgRaw&r=0"
//        repeat(3) {
//            bookList.add(Book(bookImageUrl,"深空彼岸1","辰东1",141,0,"第132章 神奇的地域1"))
//            bookList.add(Book(bookImageUrl,"深空彼岸2","辰东2",111,1,"第111章 神奇的地域2"))
//            bookList.add(Book(bookImageUrl,"深空彼岸3","辰东3",1261,2,"第51章 神奇的地域3"))
//        }
        thread {
            var connection: HttpURLConnection? = null
            try {
                val response = StringBuilder()
                val url = URL("https://www.baidu.com")
                connection = url.openConnection() as HttpURLConnection
                connection.connectTimeout = 8000
                connection.readTimeout = 8000
                val inputStream = connection.inputStream
                val reader = BufferedReader(InputStreamReader(inputStream))
                reader.use {
                    reader.forEachLine {
                        response.append(it)
                    }
                }
                showResponse(response.toString())
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                connection?.disconnect()
            }

        }

        return bookList
    }

    private fun showResponse(response: String) {

    }


}
