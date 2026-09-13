# Entrega 1 — Semana 3

**Asignatura:** Conceptos Fundamentales de Programación  
**Actividad:** Generación y clasificación de datos  
**Alcance de esta entrega:** generación de archivos planos de prueba con Java 8.

Este proyecto de Eclipse contiene la clase `GenerateInfoFiles`. Al ejecutarla, crea en la raíz del proyecto `productos.txt`, `vendedores.txt` y un archivo `ventas_CC_<documento>_<nombre>.txt` por vendedor. Cada ejecución reemplaza los archivos que tienen esos nombres. El programa no pide datos por teclado y muestra un mensaje de éxito o de error.

## Cómo abrir y ejecutar

1. En Eclipse para Java Developers, seleccione **File > Import > Existing Projects into Workspace** y elija esta carpeta.
2. Configure el JRE del proyecto como **Java 8** si Eclipse se lo solicita.
3. Abra `src/GenerateInfoFiles.java` y seleccione **Run As > Java Application**.
4. Actualice el proyecto en Eclipse para ver los archivos `.txt` generados.

También puede ejecutarse desde una terminal con Java 8, situándose en esta carpeta:

```sh
mkdir -p bin
javac -source 8 -target 8 -d bin src/GenerateInfoFiles.java
java -cp bin GenerateInfoFiles
```

## Métodos exigidos

- `createProductsFile(int productsCount)`: escribe IDs consecutivos, nombres de artículos y precios positivos.
- `createSalesManInfoFile(int salesmanCount)`: escribe un vendedor por línea con tipo y número de documento, nombre y apellido.
- `createSalesMenFile(int randomSalesCount, String name, long id)`: escribe la identificación del vendedor y la cantidad solicitada de ventas pseudoaleatorias.

`main` invoca los tres métodos en el orden necesario para crear un ejemplo coherente: 8 productos, 4 vendedores y entre 1 y 6 ventas por vendedor. Los IDs de ventas corresponden a los productos y los documentos de las ventas a los vendedores. Los valores cambian entre ejecuciones. Las cantidades y los precios siempre son positivos.

## Formatos

Los archivos son texto UTF-8, sin línea de títulos y con campos separados por `;`.

```text
ventas_CC_10000001_Ana.txt
CC;10000001
3;5;
1;2;

vendedores.txt
CC;10000001;Ana;Torres

productos.txt
1;Cuaderno;3500
```

Los ejemplos ilustran el formato; los datos efectivamente generados pueden variar. El precio es un número entero en pesos colombianos.

## Alcance

La Semana 3 solicita esencialmente la clase generadora. La lectura, clasificación y creación de reportes de vendedores y productos pertenecen a la siguiente entrega, por lo que aún no hay una segunda clase con `main`.

Antes de compartir el repositorio, agregue el enlace a su entrega en la plataforma de la asignatura. Esta carpeta ya incluye la estructura de proyecto Eclipse y el código fuente necesario.
