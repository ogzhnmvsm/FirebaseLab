package mevsim.com.firebaselab.fragment

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_dashboard.*

import mevsim.com.firebaselab.R


class DashboardFragment : Fragment() {

    private val firebaseAuth by lazy{ FirebaseAuth.getInstance()}
    private val txtEmail by lazy { view?.findViewById<TextView>(R.id.txtUser) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        (activity as AppCompatActivity).supportActionBar!!.show()

        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        txtUser.text = firebaseAuth.currentUser?.email.toString()

    }

}
