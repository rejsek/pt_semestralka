/**
 * Trida reprezentujici sklad
 */
public class Warehouse implements IGraph {
    /**
     * id skladu
     */
    int id;

    /**
     * x a y souradnice skladu
     */
    private double x, y;

    /**
     *
     */
    private double bagCount;

    /**
     *
     */
    private double restockTime;

    /**
     *
     */
    private double loadTime;

    public Warehouse(int id, double x, double y, double bagCount, double restockTime, double loadTime) {
        /**
         * Konstruktor
         *
         * @param id            id skladu
         * @param x             x souradnice
         * @param y             y souradnice
         * @param bagCount
         * @param restockTime
         * @param loadTime
         */

        this.id = id;
        this.x = x;
        this.y = y;
        this.bagCount = bagCount;
        this.restockTime = restockTime;
        this.loadTime = loadTime;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setBagCount(double bagCount) {
        this.bagCount = bagCount;
    }

    public void setRestockTime(double restockTime) {
        this.restockTime = restockTime;
    }

    public void setLoadTime(double loadTime) {
        this.loadTime = loadTime;
    }

    public int getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getBagCount() {
        return bagCount;
    }

    public double getRestockTime() {
        return restockTime;
    }

    public double getLoadTime() {
        return loadTime;
    }

    public boolean isWarehouse() {
        return true;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", bagCount=" + bagCount +
                ", restockTime=" + restockTime +
                ", loadTime=" + loadTime +
                '}';
    }
}
