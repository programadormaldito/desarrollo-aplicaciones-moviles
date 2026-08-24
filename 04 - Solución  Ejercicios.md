**EJERCICIO 1**
```
fun main() {
    // SE PIDE PRODUCTO. VAL PORQUE NO CAMBIA
    print("INGRESE NOMBRE PRODUCTO: ")
    val producto = readln()

    // SE PIDA PRECIO. VAL PORQUE NO CAMBIA, Y TOINT PORQUE ES NÚMERO ENTERO
    print("INGRESE PRECIO UNITARIO: $")
    val precio = readln().toInt()

    // SE PIDA CANTIDAD. VAL PORQUE NO CAMBIA, Y TOINT PORQUE ES NÚMERO ENTERO
    print("INGRESE CANTIDAD: ")
    val cantidad = readln().toInt()

    // SE CALCULA SUBTOTAL. VAL PORQUEN NO CAMBIA
    val subtotal = precio * cantidad

    // SE DECLARA DESCUENTO. VAR PORQUE SI PUEDE CAMBIAR
    var descuento = 0

    // SI SE CUMPLE LA CONDICIÓN, SE CALCULA, SINO QUEDA EN CERO
    if(subtotal >= 50000) {
        descuento =  (subtotal * 0.1).toInt()
    }

    // SE CALCULA TOTAL
    val total = subtotal - descuento

    // SE MUESTRA SALIDA SEGÚN ENUNCIADO
    println()
    println("Producto: $producto")
    println("Precio Unitario: $$precio")
    println("Cantidad: $cantidad")
    println()
    println("Subtotal: $$subtotal")
    println("Descuento: $$descuento")
    println("Total a pagar: $$total")
}
```

**EJERCICIO 2 (VERSIÓN IF)**
```
fun main() {
    print("INGRESE SU NOTA: ")
    val nota = readln().toDouble()

    if (nota >= 1.0 && nota <= 7.0) {
        if(nota < 4.0) {
            println("Reprobado")
        } else if (nota >= 4.0 && nota <= 4.9) {
            println("Aprobado")
        } else if (nota >= 5.0 && nota <= 5.9) {
            println("Buen rendimiento")
        } else {
            println("Excelente rendimiento")
        }
    } else {
        println("Nota no válida")
    }
}
```

**EJERCICIO 2 (VERSIÓN WHEN)**
```
fun main() {
    print("INGRESE SU NOTA: ")
    val nota = readln().toDouble()

    when (nota) {
        in 1.0..3.9 -> println("Reprobado")
        in 4.0..4.9 -> println("Aprobado")
        in 5.0..5.9 -> println("Buen rendimiento")
        in 6.0..7.0 -> println("Excelente rendimiento")
        else -> println("Nota no válida")
    }
}
```
