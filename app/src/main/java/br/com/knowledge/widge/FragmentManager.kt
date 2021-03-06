package br.com.knowledge.widge

import android.animation.Animator
import android.animation.ValueAnimator
import android.util.Log
import android.view.animation.DecelerateInterpolator
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction


class ManagerFragment constructor(activity: WidgeActvity) {
    var activity: WidgeActvity
    private var fragment: Fragment? = null
    private var transaction: FragmentTransaction? = null
    private var tag: String? = null
    private var backstack = false
    private var layout = 0

    init {
        this.activity = activity
    }


    fun tag(tag: String?): ManagerFragment {
        this.tag = tag
        return this
    }

    fun backstack(backstack: Boolean): ManagerFragment {
        this.backstack = backstack
        return this
    }

    fun layout(layout: Int): ManagerFragment {
        this.layout = layout
        return this
    }

    fun addFragment(fragment: Fragment?): ManagerFragment {
        this.fragment = fragment
        return this
    }

    fun build() {
        transaction = activity.supportFragmentManager.beginTransaction()
        transaction!!.add(layout, fragment!!, tag)
        transaction!!.commitAllowingStateLoss()
    }

    fun fadeAnimation(postAnimCallback: () -> Unit, error: () -> Unit) : String {
        val fadeAnimator = ValueAnimator.ofFloat(0.2f, 1f)

        fadeAnimator.addUpdateListener {
            val value = it.animatedValue as Float
            //view?.alpha = value
        }

        fadeAnimator.interpolator = DecelerateInterpolator(1.4f)
        fadeAnimator.duration = 400

        fadeAnimator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
                //empty
            }

            override fun onAnimationEnd(animation: Animator?) {
                postAnimCallback()
            }

            override fun onAnimationCancel(animation: Animator?) {
                //empty
            }

            override fun onAnimationStart(animation: Animator?) {
                //empty
            }
        })

        fadeAnimator.start()
        return ""
    }

}