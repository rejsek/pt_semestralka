public class Customer {
    private int id;
    private int x, y;

    public Customer(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    public int getId() {
        return id;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
