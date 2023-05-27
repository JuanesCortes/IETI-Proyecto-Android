package eci.escuelaing.ieti_proyect.network.dto

data class Component(
    val id: String?,
    val nombre: String,
    val precio: Double,
    val valoracion: Int,
    val procesador: String,
    val memoria: Int,
    val core_clock: Double,
    val boost_clock: Double
)
