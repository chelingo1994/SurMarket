package bo.edu.uajms.marcelojustiniano.surmarket


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class fragmentLogin : Fragment() {
    private lateinit var edtLoginUsername: EditText
    private lateinit var edtLoginPassword: EditText
    private lateinit var txvLoginForgotPassword: TextView
    private lateinit var btnLogin: Button
    private lateinit var btnRegister : Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews(view)
        configureListeners()
    }



    private fun initializeViews(view: View) {
         edtLoginUsername=view.findViewById(R.id.edtLoginUsername)
         edtLoginPassword=view.findViewById(R.id.edtLoginPassword)
         txvLoginForgotPassword=view.findViewById(R.id.txvLoginForgotPassword)
         btnLogin=view.findViewById(R.id.btnLogin)
         btnRegister=view.findViewById(R.id.btnRegister)
    }
    private fun configureListeners() {
        txvLoginForgotPassword.setOnClickListener {
        }
        btnLogin.setOnClickListener {
            signIn()
        }
        btnRegister.setOnClickListener {  }
    }

    private fun signIn() {
        val user=edtLoginUsername.text.toString().trim()
        val password=edtLoginPassword.text.toString().trim()
        if(!verifyIntegrity(user,password)){
            return
        }
        if(verifyCredencials(user,password)){
            Toast.makeText(requireContext(), getString(R.string.loginWelcome), Toast.LENGTH_SHORT).show()

        }else{
            Toast.makeText(requireContext(), getString(R.string.loginError), Toast.LENGTH_SHORT).show()
        }
    }


    private fun verifyIntegrity(user: String, password: String): Boolean {
        var res=true
        if(user.isEmpty()){
            edtLoginUsername.error=getString(R.string.userEmpty)
        }
        else{
            edtLoginUsername.error=null
        }
        if(password.isEmpty()){
            edtLoginPassword.error=getString(R.string.passwordEmpty)
        }
        else{
            edtLoginPassword.error=null
        }
        return res
    }
    private fun verifyCredencials(user: String, password: String): Boolean {
        return user=="admin" && password=="123456"
    }



}
