/**
 * Trida reprezentujici prichozi pozadavek
 */
public class Request {
    /**
     * Prichozi cas pozadavku
     */
    double arrivedTime;

    /**
     * id zakaznika, ke kteremu se ma dopravit kolecko
     */
    double idCustomer;

    /**
     * Pocet pytlu, ktere zakaznik pozaduje
     */
    double bagCount;

    /**
     * Cas vyhrazeny na dokonceni pozadavku - za jak dlouho chce zakaznik pytel/le
     */
    double requestTime;

    public Request(double arrivedTime, double idCustomer, double bagCount, double requestTime) {
        this.arrivedTime = arrivedTime;
        this.idCustomer = idCustomer;
        this.bagCount = bagCount;
        this.requestTime = requestTime;
    }

    public void setArrivedTime(double arrivedTime) {
        this.arrivedTime = arrivedTime;
    }

    public void setIdCustomer(double idCustomer) {
        this.idCustomer = idCustomer;
    }

    public void setBagCount(double bagCount) {
        this.bagCount = bagCount;
    }

    public void setRequestTime(double requestTime) {
        this.requestTime = requestTime;
    }

    public double getArrivedTime() {
        return arrivedTime;
    }

    public double getIdCustomer() {
        return idCustomer;
    }

    public double getBagCount() {
        return bagCount;
    }

    public double getRequestTime() {
        return requestTime;
    }

    @Override
    public String toString() {
        return "Request{" +
                "arrivedTime=" + arrivedTime +
                ", idCustomer=" + idCustomer +
                ", bagCount=" + bagCount +
                ", requestTime=" + requestTime +
                '}';
    }
}
