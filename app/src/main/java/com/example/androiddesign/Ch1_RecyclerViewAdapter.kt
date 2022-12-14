package com.example.androiddesign

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddesign.databinding.ActivityCh1MainBinding
import org.w3c.dom.Text

class Ch1_RecyclerViewAdapter internal constructor(context : Context, var onDeleteListener : Ch1_MainViewModel) : RecyclerView.Adapter<Ch1_RecyclerViewAdapter.ViewHolder>() {
    private val inflater : LayoutInflater = LayoutInflater.from(context)
    private var users = emptyList<Ch1_Entity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = inflater.inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val num = users[position]
        holder.num1.text = num.number1
        holder.deleteButton.setOnClickListener(View.OnClickListener {
            onDeleteListener.deleteAll(num)
            return@OnClickListener
        })
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val num1 = itemView.findViewById<TextView>(R.id.text)
        val deleteButton = itemView.findViewById<Button>(R.id.delete_button)
    }

    internal fun setUsers(users : List<Ch1_Entity>) {
        this.users = users
        notifyDataSetChanged()
    }

    override fun getItemCount() = users.size

}