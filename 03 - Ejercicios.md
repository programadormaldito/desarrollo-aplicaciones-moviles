#### 1. Calculadora de compra con descuento
Una tienda necesita un programa que permita calcular el valor final de una compra.
El programa debe solicitar al usuario:

- Nombre del producto.
- Precio unitario.
- Cantidad de productos.

Luego debe calcular el subtotal de la compra.
Si el subtotal es mayor o igual a $50.000, se debe aplicar un 10% de descuento. En caso contrario, no se aplica descuento.

Finalmente debe mostrar:
```
Producto: Audífonos
Precio unitario: $15000
Cantidad: 4

Subtotal: $60000
Descuento: $6000
Total a pagar: $54000
```


#### 2. Clasificación de notas
Crear un programa que solicite al usuario una nota entre 1.0 y 7.0.

El programa debe indicar la situación del estudiante utilizando if o when (sugerencia: ambos):
```
1.0 a 3.9 → Reprobado
4.0 a 4.9 → Aprobado
5.0 a 5.9 → Buen rendimiento
6.0 a 7.0 → Excelente rendimiento
```
Si el usuario ingresa una nota fuera del rango permitido, debe mostrar:
```
Nota no válida
```
Ejemplo:
```
Ingrese su nota: 5.5

Resultado: Buen rendimiento
```


#### 3. Menú de operaciones
Crear un programa que muestre el siguiente menú:
```
========================
     MENÚ PRINCIPAL
========================

1. Tabla de multiplicar
2. Determinar par o impar
3. Comparar dos números
4. Salir

Seleccione una opción:
```
El menú debe mantenerse funcionando hasta que el usuario seleccione la opción 4.

Según la opción seleccionada:
- **Opción 1**: solicitar un número y mostrar su tabla de multiplicar del 1 al 10 utilizando un for.

```
Ingrese un número: 5

5 x 1 = 5
5 x 2 = 10
5 x 3 = 15
...
5 x 10 = 50
```
- **Opción 2**: solicitar un número e indicar si es par o impar.
```
Ingrese un número: 7

El número 7 es impar.
```

- **Opción 3**: solicitar dos números e indicar cuál es mayor o si son iguales.
```
Primer número: 15
Segundo número: 8

15 es mayor que 8.
```

- **Opción 4**: mostrar:
```
Programa finalizado.
```

Si selecciona cualquier otra opción:
```
Opción no válida.
```

