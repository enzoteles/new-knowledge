package br.com.myapp

class MainRepository: OnMainPresenter.Repository {

    companion object{
        fun create(): MainRepository {
            return MainRepository()
        }
    }
}