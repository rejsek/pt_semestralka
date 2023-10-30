/**
 * Trida reprezentujici zakaznika
 */
public class Customer implements IGraph {
    /**
     * id zakaznika
     */
    private int id;

    /**
     * x a y souradnice zakaznika
     */
    private double x, y;

    public Customer(int id, double x, double y) {
        /**
         * Konstruktor
         *
         * @param id    id zakaznika
         * @param x     x souradnice
         * @param y     y souradnice
         */

        this.id = id;
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
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

    @Override
    public boolean isWarehouse() {
        return false;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
