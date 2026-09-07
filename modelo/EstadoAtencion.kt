package modelo

// CLASE SELLADA PARA ESTADO DE ATENCIÓN
sealed class EstadoAtencion {
    object EnAtencion: EstadoAtencion()     // OBJECT, PORQUE NO REQUIERE NADA DENTRO
    object Finalizada: EstadoAtencion()     // OBJECT, PORQUE NO REUQIERE NADA DENTRO
}