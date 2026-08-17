>[!NOTE]
>Una variable es un espacio donde nuestro programa almacena información que necesitará utilizar posteriormente

En **Kotlin** tenemos 2 maneras para definir variables:
- **val**: permite crear variables inmutables, es decir, aquellas que durante la ejecución del programa **no cambiarán su valor**.
- **var**: permite crear variables mutables, es decir, aquellas que durante la ejecución del programa **pueden cambiar su valor**.

Ejemplo
```
val nombre = "Fernando"
nombre = "Ana" // ❌ esto arroja error, ya que la variable fue definida como val
```

```
var edad = 39
edad = 40 // ✅ esto es posible, ya que la variable fue definida como var
```


>[!NOTE]
>El tipo de dato corresponde a lo que variable es capaz de almacenar, por ejemplo texto, número entero, valores booleanos, etc. En Kotlin, no es necesario escribirlo, ya que es inferido, pero de todas maneras se puede escribir.

EJEMPLOS

| TIPO    | EJEMPLO    | USO               |
| ------- | ---------- | ----------------- |
| String  | "Fernando" | Texto             |
| Int     | 39         | Número Entero     |
| Double  | 10.5       | Número Decimal    |
| Float   | 10.5f      | Número Decimal    |
| Boolean | true       | Verdadero / Falso |
| Char    | 'A'        | Un caracter       |

```
val nombre1 = "Fernando"     // ℹ️ Tipo de dato inferido
val nombre2: String = "Ana"  // ℹ️ Tipo de dato explícito
```

##### SALIDA DE INFORMACIÓN

Permite mostrar información en consola
```println("Desarrollo de Aplicaciones Móviles")```

##### INTERPOLACIÓN DE VARIABLES

Permite "incrustar" variables dentro de una cadena de texto

```
val nombre = "Fernando"
val edad = 39

println("Mi nombre es $nombre y tengo $edad años")
```

También:
```
val edad = 39

println("El próximo año tendré ${edad + 1} años")
```

##### OPERADORES MATEMÁTICOS
```
+ Suma
- Resta
* Multiplicación
/ División
% Resto
```

