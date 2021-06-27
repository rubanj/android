package ge.meroag.demoapp.data.api

import android.util.Log
import com.google.gson.Gson
import ge.meroag.demoapp.data.models.ApiModel
import ge.meroag.demoapp.data.models.Group
import ge.meroag.demoapp.data.models.People
import ge.meroag.demoapp.data.models.Peoples
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.Exception


class ApiService:IApiService {
    private val getUserEndpoint= "https://file.wowapp.me/owncloud/index.php/s/32EQvG6T8eYFiA2/download"
    private val addUserEndpoint= "https://file.wowapp.me/owncloud/index.php/s/ILsnzqADc0o3NGr/download"
    private val delUserEndpoint= "https://file.wowapp.me/owncloud/index.php/s/uvbyRgwuSZaZ2IV/download"

    val client = OkHttpClient()

    override fun getUsers(): List<Peoples> {
        val request = Request.Builder()
            .url(getUserEndpoint)
            .get()
            .build()

        try {
            val json = client.newCall(request).execute().body?.string()
            val pureData = Gson().fromJson(json,ApiModel::class.java)
            val result:ArrayList<Peoples> = ArrayList()
            pureData.groups.forEach {
                result.addAll(it.people)
            }
            return result
        }catch (ex:Exception){
            Log.e("api_client",ex.message!!)
            throw ex
        }
    }

    override fun addUsers(model: Peoples): List<Peoples> {
        val request = Request.Builder()
            .url(addUserEndpoint)
            .get()
            .build()

        try {
            val resp = client.newCall(request).execute()
            if(resp.isSuccessful)
                return getUsers()
            else
                throw Exception(resp.message)
        }catch (ex:Exception){
            Log.e("api_client",ex.message!!)
            throw ex
        }
    }

    override fun deleteUsers(model:Peoples): List<Peoples> {
        val request = Request.Builder()
            .url(delUserEndpoint)
            .get()
            .build()

        try {
            val resp = client.newCall(request).execute()
            if(resp.isSuccessful)
                return getUsers()
            else
                throw Exception(resp.message)
        }catch (ex:Exception){
            Log.e("api_client",ex.message!!)
            throw ex
        }
    }
}
