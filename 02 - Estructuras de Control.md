> [!NOTE]
> Una estructura de control permite cambiar el flujo normal de ejecución de un programa según una condición.
> Una estructura condicional, si se cumple una condición, ejecuta un bloque de código; si no, ejecuta otro bloque de código.
> Una estructura repetitiva, permite ejecutar un mismo bloque de código varias veces, dependiendo el objeto a recorrer o condición.

##### TIPOS DE ESTRUCTURAS DE CONTROL
- if: estructura de control condicional que permite ejecutar diferentes instrucciones dependiendo de si una expresión lógica es verdadera o falsa.
```
val nota = 6.5

if (nota >= 4.0) {
  println("Aprueba Asignatura")
} else {
  println("Reprueba Asignatura")
}
```
- when: estructura de control condicional que permite comparar un valor o una condición contra distintas opciones y ejecutar el bloque correspondiente. Es más cómodo que el if cuando tenemos varias alternativas posibles para un mismo valor.
```
val opcion = 2

when(opcion) {
  1 -> println("Agregar")
  2 -> println("Editar")
  3 -> println("Eliminar")
  else -> println("Opción no válida")
```

##### CICLOS
- for: estructura de control repetitiva que permite ejecutar un bloque de instrucciones varias veces, normalmente recorriendo un rango o una colección de elementos.
```
for (i in 1..5) {
  println(i)
}
```

```
val nombres = listOf("Ana", "Lía", "Leonardo", "Fernando")

for (n in nombres) {
  println(n)
}
```

- while: estructura de control repetitiva que ejecuta un bloque de código mientras una condición sea verdadera. Se usa cuando no sabemos exactamente cuántas veces se debe repetir una acción, pero sí sabemos qué condición debe mantenerse para continuar.
```
var contadora = 1

while (contador <= 5) {
  println(contador)
  contador++
}
```


> [!TIP]
> El ciclo for normalmente se usa cuando conocemos el rango o los elementos que recorremos. While normalmente se usa cuando la repetición depende de una condición.




