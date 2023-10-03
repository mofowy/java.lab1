package Task5;

public class DeliveryDepartment {
    private String address;
    private boolean canTruckDeliver;
    private boolean canTrainDeliver;
    private boolean canBusDeliver;

    public DeliveryDepartment(String address, boolean canTruckDeliver, boolean canTrainDeliver, boolean canBusDeliver) {
        this.address = address;
        this.canTruckDeliver = canTruckDeliver;
        this.canTrainDeliver = canTrainDeliver;
        this.canBusDeliver = canBusDeliver;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isCanTruckDeliver() {
        return canTruckDeliver;
    }

    public void setCanTruckDeliver(boolean canTruckDeliver) {
        this.canTruckDeliver = canTruckDeliver;
    }

    public boolean isCanTrainDeliver() {
        return canTrainDeliver;
    }

    public void setCanTrainDeliver(boolean canTrainDeliver) {
        this.canTrainDeliver = canTrainDeliver;
    }

    public boolean isCanBusDeliver() {
        return canBusDeliver;
    }

    public void setCanBusDeliver(boolean canBusDeliver) {
        this.canBusDeliver = canBusDeliver;
    }
}
