package ge.meroag.demoapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ge.meroag.demoapp.data.api.ApiService
import ge.meroag.demoapp.data.database.DaoPeople
import ge.meroag.demoapp.data.models.People
import ge.meroag.demoapp.data.models.Peoples

class PeopleRepository(private val peopleDaoPeople: DaoPeople) {
    suspend fun getPeople():LiveData<List<People>>{
        return MutableLiveData(peopleDaoPeople.getPeople())
    }

    suspend fun add(model:People){
        peopleDaoPeople.addPeople(model)
        ApiService().addUsers(model.getModelForAPI())
    }

    suspend fun delete(model:People){
        peopleDaoPeople.deletePeople(model)
        ApiService().deleteUsers(model.getModelForAPI())
    }

    suspend fun clear(){
        peopleDaoPeople.clearPeople()
    }
}