package ge.meroag.demoapp.ui.main.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import ge.meroag.demoapp.data.database.LocalCashDatabase
import ge.meroag.demoapp.data.models.People
import ge.meroag.demoapp.data.repository.PeopleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PeopleViewModel(private val app:Application):AndroidViewModel(app) {
    private val dao = LocalCashDatabase.getDatabase(app).peopleDao()
    var data:MutableLiveData<MutableList<People>> = MutableLiveData()

    suspend fun refreshData() {
        val d = dao.getPeople().toMutableList()
        GlobalScope.launch(Dispatchers.Main){
            data.value =d
        }
    }

    suspend fun add(model:People){
        PeopleRepository(dao).add(model)
        refreshData()
    }

    suspend fun delete(model:People){
        PeopleRepository(dao).delete(model)
        refreshData()
    }
}