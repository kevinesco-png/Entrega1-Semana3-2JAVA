Entrega 1 – Semana 3
Conceptos Fundamentales de Programación

En esta entrega trabajé en la generación de los archivos que se usarán como datos de entrada del proyecto. La clase GenerateInfoFiles está escrita en Java 8. Al ejecutarla se crean un archivo de productos, otro de vendedores y cuatro archivos de ventas, uno para cada vendedor.

Los archivos se pueden relacionar entre sí: cada venta utiliza el número de documento de un vendedor registrado y el identificador de un producto existente. Los precios y las cantidades son positivos. Parte de los datos cambia cada vez que se ejecuta el programa para tener distintos ejemplos de prueba.

Para probarlo en Eclipse, se importa la carpeta como proyecto existente y se ejecuta src/GenerateInfoFiles.java como aplicación Java. Los archivos de texto aparecen en la carpeta principal del proyecto; si Eclipse no los muestra de inmediato, basta con actualizar el proyecto con Refresh.

En esta primera entrega el programa solo genera los datos. Los cálculos de ventas y los reportes se desarrollarán en la siguiente etapa.
