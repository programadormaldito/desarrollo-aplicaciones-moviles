package modelo

// CLASE HIJA, HEREDA DE MASCOTA
// LOS ATRIBUTOS HEREDADOS NO LLEVAN VAR Y VAL
class Gato(
    nombreMascota: String,  // ATRIBUTO HEREDADO
    nombreDueno: String,    // ATRIBUTO HEREDADO
    edad: Int,              // ATRIBUTO HEREDADO
    tipoAtencion: Char      // ATRIBUTO HEREDADO
): Mascota(nombreMascota, nombreDueno, edad, tipoAtencion) {
}