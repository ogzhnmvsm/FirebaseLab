package mevsim.com.firebaselab.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_splash.*

import mevsim.com.firebaselab.R
import com.google.firebase.auth.FirebaseUser



class SplashFragment : Fragment() {

    private val firebaseAuth by lazy { FirebaseAuth.getInstance() }
    private val currentUser by lazy { firebaseAuth.currentUser }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        (activity as AppCompatActivity).supportActionBar!!.hide()
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        object : CountDownTimer(3000,1000) {
            override fun onFinish() {
                navigateTo(R.id.action_splashFragment_to_loginFragment)
            }

            override fun onTick(p0: Long) {

            }

        }.start()

    }

    override fun onStart() {
        super.onStart()
        view?.let {_view ->
            currentUser?.let {
                Navigation.findNavController(_view).navigate(R.id.action_splashFragment_to_dashboardFragment)
            }
        }

    }

    private fun navigateTo(action: Int){

        view?.let{_view ->
            Navigation.findNavController(_view).navigate(action)
        }
    }
}
