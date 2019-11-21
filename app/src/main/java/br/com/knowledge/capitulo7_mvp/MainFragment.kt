package br.com.knowledge.capitulo7_mvp

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.TextAppearanceSpan
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager

import br.com.knowledge.R
import br.com.knowledge.capitulo8_fragment.util.LogWrapperUtil
import kotlinx.android.synthetic.main.fragment_main.*
import android.text.Html
import android.text.Spannable
import android.text.style.StyleSpan







private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainFragment : Fragment(), MainContract.View {


    lateinit var adapter: BandeieraAdapter
    var listBandeiras = ArrayList<Bandeiras>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      /*  val texto = "Jeitos de colocar <b>o texto negrito</b> em um TextView"

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            tv_bandeiras.setText(Html.fromHtml(texto, Html.FROM_HTML_MODE_LEGACY))
        } else {
            tv_bandeiras.setText(Html.fromHtml(texto))
        }*/

        val texto = SpannableStringBuilder()
        texto.append("Jeitos de colocar ")
        val start = texto.length
        texto.append("o texto negrito")
        texto.setSpan(
            StyleSpan(android.graphics.Typeface.BOLD), start,
            texto.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        texto.append(" em um TextView")

        tv_bandeiras.setText(texto)
    }

    private fun getTextFinal(): CharSequence? {

        var textFinal = SpannableStringBuilder()

        val string01 = "A bandeira selecionada será"
        val string02 = "transferida"
        val string03 = "para a nova conta, ou seja,"
        val string04 = "não estará mais habilidata"
        val string05 = "na conta anterior"

        textFinal.append(string01)
            .addSpannable(TextAppearanceSpan(requireActivity(), R.style.TextBannerMigration13spAC))

        textFinal.append(" ")

        textFinal.append(string02)
            .addSpannable(TextAppearanceSpan(requireActivity(), R.style.TextBannerMigration14spAC))

        textFinal.append(" ")

        textFinal.append(string03)
            .addSpannable(TextAppearanceSpan(requireActivity(), R.style.TextBannerMigration13spAC))

        textFinal.append(" ")

        textFinal.append(string04)
            .addSpannable(TextAppearanceSpan(requireActivity(), R.style.TextBannerMigration14spAC))

        textFinal.append(" ")

        textFinal.append(string05)
            .addSpannable(TextAppearanceSpan(requireActivity(), R.style.TextBannerMigration13spAC))

        textFinal.append(" ")

        return  textFinal
    }

    override fun showProgress() {
    }

    override fun hideProgress() {
    }

    override fun errorHttp() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadList(result: ArrayList<String>) {
        Log.i("testes", "teste")
    }
}
