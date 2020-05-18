package br.com.knowledge.widge

import android.animation.Animator
import android.animation.ValueAnimator
import android.view.animation.DecelerateInterpolator
import androidx.fragment.app.Fragment

class FunctionsDiferenciadas {


    fun fadeAnimation(postAnimCallback: () -> Unit) {
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
    }

}