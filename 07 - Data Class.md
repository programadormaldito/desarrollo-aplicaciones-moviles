>[!NOTE]
> Son clases cuyo principal objetivo es almacenar información.

```
data class Producto( val id: Int, val nombre: String, val precio: Double )
```

Y en el main:
```
fun main() {  
    val producto1 = Producto(1, "Café", 2500.0)  
    println(producto1)  
}
```

Otro ejemplo en el main de lo que se puede hacer con las data class:
```
val producto1 = Producto(1, "Café", 2500.0) 
val producto2 = producto1.copy( precio = 3000.0 ) 

println(producto1) 
println(producto2)
```

>[!TIP]
> Esto servirá mucho cuando lleguemos a Android, y trabajemos con modelos, API REST y JSON

