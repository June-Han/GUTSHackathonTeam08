package com.team08.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_chat.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap


class ChatActivity : AppCompatActivity() {

    //private var layoutManager: RecyclerView.LayoutManager? = null
    //private var adapter: RecyclerView.Adapter<ChatRecycleAdapter.ViewHolder>? = null

    lateinit var chatRecords : Array<Chat>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_chat)
        val txtMessage: TextView = findViewById(R.id.txtMessage)
        SyncData()
    }

    fun SyncData() {
        var layoutManager: RecyclerView.LayoutManager? = null
        var adapter: RecyclerView.Adapter<ChatRecycleAdapter.ViewHolder>? = null
        // Instantiate the RequestQueue.
        val linkTrang = "https://melody-0f6f.restdb.io/rest/chat"

        val queue = Volley.newRequestQueue(this)

        val stringRequest = object: StringRequest(Request.Method.GET, linkTrang,
            Response.Listener<String> { response ->
                chatRecords = Gson().fromJson(response.toString(), Array<Chat>::class.java)
                layoutManager = LinearLayoutManager(this)
                recyclerViewChatPlaceholder.layoutManager = layoutManager
                adapter = ChatRecycleAdapter(chatRecords)
                recyclerViewChatPlaceholder.adapter = adapter
                recyclerViewChatPlaceholder.scrollToPosition(chatRecords.size - 1);

                scroll.post(Runnable { scroll.fullScroll(View.FOCUS_DOWN) })
            },
            Response.ErrorListener { })
        {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["x-apikey"] = "601ea9303f9eb665a16891f0"
                return headers
            }
        }
        queue.add(stringRequest)
    }

    fun SendMessage(view: View) {
        if (txtMessage.text.toString() != "") {
            val linkTrang = "https://melody-0f6f.restdb.io/rest/chat"
            val queue = Volley.newRequestQueue(this)
            val stringRequest = object: StringRequest(Request.Method.POST, linkTrang,
                Response.Listener<String> { response ->
                    Log.d("ChatActivity", "Response is: " + response.toString())
                    txtMessage.setText("")
                    SyncData()
                },
                Response.ErrorListener { })
            {
                override fun getHeaders(): MutableMap<String, String> {
                    val headers = HashMap<String, String>()
                    headers["x-apikey"] = "601ea9303f9eb665a16891f0"
                    return headers
                }

                override fun getBodyContentType(): String {
                    return "application/json"
                }

                override fun getBody(): ByteArray {
                    //txtMessage.text.toString().replace("\"", "")
                    val sdf = SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.ENGLISH)
                    val tz: TimeZone = TimeZone.getTimeZone("Asia/Singapore")
                    val date = Date()
                    val strDate = sdf.format(date)
                    var payload = "{\"Message\":\"" + txtMessage.text.toString() +  "\",\"Username\":\"Anonymous \",\"Timestamp\":\"" +  strDate  + "\"}"
                    return payload.toByteArray()
                }
            }
            queue.add(stringRequest)
        }
    }
}