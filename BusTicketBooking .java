import java.util.*;

class BusTicket {
    int ticketId;
    String passengerName;
    String destination;
    int seatNumber;
    double price;

    BusTicket(int ticketId, String passengerName, String destination, int seatNumber, double price) {
        this.ticketId = ticketId;
        this.passengerName = passengerName;
        this.destination = destination;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    public void print() {
        System.out.println("  [*] Ticket ID   : " + ticketId);
        System.out.println("  [*] Passenger   : " + passengerName);
        System.out.println("  [*] Destination : " + destination);
        System.out.println("  [*] Seat No     : " + seatNumber);
        System.out.printf ("  [*] Fare        : Rs. %.2f%n", price);
    }
}

public class Main {

    static void line() {
        System.out.println("  ==========================================");
    }

    static void thinLine() {
        System.out.println("  ------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<BusTicket> bookings = new ArrayList<>();
        int idCounter = 1001;

        while (true) {
            System.out.println();
            line();
            System.out.println("        R E D B U S   v2.0");
            System.out.println("        Your Journey, Our Priority");
            line();
            System.out.println("  [1]  Book New Ticket");
            System.out.println("  [2]  View Passenger Manifest");
            System.out.println("  [3]  Search by PNR / ID");
            System.out.println("  [4]  Cancel Booking");
            System.out.println("  [5]  Exit System");
            line();
            System.out.print("  SELECT SERVICE >> ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println();
                    line();
                    System.out.println("        NEW TICKET - PASSENGER INFORMATION");
                    line();
                    System.out.print("  Name        : ");
                    String name = sc.nextLine();
                    System.out.print("  Destination : ");
                    String dest = sc.nextLine();
                    System.out.print("  Seat No     : ");
                    int seat = sc.nextInt();
                    System.out.print("  Fare (Rs.)  : ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    bookings.add(new BusTicket(idCounter++, name, dest, seat, price));
                    thinLine();
                    System.out.println("  [OK] Ticket #" + (idCounter - 1) + " booked successfully!");
                    thinLine();
                    break;

                case 2:
                    System.out.println();
                    line();
                    System.out.println("        PASSENGER MANIFEST");
                    line();
                    if (bookings.isEmpty()) {
                        System.out.println("  [!] No records found in database.");
                    } else {
                        int count = 1;
                        for (BusTicket t : bookings) {
                            System.out.println("  Record [" + count++ + "]");
                            t.print();
                            thinLine();
                        }
                    }
                    break;

                case 3:
                    System.out.println();
                    thinLine();
                    System.out.print("  SEARCH ID >> ");
                    int searchId = sc.nextInt();
                    boolean found = false;
                    for (BusTicket t : bookings) {
                        if (t.ticketId == searchId) {
                            System.out.println();
                            line();
                            System.out.println("        RECORD FOUND");
                            line();
                            t.print();
                            thinLine();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("  [X] ERROR: ID not found.");
                    }
                    break;

                case 4:
                    System.out.println();
                    thinLine();
                    System.out.print("  CANCEL ID >> ");
                    int cancelId = sc.nextInt();
                    int startSize = bookings.size();
                    bookings.removeIf(t -> t.ticketId == cancelId);
                    if (bookings.size() < startSize) {
                        System.out.println("  [OK] Ticket #" + cancelId + " cancelled successfully.");
                    } else {
                        System.out.println("  [X] ERROR: ID not found.");
                    }
                    break;

                case 5:
                    System.out.println();
                    line();
                    System.out.println("   THANK YOU FOR TRAVELING WITH REDBUS!");
                    System.out.println("     Have a safe and nice journey.");
                    line();
                    return;

                default:
                    System.out.println("  [!] Invalid selection. Please choose 1 to 5.");
            }
        }
    }
}
