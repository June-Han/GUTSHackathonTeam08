package com.team08.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.View.OnFocusChangeListener
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.chat_card_layout.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

var isTyping = false

class ChatActivity : AppCompatActivity() {

    //private var layoutManager: RecyclerView.LayoutManager? = null
    //private var adapter: RecyclerView.Adapter<ChatRecycleAdapter.ViewHolder>? = null
    var haltFlag = false
    lateinit var chatRecords : Array<Chat>
    val mainHandler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.onActivityCreateSetTheme(this)
        setContentView(R.layout.activity_chat)
        val txtMessage: TextView = findViewById(R.id.txtMessage)
        SyncData()

        val themeNo = savedInstanceState?.getInt("ThemeNo", 0)
        if (themeNo != null) {
            Utils.changeToTheme(this, themeNo)
        }

        txtMessage.setOnClickListener() {
            isTyping = true
        }

        txtMessage.setOnFocusChangeListener(OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                isTyping = false
            } else {
                isTyping = true
            }
        })

        scroll.setOnClickListener() {
            isTyping = false
        }

        LinearLayoutChatHolder.setOnClickListener() {
            isTyping = false
        }

        recyclerViewChatPlaceholder.setOnClickListener() {
            isTyping = false
        }

        mainHandler.post(object : Runnable {
            override fun run() {
                SyncData()
                mainHandler.postDelayed(this, 4000)
            }
        })
    }

    fun chatBttnFn(view: View) {
        val intent1 = Intent(this, ChatActivity::class.java)
        startActivity(intent1)
    }

    fun quoteBttnFn(view: View) {
//        val intent2 = Intent(this, BackgroundSoundService::class.java)
//        startActivity(intent2)
    }

    fun musicBttnFn(view: View) {
        val intent3 = Intent(this, Music::class.java)
        startActivity(intent3)
    }

    fun helplineBttnFn(view: View) {
//        val intent4 = Intent(this, helpline::class.java)
//        startActivity(intent4)
    }


    fun SyncData() {
        if (!haltFlag)
        {
            haltFlag = true
            var layoutManager: RecyclerView.LayoutManager? = null
            var adapter: RecyclerView.Adapter<ChatRecycleAdapter.ViewHolder>? = null
            // Instantiate the RequestQueue.
            val linkTrang = "https://melody-0f6f.restdb.io/rest/chat"

            val queue = Volley.newRequestQueue(this)

            val stringRequest = object: StringRequest(Request.Method.GET, linkTrang,
                    Response.Listener<String> { response ->
                        if (!isTyping) {
                            chatRecords = Gson().fromJson(response.toString(), Array<Chat>::class.java)
                            layoutManager = LinearLayoutManager(this)
                            recyclerViewChatPlaceholder.layoutManager = layoutManager
                            adapter = ChatRecycleAdapter(chatRecords)
                            recyclerViewChatPlaceholder.adapter = adapter
                            recyclerViewChatPlaceholder.scrollToPosition(chatRecords.size - 1);
                            scroll.post(Runnable { scroll.fullScroll(View.FOCUS_DOWN) })
                        }
                        haltFlag = false
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
    }

    fun SendMessage(view: View) {
        haltFlag = false
        isTyping = false
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
                    var payload = "{\"Message\":\"" + txtMessage.text.toString() +  "\",\"Username\":\"" + name + "\",\"Timestamp\":\"" +  strDate  + "\"}"
                    return payload.toByteArray()
                }
            }
            queue.add(stringRequest)
        }
    }
}