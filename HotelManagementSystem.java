import java.util.ArrayList;
import java.util.Scanner;

class Guest {
    private String name;
    private int roomNumber;
    private boolean checkedIn;

    public Guest(String name, int roomNumber) {
        this.name = name;
        this.roomNumber = roomNumber;
        this.checkedIn = false;
    }

    public String getName() {
        return name;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void checkIn() {
        checkedIn = true;
        System.out.println(name + " checked into room " + roomNumber);
    }

    public void checkOut() {
        checkedIn = false;
        System.out.println(name + " checked out of room " + roomNumber);
    }

    @Override
    public String toString() {
        return "Guest: " + name + ", Room Number: " + roomNumber + ", Checked In: " + checkedIn;
    }
}

class Hotel {
    private static final int TOTAL_ROOMS = 10;
    private ArrayList<Guest> guests;

    public Hotel() {
        guests = new ArrayList<>();
    }

    public void addGuest(String name, int roomNumber) {
        if (roomNumber < 1 || roomNumber > TOTAL_ROOMS) {
            System.out.println("Invalid room number.");
            return;
        }
        Guest guest = new Guest(name, roomNumber);
        guests.add(guest);
        System.out.println(name + " added to the hotel.");
    }

    public void checkIn(String name) {
        for (Guest guest : guests) {
            if (guest.getName().equalsIgnoreCase(name)) {
                guest.checkIn();
                return;
            }
        }
        System.out.println("Guest not found!");
    }

    public void checkOut(String name) {
        for (Guest guest : guests) {
            if (guest.getName().equalsIgnoreCase(name)) {
                guest.checkOut();
                return;
            }
        }
        System.out.println("Guest not found!");
    }

    public void searchByRoomNumber(int roomNumber) {
        for (Guest guest : guests) {
            if (guest.getRoomNumber() == roomNumber) {
                System.out.println("Guest found: " + guest);
                return;
            }
        }
        System.out.println("No guest found in room " + roomNumber);
    }

    public void displayCheckedInGuests() {
        System.out.println("\nChecked-In Guests:");
        boolean checkedInGuestFound = false;
        for (Guest guest : guests) {
            if (guest.isCheckedIn()) {
                checkedInGuestFound = true;
                System.out.println(guest);
            }
        }
        if (!checkedInGuestFound) {
            System.out.println("No guests are currently checked in.");
        }
    }

    public void displayAllGuests() {
        System.out.println("\nAll Guests:");
        for (Guest guest : guests) {
            System.out.println(guest);
        }
    }

    public void displayAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (int i = 1; i <= TOTAL_ROOMS; i++) {
            boolean roomAvailable = true;
            for (Guest guest : guests) {
                if (guest.getRoomNumber() == i) {
                    roomAvailable = false;
                    break;
                }
            }
            if (roomAvailable) {
                System.out.println("Room " + i);
            }
        }
    }

    public void checkGuestStatus(String name) {
        for (Guest guest : guests) {
            if (guest.getName().equalsIgnoreCase(name)) {
                System.out.println("Guest Status: " + guest);
                return;
            }
        }
        System.out.println("Guest not found!");
    }
}

public class HotelManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        while (true) {
            System.out.println("\nHotel Management System");
            System.out.println("1. Add Guest");
            System.out.println("2. Check In");
            System.out.println("3. Check Out");
            System.out.println("4. Search Guest by Room Number");
            System.out.println("5. List Checked-In Guests");
            System.out.println("6. List All Guests");
            System.out.println("7. List Available Rooms");
            System.out.println("8. Check Guest Status");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter guest name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    hotel.addGuest(name, roomNumber);
                    break;
                case 2:
                    System.out.print("Enter guest name to check in: ");
                    String checkInName = scanner.nextLine();
                    hotel.checkIn(checkInName);
                    break;
                case 3:
                    System.out.print("Enter guest name to check out: ");
                    String checkOutName = scanner.nextLine();
                    hotel.checkOut(checkOutName);
                    break;
                case 4:
                    System.out.print("Enter room number to search: ");
                    int searchRoomNumber = scanner.nextInt();
                    hotel.searchByRoomNumber(searchRoomNumber);
                    break;
                case 5:
                    hotel.displayCheckedInGuests();
                    break;
                case 6:
                    hotel.displayAllGuests();
                    break;
                case 7:
                    hotel.displayAvailableRooms();
                    break;
                case 8:
                    System.out.print("Enter guest name to check status: ");
                    String guestName = scanner.nextLine();
                    hotel.checkGuestStatus(guestName);
                    break;
                case 9:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}
