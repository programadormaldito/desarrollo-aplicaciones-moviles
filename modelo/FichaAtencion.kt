package modelo

import java.time.LocalDateTime

class FichaAtencion(
    val correlativo: Int,
    val fechaIngreso: LocalDateTime,
    val mascota: Mascota, // POR POLIMORFISMO PUEDE SER UN PERRO, GATO O EXÓTICO
    val box: Box,
    var cantidadProcedimientos: Int,    // VAR, PORQUE CUANDO RECIÉN INGRESA NO SE SABE CUÁNTOS
    var monto: Int = 0,                 // VAR, PORQUE CUANDO RECIÉN INGRESA NO SABE CUÁNTO SE PAGARÁ
    var estadoAtencion: EstadoAtencion  // VAR, PORQUE DESPUÉS SE CAMBIARÁ
) {
}