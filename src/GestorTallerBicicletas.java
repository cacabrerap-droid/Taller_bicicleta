import java.util.ArrayList;
import java.util.List;

public class GestorTallerBicicletas {
    private List<Bicicleta> bicicletas;

    public GestorTallerBicicletas() {
        this.bicicletas = new ArrayList<>();
    }

    public void registrarBicicleta(Bicicleta b) {
        bicicletas.add(b);
        String tipo = b instanceof BicicletaElectrica ? "BicicletaElectrica" : "BicicletaMontanya";
        System.out.println(b.getCodigo() + " (" + tipo + ") registrada correctamente.");
    }

    public List<Bicicleta> buscarBicicleta(String codigo) {
        List<Bicicleta> encontradas = new ArrayList<>();
        for (Bicicleta b : bicicletas) {
            if (b.getCodigo().equalsIgnoreCase(codigo)) {
                encontradas.add(b);
            }
        }
        return encontradas;
    }

    public List<Bicicleta> buscarBicicleta(String codigo, int anio) {
        List<Bicicleta> encontradas = new ArrayList<>();
        for (Bicicleta b : bicicletas) {
            if (b.getCodigo().equalsIgnoreCase(codigo) && b.getAnioFabricacion() == anio) {
                encontradas.add(b);
            }
        }
        return encontradas;
    }

    public void listarBicicletas() {
        System.out.println("\n=== LISTADO DE BICICLETAS ===");
        for (Bicicleta b : bicicletas) {
            System.out.println(b.toString());
        }
    }
}