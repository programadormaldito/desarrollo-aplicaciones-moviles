>[!NOTE]
>Una sealed class permite representar un conjunto limitado y conocido de posible estados

```
sealed class Resultado {  
    data class Exito(  
        val mensaje: String  
    ) : Resultado()  
  
    data class Error(  
        val mensaje: String  
    ) : Resultado()  
  
    object Cargando : Resultado()  
}
```

Y en el main: 
```
fun mostrarResultado(resultado: Resultado) {  
  
    when (resultado) {  
  
        is Resultado.Exito ->  
            println("Correcto: ${resultado.mensaje}")  
  
        is Resultado.Error ->  
            println("Error: ${resultado.mensaje}")  
  
        Resultado.Cargando ->  
            println("Cargando...")  
    }  
}
```

Y dentro de la función main:
```
mostrarResultado(Resultado.Cargando)  
mostrarResultado(Resultado.Exito("Usuario registrado correctamente"))  
mostrarResultado(Resultado.Error("Error al crear usuario"))
```

>[!TIP]
> Más adelante, en Android, este patrón nos será muy útil para representar estados de una pantalla o respuestas de una API.

