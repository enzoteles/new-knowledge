package br.com.knowledge.capitulo2_laoyout

import android.content.Context
import android.widget.TextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView
import br.com.knowledge.R


class CustomAdapter(private val dataSet: ArrayList<String>, internal var mContext: Context) :
    ArrayAdapter<String>(mContext, R.layout.row_item, dataSet) {

    // View lookup cache
    private class ViewHolder {
        internal var txtName: TextView? = null

    }

    @Nullable
    override fun getItem(position: Int): String? {
        return dataSet.get(position)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView

        val viewHolder: ViewHolder // view lookup cache stored in tag

        if (convertView == null) {

            viewHolder = ViewHolder()
            val inflater = LayoutInflater.from(context)
            convertView = inflater.inflate(R.layout.row_item, parent, false)
            viewHolder.txtName = convertView!!.findViewById(R.id.name)
            convertView!!.setTag(viewHolder)
        } else {
            viewHolder = convertView!!.getTag() as ViewHolder
        }

        viewHolder.txtName!!.text = getItem(position)
        // Return the completed view to render on screen
        return convertView
    }
}

