package ge.meroag.demoapp

import ge.meroag.demoapp.data.api.ApiService
import ge.meroag.demoapp.data.models.People
import ge.meroag.demoapp.data.models.Peoples
import org.junit.Test

class ApiTests {

    @Test
    fun Get(){
        val data = ApiService().getUsers()
        assert(data.isNotEmpty())
    }

    @Test
    fun Add(){
        val data = ApiService().addUsers(createModel())
    }

    @Test
    fun Delete(){
        val data = ApiService().deleteUsers(createModel())
    }

    private fun createModel():Peoples{
        return Peoples("Demo","User","Online","Hello")
    }
}