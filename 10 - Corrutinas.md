Supongamos lo siguiente
- La búsqueda de productos en internet demora 5 segundos
- El programa debe procesar los productos encontrados
- El programa debe mostrar los productos
Si un programa tuviera que quedarse completamente detenido esperando esos 5 segundos, sería poco eficiente.

>[!NOTE]
>Una corrutina permite ejecutar tareas que pueden demorarse (suspenderse) mientras esperan algo, sin necesariamente bloquear todo el programa.

Las situaciones típicas son:
	- Consumir una api
	- Consultar una base de datos
	- Descargar información
	- Leer archivos
	- Esperar respuestas de red

```
import kotlinx.coroutines.delay  
import kotlinx.coroutines.launch  
import kotlinx.coroutines.runBlocking  
import kotlin.time.Duration.Companion.milliseconds  
  
fun main() = runBlocking {  
    println("Inicio")  
  
    launch {  
        delay(2000.milliseconds)  
        println("Proceso terminado")  
    }  
  
    println("Continuando programa...")  
}
```

Resultado esperado:
```
Inicio
Continuando programa...
Proceso terminado
```

**runBlocking**: permite crear un contexto de corrutinas desde un programa tradicional 
**launch**: inicia una nueva corrutina
**delay**: suspende o demora una corrutina, para simular que el sistema está trabajando

##### FUNCIONES SUSPEND
>[!NOTE]
>Una función suspend es una función que puede suspender o demorar temporalmente su ejecución sin bloquear el hilo principal.

```
fun main() = runBlocking {  
    descargarDatos()  
}  
  
suspend fun descargarDatos() {  
    println("Descargando...")  
    delay(2000.milliseconds)  
    println("Descarga terminada")  
}
```

