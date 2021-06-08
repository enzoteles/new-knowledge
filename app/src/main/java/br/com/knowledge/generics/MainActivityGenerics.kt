package br.com.knowledge.generics

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.knowledge.R
import br.com.myapp.*

class MainActivityGenerics : AppCompatActivity(), OnMainPresenter.View {
    
    var listUsers: ArrayList<User> = ArrayList()
    var listBank: ArrayList<Bank> = ArrayList()

    val presenter = MainPresenterGenerics<OnMainPresenter.View, OnMainPresenter.Repository>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView4()


    }

    private fun initView4() {

        val map: MutableMap<Int, Triple<Int, Int, Int>> = mutableMapOf(
            1 to Triple(7, 6, 2021),
            2 to Triple(2, 6, 2020)
        )

        map.forEach {
            if(it.key == 1){
                Log.i("TRIPLE", "${map[it.key]?.third}")
            }
        }

        val paramsList = ArrayList<Pair<String, String>>()
        paramsList.add(Pair("data de contrataçao", "23/06/2021"))
        paramsList.add(Pair("data de contrataçao", "23/06/2021"))
        paramsList.add(Pair("data de contrataçao", "23/06/2021"))
        paramsList.add(Pair("data de contrataçao", "23/06/2021"))

        val mm = mapOf(
            "Data de contrataçao" to "12/02/2021",
            "Teste" to "12/02/2021"
        )

        val list = ArrayList<Pair<String, String>>()

        mm.forEach {
            list.add(Pair(it.key, it.value))
        }
        Log.i("SIZE", "${list.size}")

    }

    private fun populateBanck() {

        val bank1 = Bank("8777", "258757", "Itaú")
        val bank2 = Bank("8777", "258757", "Bradesco")
        val bank3 = Bank("8777", "258757", "Banco do Brasil")
        listBank.add(bank1)
        listBank.add(bank1)
        listBank.add(bank1)
        listBank.add(bank2)
        listBank.add(bank2)
        listBank.add(bank2)
        listBank.add(bank2)
        listBank.add(bank3)
        listBank.add(bank3)
        listBank.add(bank3)
        listBank.add(bank3)
        listBank.add(bank3)
        listBank.add(bank3)

        val listaBankCustom = listBank.map { itBank->
            BackCustom(
                agenciaCustom = itBank.agencia,
                contaCustom = "${itBank.conta} -5",
                nomeBancoCustom = itBank.nomeBanco,
                data = itBank
            )
        }

        val ftsucessBS = RadioButtomBT.newInstance(listaBankCustom)
        ftsucessBS.show(supportFragmentManager, RadioButtomBT::class.java.simpleName)
    }

    private fun initView() {
        var a = User("Enzo", 1)
        var b = User("Teles", 38)
        var c = User("Carvalho", 39)


        listUsers.add(a)
        listUsers.add(b)
        listUsers.add(c)
        
        loadListUser(listUsers)


    }

    private fun loadListUser(listUsers: ArrayList<User>) {
       loadCustoUser(listUsers.map { itUserCustom->
           UserCustom(
               nameCustom = itUserCustom.name,
               ageCustom = itUserCustom.age,
               dataCustom = itUserCustom
           )
       })

    }

    private fun loadCustoUser(usersList: List<UserCustom<User>>) {

        usersList.forEach { itModel->
            Log.i("USER=====", itModel.nameCustom)
        }

    }

    private fun initView2() {

        val CIELO = 0
        val MARKET = 1

        var mapUser : mutableMapUserCustom = mutableMapOf(
            CIELO to listOf(
                UserCustom("Enzo", 38, User("Enzo", 38)),
                UserCustom("Teles", 34, User("Enzo", 38))
            ),
            MARKET to listOf(
                UserCustom("Daniele", 1, User("Daniele", 1)),
                UserCustom("Daniele", 1, User("Daniele", 1))
            )

        )


        mapUser?.forEach {
            if (it.key == MARKET){
                Log.i("LISTTELES", it.value[it.key].toString())
            }
        }


    }

    private fun initView3() {
        presenter.initView(this, MainRepository.create())
        presenter.loadName()
        presenter.itemInteface = object : MainPresenterGenerics.OnclickListenerSAM{
            override fun execute() {
                TODO("Not yet implemented")
            }
        }
    }



    override fun showResponse() {
        Log.i("USER", "Response")
    }
}





data class User(val name:String, val age:Int)

data class UserCustom<T>(val nameCustom:String, val ageCustom: Int, val dataCustom: T)

data class Bank(val agencia: String, val conta: String, val nomeBanco:String)
data class BackCustom<T>(val agenciaCustom:String, val contaCustom:String, val nomeBancoCustom:String, val data:T)


