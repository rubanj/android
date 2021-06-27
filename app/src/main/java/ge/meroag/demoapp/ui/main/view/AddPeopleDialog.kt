package ge.meroag.demoapp.ui.main.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import ge.meroag.demoapp.R
import ge.meroag.demoapp.data.models.People
import ge.meroag.demoapp.ui.main.viewmodel.PeopleViewModel
import ge.meroag.demoapp.utils.MyToolkit
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.dialog_add_people.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class AddPeopleDialog(context: Context,private val viewModel:PeopleViewModel):Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_people)

        btn_save.setOnClickListener {
            if(!checkFields())
                return@setOnClickListener
            val newModel = People(0,
                txt_fname.text.toString(),
                txt_lname.text.toString(),
                "",
                txt_statMessage.text.toString()
                )
            val progressDialog = MyToolkit.showProgressAlertDialog(context,"Please wait while we add user to our database")
            GlobalScope.launch(Dispatchers.IO){
                try {
                    viewModel.add(newModel)
                    GlobalScope.launch(Dispatchers.Main){
                        MyToolkit.showSuccessAlertDialog(context,"Done").setOnDismissListener { this@AddPeopleDialog.dismiss() }
                    }
                }catch (ex:Exception){
                    MyToolkit.showSnackBarError(context,ex)
                }finally {
                    GlobalScope.launch(Dispatchers.Main){
                        progressDialog.dismissWithAnimation()
                    }
                }
            }

        }

        btn_cancel.setOnClickListener {
            this.cancel()
        }
    }

    private fun checkFields(): Boolean {

        if(txt_fname.text.isEmpty()){
            txt_fname.setError("Please enter first name")
            return false
        }
        if(txt_lname.text.isEmpty()){
            txt_lname.setError("Please enter last name")
            return false
        }

        return true
    }
}