package modelo

// CLASE HIJA, HEREDA DE MASCOTA
// LOS ATRIBUTOS HEREDADOS NO LLEVAN VAR Y VAL
// LOS ATRIBUTOS PROPIOS LLEVAN VAL O VAR DEPENDIENDO LA NECESIDAD
class Exotico(
    nombreMascota: String,  // ATRIBUTO HEREDADO
    nombreDueno: String,    // ATRIBUTO HEREDADO
    edad: Int,              // ATRIBUTO HEREDADO
    tipoAtencion: Char,     // ATRIBUTO HEREDADO
    val especie: String     // ATRIBUTO PROPIO
): Mascota(nombreMascota, nombreDueno, edad, tipoAtencion) {
}