package mevsim.com.firebaselab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val firebaseAuth by lazy { FirebaseAuth.getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.dashboard,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

//        when(item?.itemId){
//            R.id.signout -> {
//                firebaseAuth.signOut()
//            }
//        }
        firebaseAuth.signOut()
        Navigation.findNavController(nav_host_fragment.view!!).navigate(R.id.action_dashboardFragment_to_loginFragment)
        return super.onOptionsItemSelected(item)
    }
}
