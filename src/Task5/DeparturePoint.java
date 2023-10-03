package Task5;

public class DeparturePoint {
    private String address;
    private double maxWeight;

    public DeparturePoint(String address, double maxWeight) {
        this.address = address;
        this.maxWeight = maxWeight;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }
}
