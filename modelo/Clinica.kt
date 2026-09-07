package modelo

import kotlinx.coroutines.delay
import java.time.LocalDateTime
import kotlin.time.Duration.Companion.milliseconds

class Clinica(
    val cantidad: Int
) {
    // LISTA PARA ALMACENAR LOS BOXES DE LA CLÍNICA
    private val lista_boxes = mutableListOf<Box>()

    // LISTA PARA ALMACENAR LAS FICHAS DE ATENCIÓN - REQUERIMIENTO 3
    private val lista_fichas = mutableListOf<FichaAtencion>()

    // REQUERIMIENTO 1
    fun iniciarBoxes() {
        for(x in 1..cantidad) {
            lista_boxes.add(Box(x, EstadoBox.Disponible))
        }

        println("Box iniciados correctamente")
        println()   // ESPACIO VACÍO PARA QUE SE VEA MEJOR
    }

    // REQUERIMIENTO 2: SE DIVIDE EN VARIAS FUNCIONES
    // ----------------------------------------------

    // FUNCIÓN QUE SOLICITA TODA LA INFO DEL PACIENTE
    // RETORNA UNA MASCOTA, PORQUE PUEDE DEVOLVER: PERRO, GATO o EXÓTICO
    fun obtenerInfoPaciente(): Mascota {
        // SE SOLICITA LA INFORMACIÓN GENERAL DE LA MASCOTA
        print("INGRESE NOMBRE MASCOTA: ")
        val nombreMascota = readln()

        print("INGRESE NOMBRE DUEÑO: ")
        val nombreDueno = readln()

        print("INGRESE EDAD MASCOTA: ")
        val edad = readln().toInt()

        print("INGRESE TIPO ATENCIÓN (N: NORMAL, U: URGENCIA, C: CONVENIO): ")
        val tipoAtencion = readln()[0]

        print("INGRESE TIPO MASCOTA (P: PERRO, G: GATO, E: EXÓTICO): ")
        val tipoMascota = readln()[0]

        if(tipoMascota == 'P') {
            print("INGRESE TAMAÑO (P: PEQUEÑO, M: MEDIANO: G: GRANDE): ")
            val tamanio = readln()[0]

            val perro = Perro(nombreMascota, nombreDueno, edad, tipoAtencion, tamanio)
            return perro
        } else if(tipoMascota == 'G') {
            val gato = Gato(nombreMascota, nombreDueno, edad, tipoAtencion)
            return gato
        } else { // EXÓTICO
            print("INGRESE ESPECIE: ")
            val especie = readln()

            val exotico = Exotico(nombreMascota, nombreDueno, edad, tipoAtencion, especie)
            return exotico
        }
    }

    // FUNCIÓN QUE OBTIENE EL PRIMER BOX DISPONIBLE
    // EN CASO DE NO ENCONTRAR, DEVUELVE UN BOX CON NÚMERO 0
    fun obtenerBoxDisponible(): Box {
        // SE CREA UN BOX TEMPORAL
        var box = Box(0, EstadoBox.Disponible)

        // SE RECORRE LA LISTA DE BOX PARA ENCONTRAR UNO DISPONIBLE
        for(b in lista_boxes) {
            if(b.estado is EstadoBox.Disponible) {
                box = b // AL BOX TEMPORAL SE LE ASIGNA EL ENCONTRADO
                break
            }
        }

        // SE RETORNA EL BOX TEMPORAL.
        // SI ENCONTRÓ UN BOX LIBRE, TENDRÁ ESE VALOR
        // SI NO ENCONTRÓ, SE RETORNA EL BOX CON VALOR 0
        return box
    }

    // FUNCIÓN QUE MUESTRA EL ESTADO DE UN BOX
    fun mostrarEstadoBox(box: Box) {
        when (box.estado) {
            is EstadoBox.Disponible -> println("Disponible")
            is EstadoBox.Ocupado -> println("Ocupado")
            is EstadoBox.FueraServicio -> println("Fuera de Servicio")
            is EstadoBox.Preparando -> println("Preparando box...")
        }
    }

    // FUNCIÓN QUE CREA Y ALMACENA LA FICHA DE ATENCIÓN
    suspend fun almacenarFichaAtencion() {
        // SE OBTIENE EL BOX:
        val box = obtenerBoxDisponible()

        if (box.numero == 0) {
            println("No hay box disponible")
            return // EVITA QUE LA FUNCIÓN SE SIGA EJECUTANDO
        }

        // SE RECORRE LA LISTA DE BOX PARA ASIGNARLE ESTADO "PREPARANDO"
        for(b in lista_boxes) {
            if(b.numero == box.numero) {
                b.estado = EstadoBox.Preparando("Preparando Box...")
                mostrarEstadoBox(b)
                delay(3000.milliseconds)
                break;
            }
        }

        // REQUERIMIENTO 3
        // SE OBTIENE CORRELATIVO, 1 NÚMERO MÁS QUE LOS QUE YA HAY
        val correlativo = lista_fichas.size + 1
        val fecha = LocalDateTime.now()
        val mascota = obtenerInfoPaciente()
        val cantidadProcedimiento = 0
        val monto = 0

        val ficha = FichaAtencion(correlativo, fecha, mascota, box, cantidadProcedimiento, monto, EstadoAtencion.EnAtencion)
        lista_fichas.add(ficha)

        // SE RECORRE LA LISTA DE BOX PARA ASIGNARLE ESTADO "OCUPADO"
        for(b in lista_boxes) {
            if(b.numero == box.numero) {
                b.estado = EstadoBox.Ocupado(mascota)
                break;
            }
        }

        println("Ficha atención creada correctamente")
    }

    // FIN REQUERIMIENTO 2
    // ----------------------------------------------

    // REQUERIMIENTO 4
    fun marcarBoxFueraServicio() {
        print("INGRESE NÚMERO BOX: ")
        val numeroBox = readln().toInt()

        for(b in lista_boxes) {
            if(b.numero == numeroBox) {
                if(b.estado is EstadoBox.Ocupado) {
                    println("Imposible ejecutar. Box está ocupado")
                } else {
                    print("INGRESE MOTIVO: ")
                    val motivo = readln()

                    b.estado = EstadoBox.FueraServicio(motivo)
                }

                break;
            }

        }
    }

    // REQUERIMIENTO 5
    fun salidaPaciente() {
        print("INGRESE NOMBRE PACIENTE: ")
        val nombre = readln()

        try {
            // SE RECORREN LAS FICHAS. SE DEBE ENCONTRAR AQUELLA QUE ESTÉ EN ATENCIÓN Y TENGA EL NOMBRE DEL PACIENTE
            for(f in lista_fichas) {
                if (f.mascota.nombreMascota == nombre && f.estadoAtencion is EstadoAtencion.EnAtencion) {
                    print("INGRESE CANTIDAD PROCEDIMIENTOS: ")
                    val cantidadProcedimientos = readln().toInt()

                    var base = 0

                    // BASE POR TIPO DE MASCOTA
                    when (f.mascota) {
                        is Perro -> base = 18000
                        is Gato -> base = 15000
                        is Exotico -> base = 25000
                    }

                    // SE AGREGA CANTIDAD DE PROCEDIMIENTOS
                    var total = base + (cantidadProcedimientos * 7500)

                    // SE CALCULA SEGÚN TIPO DE ATENCIÓN
                    when (f.mascota.tipoAtencion) {
                        'U' -> total = (total * 1.3).toInt()
                        'C' -> total = (total * 0.8).toInt()
                    }

                    // PERRO GRANDE
                    if (f.mascota is Perro) {
                        if (f.mascota.tamanio == 'G') {
                            total = total + 5000
                        }
                    }

                    // IVA
                    total = (total * 1.19).toInt()

                    f.monto = total
                    f.cantidadProcedimientos = cantidadProcedimientos

                    // ESTADO DE ATENCIÓN FINALIZADA
                    f.estadoAtencion = EstadoAtencion.Finalizada

                    // BOX DISPONIBLE
                    for(b in lista_boxes) {
                        if(b.numero == f.box.numero) {
                            b.estado = EstadoBox.Disponible
                            break;
                        }
                    }

                    println("TOTAL A PAGAR: $$total")
                    println()
                    break;
                }
            }
        } catch (e: Exception) {
            println("Se ha producido un error: ${e.message}")
        }
    }

    // REQUERIMIENTO 6
    fun consultarEstadoBox() {
        println()
        for (b in lista_boxes) {
            when(b.estado) {
                is EstadoBox.Disponible -> println("BOX ${b.numero}: Disponible")
                is EstadoBox.Ocupado -> println("BOX ${b.numero}: Ocupado - Paciente: ${(b.estado as EstadoBox.Ocupado).mascota.nombreMascota}")
                is EstadoBox.Preparando -> println("BOX ${b.numero}: Preparando...")
                is EstadoBox.FueraServicio -> println("BOX ${b.numero}: Fuera de Servicio - ${(b.estado as EstadoBox.FueraServicio).motivo}")
            }
        }
        println()
    }

    // REQUERIMIENTO 7
    fun reportePacientes() {
        var contadorPerro = 0
        var contadorGato = 0
        var contadorExotico = 0

        for(f in lista_fichas) {
            if(f.mascota is Perro) {
                contadorPerro++
            } else if(f.mascota is Gato) {
                contadorGato++
            } else if(f.mascota is Exotico) {
                contadorExotico++
            }
        }

        println()
        println("REPORTE DE PACIENTES ATENDIDOS")
        println()
        println("Perros atendidos       : $contadorPerro")
        println("Gatos atendidos        : $contadorGato")
        println("Exóticos atendidos     : $contadorExotico")
        println()
        println("Total Pacientes        : ${contadorGato + contadorPerro + contadorExotico}")

        if(contadorPerro >= contadorGato && contadorPerro >= contadorExotico) {
            println("Tipo de paciente más atendido: PERRO")
        } else if(contadorGato >= contadorPerro && contadorGato >= contadorExotico) {
            println("Tipo de paciente más atendido: GATO")
        } else
            println("Tipo de paciente más atendido: EXÓTICO")
    }

    //REQUERIMIENTO 8
    fun reporteRecaudacion() {
        var cantidadAtenciones = 0
        var montoTotal = 0
        var nombreAtencionMayor = ""
        var montoAtencionMayor = 0

        for(f in lista_fichas) {
            if(f.estadoAtencion is EstadoAtencion.Finalizada) {
                cantidadAtenciones++
                montoTotal = montoTotal + f.monto

                if(f.monto > montoAtencionMayor) {
                    nombreAtencionMayor = f.mascota.nombreMascota
                    montoAtencionMayor = f.monto
                }
            }
        }

        if(cantidadAtenciones == 0) {
            println("Aún no existen atenciones finalizadas")
        } else {
            val promedio = (montoAtencionMayor / cantidadAtenciones).toInt()

            println()
            println("REPORTE DE RECAUDACIÓN")
            println()
            println("Cantidad de atenciones finalizadas  : $cantidadAtenciones")
            println("Recaudación Total                   : $$montoTotal")
            println("Promedio por atención               : $$promedio")
            println()
            println("Atención de mayor valor: ")
            println("Paciente   : $nombreAtencionMayor")
            println("Monto      : $$montoAtencionMayor")
        }
    }
}