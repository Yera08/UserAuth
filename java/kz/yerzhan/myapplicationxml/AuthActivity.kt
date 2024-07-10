package kz.yerzhan.myapplicationxml

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kz.yerzhan.myapplicationxml.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAuthBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val userLogin = binding.userLoginAuth
        val userPass = binding.userPassAuth
        val button = binding.buttonAuth
        val linkToReg = binding.linkToReg

        linkToReg.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener{
            val login = userLogin.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if ( login == "" || pass == "") {
                Toast.makeText(this, "All!!!", Toast.LENGTH_LONG).show()
            }else{

                val db = DBHelper(this, null)
                val isAuth = db.getUser(login, pass)
                if (isAuth){
                    Toast.makeText(this, "User $login auth!!!", Toast.LENGTH_LONG).show()
                    userLogin.text.clear()
                    userPass.text.clear()
                }else{
                    Toast.makeText(this, "User $login don't auth!!!", Toast.LENGTH_LONG).show()
                }


            }
        }
    }
}