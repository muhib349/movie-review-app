package frog.social.moviereviewapp.ui.activity.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import frog.social.moviereviewapp.R
import frog.social.moviereviewapp.data.local.entity.User
import frog.social.moviereviewapp.databinding.ActivitySignupBinding

@AndroidEntryPoint
class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    private val viewModel: SignupViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.myToolbar)

        binding.layoutPrimaryBtn.btnSave.setOnClickListener {
            if (validatedInput()){
                viewModel.insertUser(getUser())
            }
        }

    }

    private fun validatedInput(): Boolean{
        if(TextUtils.isEmpty(binding.layoutContent.etFullName.text)){
            Toast.makeText(this, getString(R.string.full_name_required), Toast.LENGTH_SHORT).show()
            return false
        }else if(TextUtils.isEmpty(binding.layoutContent.etEmail.text)){
            Toast.makeText(this, getString(R.string.email_required), Toast.LENGTH_SHORT).show()
            return false
        }else if(!Patterns.EMAIL_ADDRESS.matcher(binding.layoutContent.etEmail.text.toString()).matches()){
            Toast.makeText(this, getString(R.string.invalid_email), Toast.LENGTH_SHORT).show()
            return false
        }else if(TextUtils.isEmpty(binding.layoutContent.etPhone.text)){
            Toast.makeText(this, getString(R.string.phone_required), Toast.LENGTH_SHORT).show()
            return false
        }else if(TextUtils.isEmpty(binding.layoutContent.etPassword.text) || binding.layoutContent.etPassword.text?.length!! < 6){
            Toast.makeText(this, getString(R.string.password_minimum_length), Toast.LENGTH_SHORT).show()
            return false
        }else if(TextUtils.isEmpty(binding.layoutContent.etConfirmPassword.text) || !binding.layoutContent.etPassword.text.toString().equals(binding.layoutContent.etConfirmPassword.text.toString())){
            Toast.makeText(this, getString(R.string.password_mismatch), Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun getUser(): User{
        val name = binding.layoutContent.etFullName.toString()
        val email = binding.layoutContent.etEmail.toString()
        val phone = binding.layoutContent.etPhone.toString()
        val password = binding.layoutContent.etPassword.toString()

        return User(name = name, email = email, phone = phone, password = password)
    }

}