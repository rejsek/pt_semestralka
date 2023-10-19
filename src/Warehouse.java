public class Warehouse {
    private int x, y;
    private int bagCount;
    private int restockTime;
    private int loadTime;


    public Warehouse(int x, int y, int bagCount, int restockTime, int loadTime) {
        this.x = x;
        this.y = y;
        this.bagCount = bagCount;
        this.restockTime = restockTime;
        this.loadTime = loadTime;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setBagCount(int bagCount) {
        this.bagCount = bagCount;
    }

    public void setRestockTime(int restockTime) {
        this.restockTime = restockTime;
    }

    public void setLoadTime(int loadTime) {
        this.loadTime = loadTime;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getBagCount() {
        return bagCount;
    }

    public int getRestockTime() {
        return restockTime;
    }

    public int getLoadTime() {
        return loadTime;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "x=" + x +
                ", y=" + y +
                ", bagCount=" + bagCount +
                ", restockTime=" + restockTime +
                ", loadTime=" + loadTime +
                '}';
    }
}
