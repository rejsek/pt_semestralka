import java.util.Random;

/**
 * Trida reprezentujici kolecko
 */
public class Barrow {
    /**
     *
     */
    private int id;

    /**
     *
     */
    public static int count = 1;

    /**
     * Nazev, druh, kolecka
     */
    private String name;

    /**
     * Minimalni a maximalni rychlost
     */
    private double min_speed, max_speed;

    /**
     * Minimalni a maximalni vzdalenost
     */
    private double min_distance, max_distance;

    /**
     * Cas opravy
     */
    private double repair_time;

    /**
     * Maximalni kapacita
     */
    private double max_capacity;

    /**
     * Pomer
     */
    private double ratio;

    /**
     *
     */
    private Warehouse warehouse;

    /**
     * Kolik kolecko jeste muze ujet, nez bude potrebovat opravit
     */
    private double durability;

    /**
     * Rychlost kolecka
     */
    private double speed;

    public Barrow(String name, double min_speed, double max_speed, double min_distance, double max_distance, double repair_time, double max_capacity, double ratio) {
        /**
         * Konstruktor
         *
         * @param name              nazev, druh, kolecka
         * @param min_speed         minimalni rychlost
         * @param max_speed         maximalni rychlost
         * @param min_distance      minimalni vzdalenost
         * @param max_distance      maximalni vzdalenost
         * @param repair_time       cas opravy
         * @param max_capacity      maximalni kapacita kolecka
         * @param ratio             pomer
         */

        this.name = name;
        this.min_speed = min_speed;
        this.max_speed = max_speed;
        this.min_distance = min_distance;
        this.max_distance = max_distance;
        this.repair_time = repair_time;
        this.max_capacity = max_capacity;
        this.ratio = ratio;
        this.durability = max_distance;

        Random random = new Random();
        if(min_speed < max_speed)
            this.speed = random.nextDouble(this.min_speed, this.max_speed);
        else if(min_speed == max_speed){
            this.speed = max_speed;
        }
        else{
            this.speed = 0;
        }
    }

    public Barrow(Barrow barrow){
        //id bud ukladat sem nebo v mainu?
        this.id = count++;
        this.speed = barrow.getSpeed();

        this.min_distance = barrow.getMin_distance();
        this.max_distance = barrow.getMax_distance(); //potrebujeme dodelat ty druhy kolecek, aby se jim generovala ta distance

        this.repair_time = barrow.getRepair_time();
        this.max_capacity = barrow.getMax_capacity();
        this.durability = barrow.getMax_distance();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMin_speed(double min_speed) {
        this.min_speed = min_speed;
    }

    public void setMax_speed(double max_speed) {
        this.max_speed = max_speed;
    }

    public void setMin_distance(double min_distance) {
        this.min_distance = min_distance;
    }

    public void setMax_distance(double max_distance) {
        this.max_distance = max_distance;
    }

    public void setRepair_time(double repair_time) {
        this.repair_time = repair_time;
    }

    public void setMax_capacity(double max_capacity) {
        this.max_capacity = max_capacity;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public double getMin_speed() {
        return min_speed;
    }

    public double getMax_speed() {
        return max_speed;
    }

    public double getMin_distance() {
        return min_distance;
    }

    public double getMax_distance() {
        return max_distance;
    }

    public double getRepair_time() {
        return repair_time;
    }

    public double getMax_capacity() {
        return max_capacity;
    }

    public double getRatio() {
        return ratio;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDurability() {
        return durability;
    }

    public void damage(double damage) {
        this.durability -= damage;
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
