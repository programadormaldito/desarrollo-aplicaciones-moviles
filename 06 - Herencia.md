>[!NOTE]
> Herencia es el mecanismo mediante el cual una clase hija obtiene atributos y métodos de una clase padre/madre, pudiendo además agregar o modificar su propio comportamiento.

Una clase padre/madre sería:
```
open class Animal(val nombre: String) {  
  
    fun dormir() {  
        println("$nombre está durmiendo")  
    }  
  
	// MÉTODO QUE SE PUEDE SOBREESCRIBIR (OPEN)
    open fun hacerSonido() {  
        println("$nombre hace sonido")  
    }  
}
```

>[!TIP]
> En Kotlin, las clases por defecto son de tipo final, lo que quiere decir que de ellas no se puede heredar. Para permitir que de ellas se pueda heredar, se deben "abrir", por el eso el open al comienzo de la definición

Clase Perro: 
```
class Perro(nombre: String): Animal(nombre) {  
  
    override fun hacerSonido() {  
        println("$nombre dice Guau!")  
    }  
}
```

👀 **los campos heredados en el constructor, no llevan var ni var**

Case Gato:
```
class Gato(nombre: String): Animal(nombre) {  
  
    override fun hacerSonido() {  
        println("$nombre dice Miau!")  
    }  
}
```

Y en el main:
```
fun main() {  
    val perro = Perro("Odi")  
    val gato = Gato("Michi")  
  
    perro.dormir()  
    perro.hacerSonido()  
    gato.dormir()  
    gato.hacerSonido()  
}
```

#### Clase Abstracta
>[!NOTE]
> Una clase abstracta es aquella de la cual no se pueden crear objetos. Representa una "idea" general que debe ser completada por sus clases hijas. Puede contener y métodos comunes, además de métodos abstractos que las clases hijas están obligadas a implementar.

```
abstract class Empleado(val nombre: String) {  
  
    abstract fun calcularSueldo()  
  
    fun mostrarNombre() {  
        println("Empleado: $nombre")  
    }  
}
```

Acá, la clase es abstracta, por lo que no podremos crear objetos de tipo Empleado. Además, el método calcularSueldo es abstracto, lo que quiere decir que las clases hijas que hereden de Empleado, obligatoriamente tendrán que implementar el método calcularSueldo.

Clase hija:
```
class EmpleadoPorHora(  
    nombre: String,  
    val horas: Int,  
    val valorHora: Double  
) : Empleado(nombre) {  
  
	//👀 MÉTODO OBLIGATORIO
    override fun calcularSueldo() {  
        println("Sueldo: ${horas * valorHora}")  
    }  
}
```

En el main:
```
fun main() {  
	❌ error, no se puede crear un objeto de una clase abstracta
    val empleado = Empleado("Fernando")  
}
```

```
fun main() {  

	✅ correcto, si se pueden crear objetos de las clases hijas
    val empleado = EmpleadoPorHora("Fernando", 160, 5000.0)  
    empleado.mostrarNombre()  
    empleado.calcularSueldo()  
}
```
