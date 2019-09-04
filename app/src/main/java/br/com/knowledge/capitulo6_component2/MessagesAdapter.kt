package br.com.knowledge.capitulo6_component2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.knowledge.R
import kotlinx.android.synthetic.main.item_msg.view.*


class MessagesAdapter(var listMessages: ArrayList<Message>, var callback:(Message)->Unit):
    RecyclerView.Adapter<VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_msg, parent, false)
        val vh = VH(v)

        vh.itemView.setOnClickListener {
            val message = listMessages[vh.adapterPosition]
            callback(message)
        }

        return vh

    }

    override fun getItemCount() = listMessages?.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val msg = listMessages[position]
        holder.itemView.tv_name_msg.text = msg.msg
    }

}

class VH(itemView: View) : RecyclerView.ViewHolder(itemView)

