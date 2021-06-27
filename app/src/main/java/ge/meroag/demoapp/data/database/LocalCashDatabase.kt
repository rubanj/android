package ge.meroag.demoapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ge.meroag.demoapp.data.models.People

@Database(entities = [People::class],exportSchema = false,version = 2)
abstract class LocalCashDatabase: RoomDatabase() {
    abstract fun peopleDao():DaoPeople

    companion object{
        @Volatile
        private var _instance:LocalCashDatabase? = null

        fun getDatabase(context:Context):LocalCashDatabase{
            if(_instance != null)
                return _instance!!

            synchronized(this){
                _instance = Room
                    .databaseBuilder(context.applicationContext,LocalCashDatabase::class.java,"LocalCashDatabase")
                    .build()
                return _instance!!
            }
        }

    }
}