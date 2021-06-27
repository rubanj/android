package ge.meroag.demoapp.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ge.meroag.demoapp.R
import ge.meroag.demoapp.data.models.People
import ge.meroag.demoapp.ui.main.adapter.PeopleListAdapter
import ge.meroag.demoapp.ui.main.viewmodel.PeopleViewModel
import ge.meroag.demoapp.utils.MyToolkit
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeActivity : AppCompatActivity(), View.OnLongClickListener {
    private lateinit var mPeopleViewModel:PeopleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        mPeopleViewModel = ViewModelProvider(this).get(PeopleViewModel::class.java)

        val adapter =  PeopleListAdapter(this)
        lv.adapter =adapter
        lv.layoutManager = LinearLayoutManager(this)

        mPeopleViewModel.data.observe(this, {
            adapter.setData(it)
            lv.adapter?.notifyDataSetChanged()

            if(it != null && it.isNotEmpty()){
                la_no_people.visibility =View.GONE
            }else{
                la_no_people.visibility =View.VISIBLE
            }
        })

        btn_add.setOnClickListener {
            val addFm = AddPeopleDialog(this,mPeopleViewModel)
            addFm.show()
        }

        GlobalScope.launch(Dispatchers.IO){
            mPeopleViewModel.refreshData()
        }
    }

    override fun onLongClick(v: View?): Boolean {
        val dialog = MyToolkit.createAlertDialog(this,"Delete selected user?")
        dialog.confirmText = "Yes"
        dialog.cancelText = "No"
        dialog.setConfirmClickListener {
            val progressDialog = MyToolkit.showProgressAlertDialog(this,"Please wait Deleting user")
            GlobalScope.launch(Dispatchers.IO){
                try {
                    val model = v?.tag as People
                    mPeopleViewModel.delete(model)
                }catch (ex:Exception){
                    MyToolkit.showSnackBarError(this@HomeActivity,ex)
                }finally {
                    GlobalScope.launch(Dispatchers.Main){
                        progressDialog.dismissWithAnimation()
                    }
                }
            }
            it.dismissWithAnimation()
        }

        dialog.setOnCancelListener {
            it.dismiss()
        }
        dialog.show()
        return true
    }
}