package br.com.knowledge.capitulo7_mvp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.knowledge.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.capitulo7_item_2.view.*


class BandeieraAdapter(
    var listMessages: ArrayList<Bandeiras>,
    var context: Context
):RecyclerView.Adapter<VH>() {

    lateinit var onItemLisnter: OnItemListener

    var mItemSel = -1

    interface OnItemListener{
        fun onShowSelected(adapter: BandeieraAdapter)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.capitulo7_item_2, parent, false)
        val vh = VH(v).apply {
            onItemLisnter = this
        }
        return vh
    }

    override fun getItemCount() = listMessages?.size

    @SuppressLint("NewApi")
    override fun onBindViewHolder(holder: VH, position: Int) {
        val bandeira = listMessages[position]
        holder.itemView.tv_name_bank.text = bandeira.name
        holder.onShowSelected(this)
        if(mItemSel == position){
            holder.itemView.setBackgroundResource(R.drawable.ft_frag_02_item_selector_uncheck)
        }else{
            holder.itemView.setBackgroundResource(R.drawable.ft_frag_02_item_selector_check)
        }
    }

}

class VH(itemView: View) : RecyclerView.ViewHolder(itemView), BandeieraAdapter.OnItemListener {


    override fun onShowSelected(adapter: BandeieraAdapter) {
        var listener: View.OnClickListener = View.OnClickListener {
            adapter.mItemSel = adapterPosition
            adapter!!.notifyDataSetChanged()
            itemView.setBackgroundResource(R.drawable.ft_frag_02_item_selector_uncheck)

        }
        itemView.setOnClickListener(listener)
    }

}


