public class Barrow {
    private String name;
    private int min_speed, max_speed;
    private int min_distance, max_distance;
    private int repair_time;
    private int max_capacity;
    private double ratio;
    private Warehouse warehouse;

    public Barrow(String name, int min_speed, int max_speed, int min_distance, int max_distance, int repair_time, int max_capacity, double ratio) {
        this.name = name;
        this.min_speed = min_speed;
        this.max_speed = max_speed;
        this.min_distance = min_distance;
        this.max_distance = max_distance;
        this.repair_time = repair_time;
        this.max_capacity = max_capacity;
        this.ratio = ratio;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMin_speed(int min_speed) {
        this.min_speed = min_speed;
    }

    public void setMax_speed(int max_speed) {
        this.max_speed = max_speed;
    }

    public void setMin_distance(int min_distance) {
        this.min_distance = min_distance;
    }

    public void setMax_distance(int max_distance) {
        this.max_distance = max_distance;
    }

    public void setRepair_time(int repair_time) {
        this.repair_time = repair_time;
    }

    public void setMax_capacity(int max_capacity) {
        this.max_capacity = max_capacity;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public String getName() {
        return name;
    }

    public int getMin_speed() {
        return min_speed;
    }

    public int getMax_speed() {
        return max_speed;
    }

    public int getMin_distance() {
        return min_distance;
    }

    public int getMax_distance() {
        return max_distance;
    }

    public int getRepair_time() {
        return repair_time;
    }

    public int getMax_capacity() {
        return max_capacity;
    }

    public double getRatio() {
        return ratio;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    @Override
    public String toString() {
        return "Barrow{" +
                "name='" + name + '\'' +
                ", min_speed=" + min_speed +
                ", max_speed=" + max_speed +
                ", min_distance=" + min_distance +
                ", max_distance=" + max_distance +
                ", repair_time=" + repair_time +
                ", max_capacity=" + max_capacity +
                ", ratio=" + ratio +
                '}';
    }
}
