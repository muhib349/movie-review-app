package frog.social.moviereviewapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import frog.social.moviereviewapp.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.myToolbar)
    }
}