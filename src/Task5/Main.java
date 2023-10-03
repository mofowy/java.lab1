package Task5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DeliveryDepartment kyiv = new DeliveryDepartment("Kyiv", true, true, true);
        DeliveryDepartment dnipro = new DeliveryDepartment("Dnipro", true, false, false);

        ReceivePoint[] receivePoints = {new ReceivePoint(kyiv), new ReceivePoint(dnipro)};
        DeparturePoint[] departurePoints = {new DeparturePoint("Lviv", 500.0), new DeparturePoint("Rivne", 400.0), new DeparturePoint("Kyiv", 600.0)};

        final int MAX_SHIPMENTS = 10;
        boolean isContinue = true;
        Shipment[] shipments = new Shipment[MAX_SHIPMENTS];

        do {
            System.out.println("Menu:");
            System.out.println("1. View all shipments");
            System.out.println("2. Add a shipment");
            System.out.println("3. Delete a shipment");
            System.out.println("0. Exit");

            String choice = scanner.nextLine();
            int countOfShipments = 0;
            for (Shipment ship : shipments) {
                if (ship != null) {
                    countOfShipments++;
                }
            }

            switch (choice) {
                case "1": {
                    if (countOfShipments < 1)
                        System.out.println("No shipments available");
                    for (int i = 0; i < countOfShipments; i++) {
                        System.out.println("Shipment #" + (i + 1));
                        shipments[i].printShipment();
                    }
                    break;
                }
                case "2": {
                    if (countOfShipments >= MAX_SHIPMENTS) {
                        System.out.println("Too many shipments in the array");
                        break;
                    }
                    Shipment newShipment = new Shipment(receivePoints, departurePoints, scanner);
                    if (countOfShipments > 0)
                        shipments[countOfShipments - 1] = newShipment;
                    else
                        shipments[0] = newShipment;
                    break;
                }
                case "3": {
                    if (countOfShipments < 1) {
                        System.out.println("No shipments available");
                        break;
                    }
                    if (countOfShipments == 1)
                        shipments = new Shipment[MAX_SHIPMENTS];
                    System.out.println("Shipment number?");
                    int choiceOfDelete;
                    try {
                        String receiverName = scanner.nextLine();
                        choiceOfDelete = Integer.parseInt(receiverName);
                        if (choiceOfDelete > countOfShipments || choiceOfDelete < 0)
                            throw new IllegalArgumentException("Incorrect input");

                        shipments[choiceOfDelete - 1] = shipments[countOfShipments - 1];
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                }
                case "0": {
                    isContinue = false;
                    break;
                }
            }
        } while (isContinue);

        scanner.close();
    }
}
