>[!NOTE]
> try-catch permite ejecutar código que podría generar un error y definir qué debe hacer el programa si ese error ocurre. Es un mecanismo que permite controlar situaciones excepcionales que pueden ocurrir durante la ejecución de un programa, evitando que este termine de forma inesperada

```
fun main() {  
    try {  
        print("Ingrese su edad: ")  
        val edad = readln().toInt()  
  
        println("Tu edad es $edad")  
    } catch (e: Exception) {  
        println("Error: ${e.message}")  
    }  
}
```

- try: contiene el código que podría producir una excepción
- catch: indica qué hacer si ocurre un error. Puede haber múltiples catch, para capturar diversos errores
- finally: bloque opcional, que se ejecutará siempre, haya existido error o no

>[!TIP]
> No todos los problemas necesitan una excepción 👀

```
val edad = readln().toIntOrNull() 

if (edad != null) { 
	println("Edad: $edad") 
} else { 
	println("Debe ingresar un número") 
}
```

