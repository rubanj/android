package ge.meroag.demoapp.utils

import android.app.Activity
import android.content.Context
import android.os.Build
import android.util.Log
import android.view.View
import cn.pedant.SweetAlert.SweetAlertDialog
import com.google.android.material.snackbar.Snackbar
import ge.meroag.demoapp.R

object MyToolkit {
    fun showSnackBar(context: Context?, text:String){
        Snackbar.make((context as Activity).findViewById(android.R.id.content),text, Snackbar.LENGTH_LONG).show()
    }

    fun showSnackBarError(context: Context?,ex:Exception){
        Log.e("FMG_Error",ex.toString())
        if(ex.message != null)
            showSnackBarError(context,ex.message.toString())
        else
            showSnackBarError(context,ex.toString())
    }

    fun showSnackBarError(context: Context?, text:String){
        Log.e("FMG_Error",context?.packageName + " "+ text)
        if(context == null)return
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Snackbar.make((context as Activity).findViewById(android.R.id.content),text, Snackbar.LENGTH_LONG)
                .setActionTextColor(context.getColor(R.color.error_stroke_color))
                .setTextColor(context.getColor(R.color.error_stroke_color))
                .show()
        }else{
            Snackbar.make((context as Activity).findViewById(android.R.id.content),text, Snackbar.LENGTH_LONG)
                .show()
        }
    }

    fun showProgressAlertDialog(context: Context?,text:String): SweetAlertDialog {
        return showAlertDialog(context,text, SweetAlertDialog.PROGRESS_TYPE)
    }

    fun showWarningAlertDialog(context: Context?,text:String): SweetAlertDialog {
        return showAlertDialog(context,text, SweetAlertDialog.WARNING_TYPE)
    }

    fun showSuccessAlertDialog(context: Context?,text:String): SweetAlertDialog {
        return showAlertDialog(context,text, SweetAlertDialog.SUCCESS_TYPE)
    }

    fun showErrorAlertDialog(context: Context?,text:String): SweetAlertDialog {
        return showAlertDialog(context,text, SweetAlertDialog.ERROR_TYPE)
    }

    fun createAlertDialog(context: Context?,text:String): SweetAlertDialog {
        val pDialog = SweetAlertDialog(context)
        pDialog.titleText = text
        pDialog.setCancelable(false)
        return pDialog
    }

    private fun showAlertDialog(context: Context?,text:String,type:Int): SweetAlertDialog {
        val pDialog = SweetAlertDialog(context, type)
        pDialog.titleText = text
        pDialog.setCancelable(false)
        pDialog.show()
        return pDialog
    }
}