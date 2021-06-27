package ge.meroag.demoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ge.meroag.demoapp.data.api.ApiService
import ge.meroag.demoapp.data.database.LocalCashDatabase
import ge.meroag.demoapp.data.models.People
import ge.meroag.demoapp.ui.main.view.HomeActivity
import ge.meroag.demoapp.utils.MyToolkit
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.people_list_item.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO){
            try {
                val dataFromServer = ApiService().getUsers()
                val dao = LocalCashDatabase.getDatabase(this@MainActivity).peopleDao()
                dao.clearPeople()
                dataFromServer.forEach {
                    dao.addPeople(People(0,it.firstName,it.lastName,it.statusIcon,it.statusMessage))
                }
            }catch (ex:Exception){
                GlobalScope.launch {
                    MyToolkit.showSnackBarError(this@MainActivity,ex)
                    lb_statusText.text = "Error loading data"
                    progress.visibility = View.INVISIBLE
                }
            }
            navigateToHome()
        }
    }

    fun navigateToHome()= GlobalScope.launch(Dispatchers.Main){
        startActivity(Intent(this@MainActivity,HomeActivity::class.java))
        finish()
    }
}