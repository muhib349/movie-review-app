package frog.social.moviereviewapp.ui.activity.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import frog.social.moviereviewapp.R
import frog.social.moviereviewapp.databinding.ActivityLoginBinding
import frog.social.moviereviewapp.ui.activity.movieslist.MovieListActivity
import frog.social.moviereviewapp.ui.activity.signup.SignupActivity

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.layoutPrimaryBtn.btnSave.text = getString(R.string.btn_login)

        binding.tvSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        binding.layoutPrimaryBtn.btnSave.setOnClickListener {
            if(validatedInput()){
                viewModel.login(binding.etEmail.text.toString(), binding.etPassword.text.toString())
            }
        }

        viewModel.user.observe(this){
            if(it == null){
                Toast.makeText(this, getString(R.string.invalid_username_or_password), Toast.LENGTH_SHORT).show()
            }
            it?.let {
                navigateToMovieListScreen()
            }
        }
    }

    private fun navigateToMovieListScreen() {
        val intent = Intent(this, MovieListActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }

    private fun validatedInput(): Boolean{
        if(TextUtils.isEmpty(binding.etEmail.text)){
            Toast.makeText(this, getString(R.string.email_required), Toast.LENGTH_SHORT).show()
            return false
        }else if(!Patterns.EMAIL_ADDRESS.matcher(binding.etEmail.text.toString()).matches()){
            Toast.makeText(this, getString(R.string.invalid_email), Toast.LENGTH_SHORT).show()
            return false
        }else if(TextUtils.isEmpty(binding.etPassword.text)){
            Toast.makeText(this, getString(R.string.password_required), Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}