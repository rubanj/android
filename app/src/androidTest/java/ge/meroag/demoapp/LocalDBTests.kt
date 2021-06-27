package ge.meroag.demoapp

import androidx.test.platform.app.InstrumentationRegistry
import ge.meroag.demoapp.data.database.DaoPeople
import ge.meroag.demoapp.data.database.LocalCashDatabase
import ge.meroag.demoapp.data.models.People
import ge.meroag.demoapp.data.models.Peoples
import ge.meroag.demoapp.data.repository.PeopleRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import java.lang.Exception

class LocalDBTests {

    private val context = InstrumentationRegistry.getInstrumentation().targetContext


    @Test
    fun Get(){
        try {
            val data = LocalCashDatabase.getDatabase(context).peopleDao().getPeople()
        }catch (ex:Exception){
            Assert.fail(ex.message)
        }
    }

    @Test
    fun Add(){
        try {
            val model = People(0,"Demo","User","Online","Hello")
            runBlocking {
                LocalCashDatabase.getDatabase(context).peopleDao().addPeople(model)
            }
        }catch (ex:Exception){
            Assert.fail(ex.message)
        }
    }

    @Test
    fun Delete(){
        try {
            val model = People(0,"Demo","User","Online","Hello")
            runBlocking {
                LocalCashDatabase.getDatabase(context).peopleDao().deletePeople(model)
            }
        }catch (ex:Exception){
            Assert.fail(ex.message)
        }
    }

}