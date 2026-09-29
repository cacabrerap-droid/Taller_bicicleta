// Diferencias de paradigmas:
// 1. En la Programación Orientada a Objetos usamos clases y objetos para agrupar los datos y comportamientos. En programación estructurada, los datos y funciones están separados.
// 2. Java compila a un código intermedio (bytecode) y se ejecuta en una máquina virtual (JVM), lo que lo hace multiplataforma. Los lenguajes estructurados como C suelen compilar directo a la máquina.
//
// Sobre el tipado:
// Java tiene tipado estático. Esto ayuda a detectar los errores tempranamente mientras programamos (en la etapa de compilación), evitando que el programa falle por usar tipos de datos incorrectos cuando ya se está ejecutando.

public class Main {
    public static void main(String[] args) {
        GestorTallerBicicletas gestor = new GestorTallerBicicletas();

        // Manejo de excepciones para evitar que el programa se caiga con datos inválidos
        try {
            BicicletaElectrica biciError = new BicicletaElectrica("ERROR", 1990, 20, 50, true);
        } catch (IllegalArgumentException e) {
            System.out.println("Validación exitosa (Excepción capturada): " + e.getMessage());
        }

        // 1. Instanciar las bicicletas con los datos de la tabla
        BicicletaElectrica b1 = new BicicletaElectrica("BIC-E01", 2023, 22.5, 60, false);
        BicicletaElectrica b2 = new BicicletaElectrica("BIC-E02", 2022, 24.0, 45, true);
        BicicletaMontanya b3 = new BicicletaMontanya("BIC-M01", 2021, 13.5, 2);
        BicicletaMontanya b4 = new BicicletaMontanya("BIC-M02", 2020, 12.0, 1);

        // 2. Marcar la Bicicleta Eléctrica 'BIC-E01' con garantía extendida
        b1.activarGarantiaExtendida();

        // 3. Registrar todas las bicicletas en el gestor del sistema
        System.out.println();
        gestor.registrarBicicleta(b1);
        gestor.registrarBicicleta(b2);
        gestor.registrarBicicleta(b3);
        gestor.registrarBicicleta(b4);

        // 4. Invocar búsqueda por código "BIC-E01"
        System.out.println("\n=== BUSQUEDA POR CODIGO: \"BIC-E01\" ===");
        for (Bicicleta b : gestor.buscarBicicleta("BIC-E01")) {
            if (b instanceof BicicletaElectrica) {
                System.out.println(((BicicletaElectrica) b).obtenerDetalle());
            } else if (b instanceof BicicletaMontanya) {
                System.out.println(((BicicletaMontanya) b).obtenerDetalle());
            }
        }
        System.out.println("---");

        // 5. Listar todas las bicicletas registradas
        gestor.listarBicicletas();
    }
}