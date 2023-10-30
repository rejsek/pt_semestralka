/**
 * Interface
 */
public interface IGraph {
    /**
     * Metoda pro vraceni id
     * @return id
     */
    public int getId();

    /**
     * Metoda vrati, jestli je objekt sklad
     * @return true     pokud je sklad
     *         false    pokud neni sklad
     */
    public boolean isWarehouse();

    /**
     * Vrati x pozici
     * @return x pozice
     */
    public double getX();

    /**
     * Vrati y pozici
     * @return y pozice
     */
    public double getY();
}
