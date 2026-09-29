public class BicicletaElectrica extends Bicicleta implements ConGarantiaExtendida {
    private int autonomiaKm;
    private boolean bateriaCertificada;
    private boolean garantiaExtendidaActiva;

    public BicicletaElectrica(String codigo, int anioFabricacion, double peso, int autonomiaKm, boolean bateriaCertificada) {
        super(codigo, anioFabricacion, peso);
        setAutonomiaKm(autonomiaKm);
        setBateriaCertificada(bateriaCertificada);
        this.garantiaExtendidaActiva = false;
    }

    public int getAutonomiaKm() { return autonomiaKm; }

    public void setAutonomiaKm(int autonomiaKm) {
        if (autonomiaKm < 0) {
            throw new IllegalArgumentException("La autonomía no puede ser negativa.");
        }
        this.autonomiaKm = autonomiaKm;
    }

    public boolean isBateriaCertificada() { return bateriaCertificada; }

    public void setBateriaCertificada(boolean bateriaCertificada) {
        this.bateriaCertificada = bateriaCertificada;
    }

    @Override
    public boolean tieneGarantiaExtendida() {
        return garantiaExtendidaActiva;
    }

    @Override
    public void activarGarantiaExtendida() {
        this.garantiaExtendidaActiva = true;
    }

    @Override
    public double calcularCostoMantencion() {
        double costoBase = 45000;
        if (!bateriaCertificada) {
            costoBase += costoBase * 0.25;
        }
        return costoBase;
    }

    public String obtenerDetalle() {
        return "Tipo: Bicicleta Eléctrica | Código: " + codigo + " | Año: " + anioFabricacion +
                " | Peso: " + peso + " kg | Autonomía: " + autonomiaKm + " km | Batería certificada: " +
                (bateriaCertificada ? "Si" : "No") + "\n  Garantia extendida: " +
                (garantiaExtendidaActiva ? "Si" : "No") + " | Costo mantención: $" + (int)calcularCostoMantencion();
    }
}