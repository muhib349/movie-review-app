package frog.social.moviereviewapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import frog.social.moviereviewapp.R
import frog.social.moviereviewapp.ui.activity.signup.SignupActivity


class SplashActivity : AppCompatActivity() {
    private val SPLASH_DELAY_TIME: Long = 2000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed(
            { navigateToNextScreen() },
            SPLASH_DELAY_TIME
        )
    }

    private fun navigateToNextScreen() {
        val intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
        finish()
    }
}