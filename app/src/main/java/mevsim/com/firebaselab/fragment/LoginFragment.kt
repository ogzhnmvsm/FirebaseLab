package mevsim.com.firebaselab.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_splash.*

import mevsim.com.firebaselab.R


class LoginFragment : Fragment() {

    private val firebaseAuth by lazy { FirebaseAuth.getInstance() }
    private val userName by lazy { edtEmail.text.toString() }
    private val userPassword by lazy { edtPassword.text.toString() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        (activity as AppCompatActivity).supportActionBar!!.hide()
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnLogin.setOnClickListener {

            firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener {
                if(it.isSuccessful){
                    navigateTo(R.id.action_loginFragment_to_dashboardFragment)
                }else{
                    Toast.makeText(context,"! Login Failed",Toast.LENGTH_LONG).show()
                }

            }
        }

        btnSignUp.setOnClickListener {
            navigateTo(R.id.action_loginFragment_to_signUpFragment)
        }

    }

    private fun navigateTo(action: Int) {

        view?.let {
            Navigation.findNavController(it).navigate(action)
        }
    }
}
