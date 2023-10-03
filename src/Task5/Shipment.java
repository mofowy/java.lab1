package Task5;

import java.util.Scanner;

public class Shipment {
    private static final int MAX_ITEMS = 15;
    private Item[] items;
    private Customer sender, receiver;
    private DeparturePoint departure;
    private ReceivePoint receive;
    private double maxWeight;
    private double totalWeight;
    private String deliveryType;

    public Shipment(ReceivePoint[] receivePoints, DeparturePoint[] departurePoints, Scanner scanner) {
        createShipment(receivePoints, departurePoints, scanner);
    }

    private void initialize(Customer sender, Customer receiver, DeparturePoint departure, ReceivePoint receive) {
        this.items = new Item[MAX_ITEMS];
        this.totalWeight = 0;
        this.sender = sender;
        this.receiver = receiver;
        this.departure = departure;
        this.receive = receive;
        maxWeight = Math.max(departure.getMaxWeight(), receive.getIsCourier() ? 0 : departure.getMaxWeight());
    }

    void createShipment(ReceivePoint[] receivePoints, DeparturePoint[] departurePoints, Scanner scanner) {
        try {
            System.out.println("Adding a new shipment:");

            System.out.println("Sender initials:");
            String senderName = scanner.nextLine();
            sender = new Customer(senderName);

            System.out.println("Receiver initials:");
            String receiverName = scanner.nextLine();
            receiver = new Customer(receiverName);

            selectDeparturePoint(departurePoints, scanner);
            selectReceivePoint(receivePoints, scanner);

            System.out.println("Delivery type (Truck/Train/Bus):");
            deliveryType = scanner.nextLine();

            maxWeight = Math.max(departure.getMaxWeight(), receive.getIsCourier() ? 0 : departure.getMaxWeight());

            items = new Item[MAX_ITEMS];
            totalWeight = 0;

            while (addItemFromConsole(scanner)) ;
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    private void selectDeparturePoint(DeparturePoint[] departurePoints, Scanner scanner) {
        boolean good = false;
        do {
            System.out.println("Addresses of departure points:");
            for (DeparturePoint departurePoint : departurePoints) {
                System.out.print(departurePoint.getAddress() + " ");
            }
            System.out.println();

            System.out.println("Sender address:");
            String senderAddress = scanner.nextLine();

            for (DeparturePoint departurePoint : departurePoints) {
                if (senderAddress.equalsIgnoreCase(departurePoint.getAddress())) {
                    departure = departurePoint;
                    good = true;
                    break;
                }
            }
        } while (!good);
    }

    private void selectReceivePoint(ReceivePoint[] receivePoints, Scanner scanner) {
        boolean good = false;
        do {
            System.out.println("Address list:");
            for (ReceivePoint receivePoint : receivePoints) {
                System.out.print(receivePoint.getAddress() + " ");
            }
            System.out.println();

            System.out.println("Set the address:");
            String receiverAddress = scanner.nextLine();

            for (ReceivePoint receivePoint : receivePoints) {
                if (receiverAddress.equalsIgnoreCase(receivePoint.getAddress())) {
                    receive = receivePoint;
                    good = true;
                    break;
                }
            }

            if (!good) {
                System.out.println("Department not found, send by a courier? (y/n)");
                String isCourier = scanner.nextLine();
                if (isCourier.equalsIgnoreCase("y")) {
                    receive = new ReceivePoint(new Courier(receiverAddress));
                    good = true;
                }
            }
        } while (!good);
    }

    public void printShipment() {
        System.out.println("Count: " + totalItems());
        for (Item item : items) {
            if (item != null)
                System.out.println("Weight: " + item.getWeight() + " Description: " + item.getDescription());
        }
        System.out.println("Total weight: " + totalWeight);
        System.out.println("Sender: " + sender.getInitials());
        System.out.println("Receiver: " + receiver.getInitials());
        System.out.println("Sender address: " + departure.getAddress());
        System.out.print("Address: " + receive.getAddress());
        if (receive.getIsCourier())
            System.out.println(" by a courier");
        else
            System.out.println(" department");
        System.out.println("Max weight: " + maxWeight);

        System.out.println("Delivery Type: " + deliveryType);
    }


    private boolean addItemFromConsole(Scanner scanner) {
        System.out.println("Add items? (y/n)");
        String isCourier = scanner.nextLine();
        if (isCourier.equalsIgnoreCase("y")) {
            System.out.println("Description:");
            String description = scanner.nextLine();
            System.out.println("Weight:");
            double weight = Double.parseDouble(scanner.nextLine());

            addItem(new Item(weight, description));
            return true;
        }
        return false;
    }

    private void addItem(Item item) {
        if (totalWeight + item.getWeight() > maxWeight) {
            System.out.println("Weight too much!");
            return;
        }
        if (totalItems() >= MAX_ITEMS) {
            System.out.println("Too many items!");
            return;
        }
        items[totalItems()] = item;
        totalWeight += item.getWeight();
    }

    private int totalItems() {
        int count = 0;
        for (Item item : items) {
            if (item != null) {
                count++;
            }
        }
        return count;
    }
}
