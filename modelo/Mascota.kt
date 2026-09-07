package modelo

// CLASE ABSTRACTA
// TIENE LOS ATRIBUTOS COMUNES DE TODOS LOS TIPOS DE PACIENTE
abstract class Mascota(
    val nombreMascota: String,
    val nombreDueno: String,
    val edad: Int,
    val tipoAtencion: Char // PUEDE SER N, U o C
) {

}