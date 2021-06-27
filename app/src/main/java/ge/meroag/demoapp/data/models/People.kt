package ge.meroag.demoapp.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Peoples(
    val firstName: String,
    val lastName: String,
    val statusIcon: String,
    val statusMessage: String
)

@Entity
data class People(
    @ColumnInfo(name = "Id")
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "First_name")
    val firstName: String,

    @ColumnInfo(name = "LastName")
    val lastName: String,

    @ColumnInfo(name = "Status_Icon")
    val statusIcon: String,

    @ColumnInfo(name = "Status_Message")
    val statusMessage: String
){
    fun getModelForAPI():Peoples{
        return Peoples(firstName,lastName,"",statusMessage)
    }
}
