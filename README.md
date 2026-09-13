# Entrega 1: Semana 3

**Conceptos Fundamentales de Programación**  
**Proyecto:** Generación y clasificación de datos

En esta primera entrega preparé la parte que genera los archivos de prueba. El programa está hecho en Java 8 y su clase principal se llama `GenerateInfoFiles`.

Al ejecutarlo se crean seis archivos de texto en la carpeta del proyecto: `productos.txt`, `vendedores.txt` y cuatro archivos de ventas, uno por vendedor. Los datos cambian en cada ejecución, pero se mantienen relacionados: las ventas usan productos que aparecen en `productos.txt` y documentos que aparecen en `vendedores.txt`.

## Cómo probarlo
1. Importar esta carpeta en Eclipse con **File > Import > Existing Projects into Workspace**.
2. Comprobar que el proyecto use **Java 8**.
3. Abrir `src/GenerateInfoFiles.java` y ejecutarlo con **Run As > Java Application**.
4. Actualizar el proyecto con **Refresh** para ver los archivos generados.

El programa no pide información por teclado. Al terminar, muestra en la consola un mensaje de éxito o de error.

## Qué contiene cada archivo

- `productos.txt`: identificador, nombre y precio de cada producto.
- `vendedores.txt`: tipo y número de documento, nombre y apellido de cada vendedor.
- `ventas_CC_...txt`: en la primera línea aparece el documento del vendedor; en las siguientes, el producto y la cantidad vendida.

Los campos se separan con punto y coma. Por ejemplo, `1;Cuaderno;3500` indica que el producto 1 es un cuaderno de 3500 pesos. En un archivo de ventas, `1;2;` indica dos unidades del producto 1.

La clase incluye los tres métodos solicitados: `createProductsFile`, `createSalesManInfoFile` y `createSalesMenFile`. La ejecución de ejemplo genera 8 productos, 4 vendedores y entre 1 y 6 ventas para cada vendedor.

Esta entrega se centra en **generar los archivos de entrada**. El cálculo y la clasificación de las ventas corresponden a la siguiente etapa del proyecto.
