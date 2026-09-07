package modelo

// CLASE SELLADA PARA LOS ESTADOS DE LOS BOX
sealed class EstadoBox {
    object Disponible: EstadoBox()  // OBJETO: NO REQUIERE NADA EN SU INTERIOR
    data class Ocupado(val mascota: Mascota): EstadoBox()           // DATA CLASS, QUE RECIBE UNA MASCOTA
    data class Preparando(val mensaje: String): EstadoBox()         // DATA CLASS, QUE RECIBE UN MENSAJE
    data class FueraServicio(val motivo: String): EstadoBox()       // DATA CLASS, QUE RECIBE UN MOTIVO
}