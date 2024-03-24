package frog.social.moviereviewapp.ui.activity.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import frog.social.moviereviewapp.R
import frog.social.moviereviewapp.data.local.entity.User
import frog.social.moviereviewapp.databinding.ActivitySplashBinding
import frog.social.moviereviewapp.ui.activity.movieslist.MovieListActivity
import frog.social.moviereviewapp.ui.activity.signup.SignupActivity


@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private val SPLASH_DELAY_TIME: Long = 2000L

    private lateinit var binding: ActivitySplashBinding
    private val viewModel: SplashViewModel by viewModels()

    private var users: List<User>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)

        setContentView(binding.root)
        viewModel.getUsers()

        Handler(Looper.getMainLooper()).postDelayed(
            {
            if(isUserRegistered()){
                navigateToMovieListScreen()
            }else{
                navigateToSignupScreen()
            }
                finish()
            },
            SPLASH_DELAY_TIME
        )

        viewModel.users.observe(this){
            it?.let {
                users = it
            }
        }
    }

    private fun isUserRegistered(): Boolean{

        return !(users == null || users?.isEmpty() == true)
    }

    private fun navigateToSignupScreen() {
        val intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToMovieListScreen() {
        val intent = Intent(this, MovieListActivity::class.java)
        startActivity(intent)
    }
}