package br.com.knowledge.capitulo1.help.higherOrderFunction

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.knowledge.R
import br.com.knowledge.capitulo1.ApiCallbackRest
import br.com.knowledge.capitulo8_fragment.util.LogWrapperUtil
import kotlinx.android.synthetic.main.widge_example.*

class WidgeActvity : AppCompatActivity(), OnWidgeActvity.View {

    val presenter = PresenterHigher(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.widge_example)
        presenter.callApi(
            preExecute = { showProgress() },
            response = {txt_name.text = "SOPHIA MACHADO"},
            finished = {hideProgress()},
            failure = {Toast.makeText(this, "error", Toast.LENGTH_LONG).show()}
        )

    }



    override fun hideProgress() {
        progress.visibility = View.GONE
        txt_name.visibility = View.VISIBLE
    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
        txt_name.visibility = View.GONE
    }

}


class PresenterHigher(var mView: OnWidgeActvity.View) {
    val repo = RepositoroyHigher()



    fun callApi(
        //usando higher order funciton
        preExecute: () -> Unit = {},
        response:(response:String)->Unit = {},
        finished: () -> Unit = {},
        failure: ()->Unit = {}
    ){

        preExecute()
        //temos função lambada
        repo.callApi(object : ApiCallbackRest<String, String>{
            override fun onSuccess(resp: String) {
                Handler().postDelayed({
                    response(resp)
                    finished()
                }, 3000)
            }

            override fun onError(error: String) {
                LogWrapperUtil.error("error")
                failure()
            }

        })

    }


}


class RepositoroyHigher(){
    fun callApi(callback: ApiCallbackRest<String, String>) {
        callback.onSuccess("SUCESSO")
    }

}

interface OnWidgeActvity{
    interface View {
        fun hideProgress()
        fun showProgress()
    }
}