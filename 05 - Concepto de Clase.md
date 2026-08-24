>[!NOTE]
> Una clase es una plantilla que define las características y comportamientos que tendrán determinados objetos. A partir de una clase, se crean objetos. Los objetos son similares en cuanto a características y comportamiento, pero cada objeto puede tener distintos valores en sus atributos.

En Kotlin, se pueden seguir creando clases utilizando ambos constructores (con y sin parámetros), como lo hacíamos en Java, y su sintaxis sería la siguiente:
```
class Persona {  
    var nombre = ""    
    var edad = 0  
    
    // CONSTRUCTOR SIN PARÁMETROS    
    constructor()  
    
    // CONSTRUCTOR CON PARÁMETROS    
    constructor(nombre: String, edad: Int) {        
	    this.nombre = nombre        this.edad = edad    
	}
}
```

Y en el main, podríamos crear 2 objetos de la siguiente manera:
```
fun main() {  
	val persona1 = Persona()  
    val persona2 = Persona("Fernando", 39)
}
```

Sin embargo, en Kotlin se intenta utilizar siempre el constructor con parámetros (o primario), porque permite escribir mucho menos código:
```
class Persona (val nombre: String, var edad: Int) {  
  
    // FUNCIÓN QUE MUESTRA SUS DATOS  
    fun presentarse() {  
        println("SU NOMBRE ES: $nombre Y SU EDAD ES: $edad")  
    }  
}
```

Y en el main:
```
fun main() {  
    val persona1 = Persona("Fernando", 39)  
    persona1.nombre = ""  
}
```

##### val y var dentro de una clase
Los atributos definidos en el constructor, pueden ser val y var, dependiendo de su funcionalidad:
```
class Producto(
	val codigo: Int, 
	var nombre: String, 
	var precio: Int) {  
}
```

Y en el main:
```
fun main() {  
    val producto1 = Producto(1, "Café", 1000)  
  
    producto1.nombre = "Café Americano"  // ✅ correcto
	producto1.precio = 1500              // ✅ correcto
  
    producto1.codigo = 1  // ❌ error, codigo es val
}
```

##### Encapsulamiento
>[!NOTE]
> Encapsular consiste en ocultar o restringir el acceso directo a los atributos de un objeto, permitiendo trabajador con ellos mediante métodos o propiedades controladas.

```
class CuentaBancaria {  
  
    private var saldo: Int = 0  
  
    fun depositar(monto: Int) {  
        if (monto > 0) {  
            saldo += monto  
        }  
    }  
  
    fun mostrarSaldo() {  
        println("Saldo: $saldo")  
    }  
}
```

Y en el main:
```
fun main() {  
    val cuenta = CuentaBancaria()  
  
    //cuenta.saldo = 1000  ❌ error, saldo es privado
    cuenta.depositar(5000)  
    cuenta.mostrarSaldo()  
}
```

>[!TIP]
> Por defecto, los atributos definidos en el constructor, son públicos

