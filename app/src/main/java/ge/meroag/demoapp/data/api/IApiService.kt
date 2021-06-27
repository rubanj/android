package ge.meroag.demoapp.data.api

import ge.meroag.demoapp.data.models.Group
import ge.meroag.demoapp.data.models.People
import ge.meroag.demoapp.data.models.Peoples

interface IApiService {
    fun getUsers():List<Peoples>
    fun addUsers(model:Peoples):List<Peoples>
    fun deleteUsers(model:Peoples):List<Peoples>

}