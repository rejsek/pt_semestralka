/**
 * Trida reprezentujici cestu z jednoho vrcholu do druheho
 */
public class Way {
    /**
     * id vrcholu, ze ktereho cesta zacina
     */
    double idStart;

    /**
     * id vrcholu, ve kterem cesta konci
     */
    double idEnd;

    public Way(double idStart, double idEnd) {
        this.idStart = idStart;
        this.idEnd = idEnd;
    }

    public void setIdStart(double idStart) {
        this.idStart = idStart;
    }

    public void setIdEnd(double idEnd) {
        this.idEnd = idEnd;
    }

    public double getIdStart() {
        return idStart;
    }

    public double getIdEnd() {
        return idEnd;
    }

    @Override
    public String toString() {
        return "Way{" +
                "idStart=" + idStart +
                ", idEnd=" + idEnd +
                '}';
    }
}
