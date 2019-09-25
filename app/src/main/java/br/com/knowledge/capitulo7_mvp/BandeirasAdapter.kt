package br.com.knowledge.capitulo7_mvp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.knowledge.R
import kotlinx.android.synthetic.main.capitulo7_item.view.*




class BandeieraAdapter(
    var listMessages: ArrayList<Bandeiras>,
    var context: Context
):RecyclerView.Adapter<VH>() {

    companion object{
        var mSelectedItem:Int = -1
        var adapterB : BandeieraAdapter ?= null
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.capitulo7_item, parent, false)
        adapterB = this
        val vh = VH(v)

        return vh

    }

    override fun getItemCount() = listMessages?.size

    @SuppressLint("NewApi")
    override fun onBindViewHolder(holder: VH, position: Int) {
        val bandeira = listMessages[position]
        holder.itemView.rdButton.text = bandeira.name
        holder.itemView.rdButton.isChecked = (position == mSelectedItem)
        holder.loadData()

    }

}

class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun loadData() {
        var listener: View.OnClickListener = View.OnClickListener {
            BandeieraAdapter.mSelectedItem = adapterPosition
            BandeieraAdapter.adapterB!!.notifyDataSetChanged()

        }
        itemView.rdButton.setOnClickListener(listener)
        itemView.setOnClickListener(listener)

    }
}


