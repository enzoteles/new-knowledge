package br.com.knowledge.capitulo7_mvp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.capitulo7_item.view.*
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.util.Base64
import android.annotation.SuppressLint
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import br.com.knowledge.R
import br.com.knowledge.capitulo8_fragment.util.LogWrapperUtil
import kotlinx.android.synthetic.main.capitulo2.view.*


class BandeieraAdapter(
    var listMessages: ArrayList<Bandeiras>,
    var context: Context
):
    RecyclerView.Adapter<VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.capitulo7_item, parent, false)
        val vh = VH(v)

        vh.itemView.setOnClickListener {
            val message = listMessages[vh.adapterPosition]
        }

        return vh

    }

    override fun getItemCount() = listMessages?.size

    @SuppressLint("NewApi")
    override fun onBindViewHolder(holder: VH, position: Int) {
        val bandeira = listMessages[position]
        holder.itemView.rdButton.text = bandeira.name
        //holder.itemView.rdButton.setButtonDrawable(Drawable.createFromPath("https://pbs.twimg.com/profile_images/2227101468/enzo_400x400.jpg"))


    }

    fun StringToBitMap(encodedString: String): Bitmap? {
        try {
            val encodeByte = Base64.decode(encodedString, Base64.DEFAULT)
            return BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.size)
        } catch (e: Exception) {
            e.message
            return null
        }

    }

}

class VH(itemView: View) : RecyclerView.ViewHolder(itemView)

