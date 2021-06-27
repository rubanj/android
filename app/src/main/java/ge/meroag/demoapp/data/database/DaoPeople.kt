package ge.meroag.demoapp.data.database

import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ge.meroag.demoapp.data.models.People

@Dao
interface DaoPeople {

    @Query("SELECT * FROM People")
    fun getPeople(): List<People>

    @Insert
    suspend fun addPeople(model:People)

    @Delete
    suspend fun deletePeople(model:People)

    @Query("DELETE FROM People")
    suspend fun clearPeople()
}