import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

/**
 * Genera los archivos planos de entrada del proyecto de ventas.
 *
 * <p>Formato: campos separados por punto y coma, sin encabezados. Cada ejecución
 * reemplaza los archivos de ejemplo en la carpeta del proyecto. No solicita
 * información por teclado.</p>
 */
public final class GenerateInfoFiles {

    private static final Path DATA_DIRECTORY = Paths.get(".");
    private static final Random RANDOM = new Random();
    private static final String DOCUMENT_TYPE = "CC";
    private static final int PRODUCT_COUNT = 8;
    private static final int SALESMAN_COUNT = 4;
    private static int availableProductCount = PRODUCT_COUNT;
    private static final String[] FIRST_NAMES = {
        "Ana", "Carlos", "Laura", "Miguel", "Sofia", "Andres", "Paula", "Diego"
    };
    private static final String[] LAST_NAMES = {
        "Gomez", "Torres", "Ramirez", "Morales", "Castro", "Rojas", "Vargas", "Lopez"
    };
    private static final String[] PRODUCT_NAMES = {
        "Cuaderno", "Lapiz", "Boligrafo", "Carpeta", "Borrador",
        "Regla", "Marcador", "Resaltador", "Tijeras", "Pegante"
    };

    private GenerateInfoFiles() {
        // Clase de utilidad: todos sus métodos son estáticos.
    }

    /**
     * Ejecuta la generación completa de datos de prueba.
     *
     * @param args argumentos no utilizados
     */
    public static void main(String[] args) {
        try {
            createProductsFile(PRODUCT_COUNT);
            createSalesManInfoFile(SALESMAN_COUNT);
            for (int index = 0; index < SALESMAN_COUNT; index++) {
                long documentNumber = documentNumberFor(index);
                String firstName = FIRST_NAMES[index % FIRST_NAMES.length];
                createSalesMenFile(1 + RANDOM.nextInt(6), firstName, documentNumber);
            }
            System.out.println("Generación finalizada correctamente en: "
                    + DATA_DIRECTORY.toAbsolutePath());
        } catch (IOException | IllegalArgumentException exception) {
            System.err.println("Error al generar los archivos: " + exception.getMessage());
            System.exit(1);
        }
    }

    /**
     * Crea el archivo de ventas de un vendedor.
     * La primera línea identifica al vendedor; las demás contienen ID de producto
     * y cantidad vendida. Los IDs corresponden a los productos generados.
     *
     * @param randomSalesCount número de líneas de venta, cero o mayor
     * @param name nombre del vendedor usado en el nombre del archivo
     * @param id número de documento del vendedor
     * @throws IOException si no se puede escribir el archivo
     */
    public static void createSalesMenFile(int randomSalesCount, String name, long id)
            throws IOException {
        if (randomSalesCount < 0 || id <= 0 || name == null
                || !name.matches("[A-Za-z]+")) {
            throw new IllegalArgumentException("Datos de vendedor o cantidad de ventas no válidos.");
        }
        Files.createDirectories(DATA_DIRECTORY);
        Path file = DATA_DIRECTORY.resolve("ventas_" + DOCUMENT_TYPE + "_" + id + "_" + name + ".txt");
        try (BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
            writer.write(DOCUMENT_TYPE + ";" + id);
            writer.newLine();
            for (int sale = 0; sale < randomSalesCount; sale++) {
                int productId = 1 + RANDOM.nextInt(availableProductCount);
                int quantity = 1 + RANDOM.nextInt(12);
                writer.write(productId + ";" + quantity + ";");
                writer.newLine();
            }
        }
    }

    /**
     * Crea {@code productos.txt} con IDs consecutivos, nombres reales de artículos
     * y precios unitarios positivos en pesos colombianos, sin decimales.
     *
     * @param productsCount cantidad de productos, entre 1 y 10
     * @throws IOException si no se puede escribir el archivo
     */
    public static void createProductsFile(int productsCount) throws IOException {
        if (productsCount < 1 || productsCount > PRODUCT_NAMES.length) {
            throw new IllegalArgumentException("La cantidad de productos debe estar entre 1 y "
                    + PRODUCT_NAMES.length + ".");
        }
        availableProductCount = productsCount;
        Files.createDirectories(DATA_DIRECTORY);
        try (BufferedWriter writer = Files.newBufferedWriter(
                DATA_DIRECTORY.resolve("productos.txt"), StandardCharsets.UTF_8)) {
            for (int index = 0; index < productsCount; index++) {
                int price = 1000 + RANDOM.nextInt(50) * 500;
                writer.write((index + 1) + ";" + PRODUCT_NAMES[index] + ";" + price);
                writer.newLine();
            }
        }
    }

    /**
     * Crea {@code vendedores.txt}. Los documentos son únicos y estables, de modo
     * que coinciden con las primeras líneas de los archivos de ventas.
     *
     * @param salesmanCount cantidad de vendedores, entre 1 y 8
     * @throws IOException si no se puede escribir el archivo
     */
    public static void createSalesManInfoFile(int salesmanCount) throws IOException {
        if (salesmanCount < 1 || salesmanCount > FIRST_NAMES.length) {
            throw new IllegalArgumentException("La cantidad de vendedores debe estar entre 1 y "
                    + FIRST_NAMES.length + ".");
        }
        Files.createDirectories(DATA_DIRECTORY);
        try (BufferedWriter writer = Files.newBufferedWriter(
                DATA_DIRECTORY.resolve("vendedores.txt"), StandardCharsets.UTF_8)) {
            for (int index = 0; index < salesmanCount; index++) {
                writer.write(DOCUMENT_TYPE + ";" + documentNumberFor(index) + ";"
                        + FIRST_NAMES[index] + ";"
                        + LAST_NAMES[RANDOM.nextInt(LAST_NAMES.length)]);
                writer.newLine();
            }
        }
    }

    private static long documentNumberFor(int index) {
        return 10000001L + index;
    }
}
