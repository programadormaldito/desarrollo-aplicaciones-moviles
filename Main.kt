import kotlinx.coroutines.runBlocking
import modelo.Clinica

// runBlocking: cuando se escribe, primero se debe agregar la dependencia
// luego se realiza la importanción
// ES UTILIZADO PARA PODER EJECUTAR FUNCIONES DE TIPO SUSPEND
fun main(): Unit = runBlocking {
    // SE CREA LA CLÍNICA CON CAPACIDAD 5 BOXES
    val clinica = Clinica(5)

    // REQUERIMIENTO 1 (CLASE CLÍNICA, FUNCIÓN iniciarBoxes)
    clinica.iniciarBoxes()

    // LA OPCIÓN ES VARIABLE, YA QUE EL USUARIO LO PUEDE CAMBIAR
    var opcion = "X"
    var salir = true

    // SE DIBUJA EL MENÚ EN UN CICLO, PARA QUE PERMITA EJECUTARLO VARIAS VECES
    while (salir) {
        println("1.- Registrar ingreso de paciente")
        println("2.- Registrar salida de paciente")
        println("3.- Consultar estado de boxes")
        println("4.- Marcar box como fuera de servicio")
        println("5.- Reporte de paciente atendidos")
        println("6.- Reporte de recaudación")
        print("INGRESE OPCIÓN: ")
        opcion = readln()

        when (opcion) {
            "1" -> {
                clinica.almacenarFichaAtencion()
            }
            "2" -> {
                clinica.salidaPaciente()
            }
            "3" -> {
                clinica.consultarEstadoBox()
            }
            "4" -> {
                clinica.marcarBoxFueraServicio()
            }
            "5" -> {
                clinica.reportePacientes()
            }
            "6" -> {
                clinica.reporteRecaudacion()
            }
            else -> {
                salir = false
                println("Gracias por utilizar nuestro sistema")
            }
        }
    }
}