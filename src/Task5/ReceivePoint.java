package Task5;

public class ReceivePoint {
    private String address;
    private boolean isCourier;

    public ReceivePoint(String address) {
        this.address = address;
        this.isCourier = false;
    }

    public ReceivePoint(DeliveryDepartment deliveryDepartment) {
        this.address = deliveryDepartment.getAddress();
        this.isCourier = false;
    }

    public ReceivePoint(Courier courier) {
        this.address = courier.getAddress();
        this.isCourier = true;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getIsCourier() {
        return isCourier;
    }

    public void setIsCourier(boolean isCourier) {
        this.isCourier = isCourier;
    }
}
