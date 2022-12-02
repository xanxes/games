package br.senai.sp.jandira.games.ui
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.senai.sp.jandira.games.databinding.ActivityMainBinding
import br.senai.sp.jandira.games.model.Usuario
import br.senai.sp.jandira.games.repository.UsuarioRepository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var userRepository: UsuarioRepository
    var user: Usuario? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        userRepository = UsuarioRepository(this)

        binding.textViewCreateAccount.setOnClickListener {
            val openSignUpActivity = Intent(this, NewAccount::class.java)
            startActivity(openSignUpActivity)
        }

        binding.buttonLogin.setOnClickListener {
            if(login()) {
                val emailText = binding.editTextEmail.text.toString()


                val openGamesListActivity = Intent(this, ListaJogos::class.java)
                openGamesListActivity.putExtra("userId", user?.code)
                startActivity(openGamesListActivity)
            } else {
                Toast.makeText(this, "O seu login falhou!", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun login(): Boolean {
        if(validate()) {
            val emailText = binding.editTextEmail.text.toString()
            userRepository = UsuarioRepository(this)


            if(user == null) {
                Toast.makeText(this, "E-mail não encontrado em nossa base de dados!", Toast.LENGTH_SHORT).show()
                return false
            } else if(binding.editTextPass.text.toString() != user?.userPassword) {
                Toast.makeText(this, "Senha incorreta!", Toast.LENGTH_SHORT).show()
                return false
            }

            return true
        }
        return false
    }

    private fun validate(): Boolean {
        if(binding.editTextEmail.text.isEmpty()) {
            binding.editTextEmail.error = "O email é obrigatório"
            return false
        } else if(binding.editTextPass.text.isEmpty()) {
            binding.editTextPass.error = "A senha é obrigatória"
            return false
        }
        return true
    }
}