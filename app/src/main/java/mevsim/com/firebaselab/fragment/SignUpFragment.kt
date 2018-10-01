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
import kotlinx.android.synthetic.main.fragment_sign_up.*
import kotlinx.android.synthetic.main.fragment_splash.*

import mevsim.com.firebaselab.R


class SignUpFragment : Fragment() {

    private val firebaseAuth by lazy { FirebaseAuth.getInstance() }
    private val userEmail by lazy { edtEmailSignup.text.toString() }
    private val userPassword by lazy { edtPasswordSignup.text.toString() }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        (activity as AppCompatActivity).supportActionBar!!.hide()
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        btnDashboard_Signup.setOnClickListener {
//            Navigation.findNavController(it).navigate(R.id.action_signUpFragment_to_dashboardFragment)
//        }


        btnSignUp.setOnClickListener { it ->
            firebaseAuth.createUserWithEmailAndPassword(userEmail,userPassword).
                    addOnCompleteListener {
                        if(it.isSuccessful){
                            view?.let {_view ->
                                Navigation.findNavController(_view).navigate(R.id.action_signUpFragment_to_dashboardFragment)
                            }
                        }else{
                            Toast.makeText(context,"! Sign Up Failed",Toast.LENGTH_LONG).show()
                        }
                    }
        }
    }
}
