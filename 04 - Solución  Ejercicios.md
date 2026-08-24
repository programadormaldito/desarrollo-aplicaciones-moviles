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
