import java.util.Scanner;
public class HotelReservationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Room[] rooms = {

                new Room(101, "Standard", 2000),
                new Room(102, "Deluxe", 4000),
                new Room(103, "Suite", 7000)
        };

        int choice;

        do {

            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Search Room");
            System.out.println("3. Book Room");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Booking Details");
            System.out.println("6. Manage Hotel Rooms");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\n===== ROOM LIST =====");

                    for (Room r : rooms) {

                        System.out.println(
                                "Room No: " + r.roomNumber +
                                " | Category: " + r.category +
                                " | Price: Rs." + r.price +
                                " | Status: " + (r.isBooked ? "Booked" : "Available"));
                    }

                    break;

                case 2:

                    System.out.print("\nEnter Category To Search: ");
                    String search = sc.next();

                    boolean found = false;

                    System.out.println("\n===== SEARCH RESULT =====");

                    for (Room r : rooms) {

                        if (r.category.equalsIgnoreCase(search)) {

                            found = true;

                            System.out.println(
                                    "Room No: " + r.roomNumber +
                                    " | Category: " + r.category +
                                    " | Price: Rs." + r.price +
                                    " | Status: " + (r.isBooked ? "Booked" : "Available"));
                        }
                    }

                    if (!found) {

                        System.out.println("Room Category Not Found!");
                    }

                    break;

                case 3:

                    System.out.print("\nEnter Room Number To Book: ");
                    int bookRoom = sc.nextInt();

                    found = false;

                    for (Room r : rooms) {

                        if (r.roomNumber == bookRoom) {

                            found = true;

                            if (!r.isBooked) {

                                sc.nextLine();

                                System.out.print("Enter Customer Name: ");
                                r.customerName = sc.nextLine();

                                r.isBooked = true;

                                System.out.println("\n===== PAYMENT SIMULATION =====");
                                System.out.println("Room Price: Rs." + r.price);
                                System.out.println("Payment Status: Paid");

                                System.out.println("\nRoom Booked Successfully!");

                            } else {

                                System.out.println("\nRoom Already Booked!");
                            }
                        }
                    }

                    if (!found) {

                        System.out.println("\nInvalid Room Number!");
                    }

                    break;

                case 4:

                    System.out.print("\nEnter Room Number To Cancel Booking: ");
                    int cancelRoom = sc.nextInt();

                    found = false;

                    for (Room r : rooms) {

                        if (r.roomNumber == cancelRoom) {

                            found = true;

                            if (r.isBooked) {

                                r.isBooked = false;
                                r.customerName = "";

                                System.out.println("\nBooking Cancelled Successfully!");

                            } else {

                                System.out.println("\nRoom Is Not Booked!");
                            }
                        }
                    }

                    if (!found) {

                        System.out.println("\nInvalid Room Number!");
                    }

                    break;

                case 5:

                    System.out.println("\n===== BOOKING DETAILS =====");

                    boolean bookingFound = false;

                    for (Room r : rooms) {

                        if (r.isBooked) {

                            bookingFound = true;

                            System.out.println(
                                    "Customer Name: " + r.customerName +
                                    " | Room No: " + r.roomNumber +
                                    " | Category: " + r.category +
                                    " | Price: Rs." + r.price);
                        }
                    }

                    if (!bookingFound) {

                        System.out.println("No Bookings Found!");
                    }

                    break;

                case 6:

                    System.out.println("\n===== MANAGE HOTEL ROOMS =====");

                    for (Room r : rooms) {

                        System.out.println(
                                "Room No: " + r.roomNumber +
                                " | Category: " + r.category +
                                " | Price: Rs." + r.price +
                                " | Status: " + (r.isBooked ? "Booked" : "Available"));
                    }

                    break;

                case 7:

                    System.out.println("\nThank You For Using Hotel Reservation System!");
                    break;

                default:

                    System.out.println("\nInvalid Choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}
class Room {

    int roomNumber;
    String category;
    int price;
    boolean isBooked;
    String customerName;

    Room(int roomNumber, String category, int price) {

        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.isBooked = false;
        this.customerName = "";
    }
}
