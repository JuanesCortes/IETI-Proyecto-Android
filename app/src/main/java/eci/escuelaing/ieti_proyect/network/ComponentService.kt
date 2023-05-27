package eci.escuelaing.ieti_proyect.network

import eci.escuelaing.ieti_proyect.network.dto.Component
import retrofit2.Response
import retrofit2.http.GET

interface ComponentService {

    @GET("v1/componente/getAllComponents")
    suspend fun getComponent(): Response<List<Component>>

}
