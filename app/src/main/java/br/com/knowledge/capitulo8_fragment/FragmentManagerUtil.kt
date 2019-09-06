package br.com.knowledge.capitulo8_fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


object FragmentManagerUtil : OnFragmentManager {

    var transaction: FragmentTransaction? = null

    /**
     * método para adiciionar um fragment no backstack
     * */
    override fun addFragment(
        layoutId: Int,
        fragment: Fragment,
        tag: String,
        backStack: Boolean,
        manager: FragmentManager
    ) {

        transaction = manager.beginTransaction().apply {
            add(layoutId, fragment, tag)
            if (backStack) addToBackStack(null)
            commit()
        }
    }

    /**
     * método para substituir um fragment no backstack
     * */
    override fun replaceFragment(
        layoutId: Int,
        fragment: Fragment,
        tag: String,
        backStack: Boolean,
        manager: FragmentManager
    ) {
        transaction = manager.beginTransaction().apply {
            replace(layoutId, fragment, tag)
            if (backStack) addToBackStack(null)
            commit()
        }

    }

    /**
     * método para remover um fragment no backstack
     * */
    override fun removeFragment(
        fragment: Fragment,
        manager: FragmentManager
    ) {
        transaction = manager.beginTransaction().apply {
            remove(fragment)
            commit()
        }
    }
}