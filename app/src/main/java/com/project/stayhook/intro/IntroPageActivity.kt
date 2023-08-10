package com.project.stayhook.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView
import com.project.stayhook.R
import com.project.stayhook.auth.SignUpActivity

class IntroPageActivity : AppCompatActivity() {

    private lateinit var lottieView:LottieAnimationView
    private lateinit var introHeading:TextView
    private lateinit var introCmnt:TextView
    private lateinit var getStartedBtn:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_page)

        lottieView=findViewById(R.id.lottieView)
        introHeading=findViewById(R.id.introHeading)
        introCmnt=findViewById(R.id.introCmnt)
        getStartedBtn=findViewById(R.id.getStartedBtn)


        var i:Long=4;
        while(i<1000){
            Handler(Looper.getMainLooper()).postDelayed({
                lottieView.setAnimation(R.raw.living_hall_lottie)
                lottieView.playAnimation()
                introHeading.text="Forget Your Stress"
            }, i*1000)

            i +=5
            Handler(Looper.getMainLooper()).postDelayed({
                lottieView.setAnimation(R.raw.coliving_lottie)
                lottieView.playAnimation()
                introHeading.text="Find Partner to Stay with"
            }, i*1000)

            i+=6
            Handler(Looper.getMainLooper()).postDelayed({
                lottieView.setAnimation(R.raw.search_lottie)
                lottieView.playAnimation()
                introHeading.text="Find Home that Suits You"
            }, i*1000)
            i+=6
        }

        getStartedBtn.setOnClickListener {
            val intent = Intent(this@IntroPageActivity, SignUpActivity::class.java)
            startActivity(intent)
            finish() //if press back so this will not reappear
        }


    }
}