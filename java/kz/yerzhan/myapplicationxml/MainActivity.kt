package kz.yerzhan.myapplicationxml

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kz.yerzhan.myapplicationxml.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val userLogin = binding.userLogin
        val userEmail = binding.userEmail
        val userPass = binding.userPass
        val button = binding.buttonReg

        val linkToAuth = binding.authLink

        linkToAuth.setOnClickListener{
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener{
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if ( login == "" || email == "" || pass == "") {
                Toast.makeText(this, "All!!!", Toast.LENGTH_LONG).show()
            }else{
                val user = User(login,email,pass)

                val db = DBHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "User $login add!!!", Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userEmail.text.clear()
                userPass.text.clear()

            }
        }

    }
}




























