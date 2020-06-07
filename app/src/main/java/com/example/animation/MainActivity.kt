package com.example.animation

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.view.animation.TranslateAnimation
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.logging.Handler
import kotlin.concurrent.schedule
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth
import android.widget.LinearLayout


class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //apply Translation on the layout
        var animationOnLayout= TranslateAnimation(600.0f,0.0f,0.0f,0.0f)
        animationOnLayout.duration=1800
        animationOnLayout.startOffset=1000
        animationOnLayout.fillAfter=true


        //Here we are applying Translation as well as Scaling
        //Translation and scaling code is in R.anim.animation file
        var imgAnimation=AnimationUtils.loadAnimation(this,R.anim.animation)

        //set the listener to perform various task
         imgAnimation.setAnimationListener(object:Animation.AnimationListener{
             override fun onAnimationRepeat(animation: Animation?) {

             }

             override fun onAnimationEnd(animation: Animation?) {
                 moveLayout.visibility=View.VISIBLE            //After image animation is over the layout will be visible which we set
                 moveLayout.startAnimation(animationOnLayout)   // invisible in activity_main.xml file


             }

             override fun onAnimationStart(animation: Animation?) {

             }

         })
        imgView.startAnimation(imgAnimation)
    }

}


