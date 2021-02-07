package com.team08.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckedTextView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text


class ChatRecycleAdapter(private val chatRecords: Array<Chat>): RecyclerView.Adapter<ChatRecycleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatRecycleAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.chat_card_layout, parent, false)
        return ViewHolder((v))
    }

    override fun getItemCount(): Int {
        return chatRecords.size
    }

    override fun onBindViewHolder(holder: ChatRecycleAdapter.ViewHolder, position: Int) {
        //holder.groceryCheckedTextView.isChecked = groceryCheckInitialisation[position]
        //holder.groceryCheckedTextView.text = groceryTitle[position]
        holder.chatUsernameTextView.text = chatRecords[position].Username
        holder.chatTimestampTextView.text =  chatRecords[position].Timestamp
        holder.chatRecordTextView.text = chatRecords[position].Message
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var chatUsernameTextView: TextView
        var chatTimestampTextView: TextView
        var chatRecordTextView: TextView


        init {
            chatUsernameTextView = itemView.findViewById(R.id.txtChatUsername)
            chatTimestampTextView = itemView.findViewById(R.id.txtChatTimestamp)
            chatRecordTextView = itemView.findViewById(R.id.txtChatPlaceHolder)
            chatUsernameTextView.setOnClickListener() {
                isTyping = false
            }
            chatTimestampTextView.setOnClickListener() {
                isTyping = false
            }
            chatRecordTextView.setOnClickListener() {
                isTyping = false
            }
        }
    }
}