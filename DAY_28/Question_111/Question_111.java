// Write a program to Create ticket booking system.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Question_111 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        header("TICKET BOOKING SYSTEM");
        programStarter();
    }

    public static void header(String str) {
        System.out.println("============================================================");
        System.out.println("                " + str);
        System.out.println("============================================================");
    }

    public static void programStarter() {
        System.out.println("------------------------------------------------------------");
        while (true) {
            System.out.println("[1] Start Exploring Shows");
            System.out.println("[2] Exit");
            System.out.print("Choose your option : ");
            int choice = sc.nextInt();
            if (choice == 1) {
                postCustomerLogin();
            } else if (choice == 192837465) {
                System.out.println("Admin Access Granted !");
                adminPanel();
            } else if (choice == 2) {
                programExit();
            } else {
                System.out.println("Invalid Input ! Please enter a valid input.");
                continue;
            }
        }
    }

    public static void postCustomerLogin() {

        while (true) {
            System.out.println("============================================================");
            System.out.println("HELLO ! What do you want now?");
            System.out.println("[1] Check your Bookings.");
            System.out.println("[2] Explore shows.");
            System.out.println("[3] Book a ticket.");
            System.out.println("[4] Print Your Ticket.");
            System.out.println("[5] Exit.");
            System.out.print("Enter your Choice : ");
            int choice = sc.nextInt();
            if (choice == 1) {
                checkBookings();
            } else if (choice == 2) {
                showsPrint();
            } else if (choice == 3) {
                bookTicket();
            } else if (choice == 4) {
                printTicket();
            } else if (choice == 5) {
                programExit();
            } else {
                System.out.println("Invalid input ! Please re-enter your choice.");
                continue;
            }
        }
    }

    public static boolean showExists(int showId) {
        try (BufferedReader br = new BufferedReader(new FileReader("shows.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (showId == Integer.parseInt(data[0])) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error opening shows record.");
        }
        return false;
    }

    public static String showName(int showId) {
        try (BufferedReader br = new BufferedReader(new FileReader("shows.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (showId == Integer.parseInt(data[0])) {
                    return data[1];
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public static void seatCountUpdate(int showId, int seats) {
        int count;
        ArrayList<String> record = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("shows.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                count = Integer.parseInt(data[5]);
                if (showId == Integer.parseInt(data[0])) {
                    if (count >= seats) {
                        count -= seats;
                    } else {
                        System.out.println("Not enough seats available.");
                        return;
                    }
                    record.add(showId + "|" + data[1] + "|" + data[2] + "|" + data[3] + "|" + data[4] + "|" + count);
                } else {
                    record.add(line);
                }
            }
            try (BufferedWriter bw = new BufferedWriter(
                    new FileWriter("shows.txt"))) {
                for (String record1 : record) {
                    bw.write(record1);
                    bw.newLine();
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void showsAdder() {
        int showId;
        while (true) {
            System.out.print("Enter the SHOW ID : ");
            showId = sc.nextInt();
            if (showId < 0) {
                System.out.println("Invalid Show Id ! Please enter a valid Id.");
                continue;
            }
            if (!showExists(showId)) {
                break;
            } else {
                System.out.println("This show already exists.");
                return;
            }
        }
        System.out.print("Enter SHOW name : ");
        sc.nextLine();
        String showName = sc.nextLine();
        System.out.print("Enter Date of Show (Like : 24052026) : ");
        String showDate = sc.nextLine();
        System.out.print("Enter Time of show (Like : 5pm) : ");
        String showTime = sc.nextLine();
        int showPrice;
        while (true) {
            System.out.print("Enter show Price : ");
            showPrice = sc.nextInt();
            if (showPrice <= 0) {
                System.out.println("Invalid Show Price ! Please enter a valid privce.");
                continue;
            } else {
                break;
            }
        }
        int seats;
        while (true) {
            System.out.print("Enter available seats : ");
            seats = sc.nextInt();
            if (seats <= 0) {
                System.out.println("Invalid seat count!");
                continue;
            }
            break;
        }
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("shows.txt", true))) {
            bw.write(showId + "|" + showName + "|" + showDate + "|" + showTime + "|" + showPrice + "|" + seats);
            bw.newLine();
            System.out.println("Show added successfully.");

        } catch (Exception e) {
            System.out.println(
                    "Server Error Occurred ! Please try after sometime.");
        }
    }

    public static void showDelete() {
        int showId;
        while (true) {
            System.out.print("Enter the SHOW ID : ");
            showId = sc.nextInt();
            if (showId < 0) {
                System.out.println("Invalid Show Id ! Please enter a valid Id.");
                continue;
            }
            if (!showExists(showId)) {
                System.out.println("This show does not exists.");
                return;
            } else {
                break;
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader("shows.txt"))) {
            String line;
            ArrayList<String> showRecord = new ArrayList<>();
            ArrayList<String> bookingRecord = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (showId == Integer.parseInt(data[0])) {
                    continue;
                } else {
                    showRecord.add(line);
                }
            }
            try (BufferedReader br1 = new BufferedReader(new FileReader("bookings.txt"))) {
                String line1;
                while ((line1 = br1.readLine()) != null) {
                    String[] data1 = line1.split("\\|");
                    if (showId == Integer.parseInt(data1[2])) {
                        continue;
                    } else {
                        bookingRecord.add(line1);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error updating bookings Record! Please try after sometime.");
                return;
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter("shows.txt"))) {
                for (String SR : showRecord) {
                    bw.write(SR);
                    bw.newLine();
                }
                try (BufferedWriter bw1 = new BufferedWriter(new FileWriter("bookings.txt"))) {
                    for (String BR : bookingRecord) {
                        bw1.write(BR);
                        bw1.newLine();
                    }

                } catch (Exception e) {
                    System.out.println("Booking Records not updated!");
                    return;
                }

                System.out.println("Show Deleted Successfully !");
                return;
            } catch (Exception e) {
                System.out.println("Shows Records not updated!");
                return;
            }
        } catch (Exception e) {
            System.out.println("Error opening shows record ! Please try after sometime.");
            return;
        }
    }

    public static void showsPrint() {
        System.out.println(
                "===========================================================================================================================");
        System.out.println("                                         ALL SHOWS");
        System.out.println(
                "===========================================================================================================================");
        System.out.printf(
                "%-8s %-18s %-25s %-20s %-15s %-15s %-15s%n",
                "Sr No.",
                "Show ID",
                "Show Name",
                "Date",
                "Time",
                "Price",
                "Available Seats");
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------------");
        try (BufferedReader br = new BufferedReader(new FileReader("shows.txt"))) {
            String line;
            int count = 1;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length < 6)
                    continue;
                found = true;
                System.out.printf(
                        "%-8s %-18s %-25s %-20s %-15s %-15s %-15s%n",
                        count,
                        data[0],
                        data[1],
                        data[2],
                        data[3],
                        data[4],
                        data[5]);
                count++;
            }
            if (!found) {
                System.out.println("No shows found.");
            } else {
                System.out.println(
                    "--------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Total SHOWS : " + (count - 1));
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
            }

        } catch (java.io.FileNotFoundException e) {
            System.out.println("You don't have any shows saved yet.");
        } catch (Exception e) {
            System.out.println("Server Error! Please try again later.");
        }
    }

    public static void customerList() {
        int showId;
        while (true) {
            System.out.print("Enter the SHOW ID : ");
            showId = sc.nextInt();
            if (showId < 0) {
                System.out.println("Invalid Show Id ! Please enter a valid Id.");
                continue;
            }
            if (!showExists(showId)) {
                System.out.println("This show does not exists.");
                return;
            } else {
                break;
            }
        }
        header("ALL CUSTOMERS");
        System.out.printf(
                "%-8s %-25s %-15s%n",
                "Sr No.",
                "Customer Name",
                "Seats Booked");
        System.out.println("--------------------------------------------------");
        try (BufferedReader br = new BufferedReader(new FileReader("bookings.txt"))) {
            String line;
            int count = 1;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (showId == Integer.parseInt(data[2])) {
                    if (data.length < 4)
                        continue;
                    found = true;
                    System.out.printf(
                            "%-8s %-25s %-15s%n",
                            count,
                            data[1],
                            data[3]);
                    count++;
                }
            }
            if (!found) {
                System.out.println("No Customer booked this show yet !");
                return;
            }
            return;
        } catch (Exception e) {
            System.out.println("Error opening Booking data! Please try after sometime.");
            return;
        }
    }

    public static boolean seatsCount(int showId, int seats) {
        try (BufferedReader br = new BufferedReader(new FileReader("shows.txt"))) {
            String line;
            int availableSeats = 0;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (showId == Integer.parseInt(data[0])) {
                    availableSeats = Integer.parseInt(data[5]);
                    if (availableSeats >= seats) {
                        found = true;
                        return true;
                    }
                }
            }
            if (!found) {
                System.out.println("Sorry ! Sufficient seats not available.");
                System.out.println("Only " + availableSeats + " are available.");
                return false;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    public static void bookTicket() {
        int showId;
        while (true) {
            System.out.print("Enter the SHOW ID : ");
            showId = sc.nextInt();
            if (showId < 0) {
                System.out.println("Invalid Show Id ! Please enter a valid Id.");
                continue;
            }
            if (!showExists(showId)) {
                System.out.println("This show does not exists.");
                return;
            } else {
                break;
            }
        }
        String mobNo;
        while (true) {
            System.out.print("Enter CONTACT NUMBER : ");
            mobNo = sc.next();
            if (!mobNo.matches("\\d{10}")) {
                System.out.println("Invalid Number! Contact number must contain exactly 10 digits.");
                continue;
            }
            break;
        }
        sc.nextLine();
        System.out.print("Enter NAME : ");
        String name = sc.nextLine();
        int seats;
        while (true) {
            System.out.print("Enter Number of Seats you want to book : ");
            seats = sc.nextInt();
            if (seats <= 0) {
                System.out.println("Invalid seats ! Please Enter a valid number of seats.");
                continue;
            }
            if (seatsCount(showId, seats)) {
                break;
            }
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("bookings.txt", true))) {
            bw.write(mobNo + "|" + name + "|" + showId + "|" + seats);
            bw.newLine();
            seatCountUpdate(showId, seats);
            System.out.println("Booking successful ! Enjoy your show.");
            return;
        } catch (Exception e) {
            System.out.println("Booking not Completed ! Please try after sometime.");
            return;
        }
    }

    public static void checkBookings() {
        String mobNo;
        while (true) {
            System.out.print("Enter your Contact Number : ");
            mobNo = sc.next();
            if (!mobNo.matches("\\d{10}")) {
                System.out.println("Invalid Contact Number!");
                continue;
            }
            break;
        }
        header("YOUR BOOKINGS");
        System.out.printf(
                "%-8s %-15s %-25s %-10s%n",
                "Sr No.",
                "Show ID",
                "Show Name",
                "Seats");
        System.out.println("--------------------------------------------------------------");
        try (BufferedReader br = new BufferedReader(new FileReader("bookings.txt"))) {
            String line;
            int count = 1;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length < 4)
                    continue;
                if (mobNo.equals(data[0])) {
                    found = true;
                    int showId = Integer.parseInt(data[2]);
                    System.out.printf(
                            "%-8d %-15s %-25s %-10s%n",
                            count,
                            data[2],
                            showName(showId),
                            data[3]);
                    count++;
                }
            }
            if (!found) {
                System.out.println("No bookings found.");
            } else {
                System.out.println("--------------------------------------------------------------");
                System.out.println("Total Bookings : " + (count - 1));
                System.out.println("--------------------------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println("Error reading booking records.");
        }
    }

    public static void adminPanel() {
        while (true) {
            header("ADMIN PANEL");
            System.out.println("[1] Add Show");
            System.out.println("[2] Delete Show");
            System.out.println("[3] View Shows");
            System.out.println("[4] View Customers");
            System.out.println("[5] Revenue Report.");
            System.out.println("[6] Exit.");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    showsAdder();
                    break;
                case 2:
                    showDelete();
                    break;
                case 3:
                    showsPrint();
                    break;
                case 4:
                    customerList();
                    break;
                case 5:
                    revenueReport();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    public static void printTicket() {
        String mobNo;
        while (true) {
            System.out.print("Enter Contact Number : ");
            mobNo = sc.next();
            if (!mobNo.matches("\\d{10}")) {
                System.out.println("Invalid Contact Number!");
                continue;
            }
            break;
        }
        ArrayList<Integer> bookedShows = new ArrayList<>();
        header("YOUR BOOKINGS");
        try (BufferedReader br = new BufferedReader(
                new FileReader("bookings.txt"))) {
            String line;
            int count = 1;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length < 4)
                    continue;
                if (mobNo.equals(data[0])) {
                    found = true;
                    int showId = Integer.parseInt(data[2]);
                    if (!bookedShows.contains(showId)) {
                        bookedShows.add(showId);
                        System.out.printf(
                                "%-5d %-25s (Show ID : %d)%n",
                                count,
                                showName(showId),
                                showId);
                        count++;
                    }
                }
            }
            if (!found) {
                System.out.println("No bookings found.");
                return;
            }
        } catch (Exception e) {
            System.out.println("Error reading booking records.");
            return;
        }
        System.out.println("--------------------------------------");
        int selectedShowId;
        while (true) {
            System.out.print("Enter Show ID to print ticket : ");
            selectedShowId = sc.nextInt();
            if (bookedShows.contains(selectedShowId)) {
                break;
            }
            System.out.println(
                    "You have not booked this show. Please enter a valid Show ID.");
        }
        printTicketDetails(mobNo, selectedShowId);
    }

    public static void printTicketDetails(String mobNo, int showId) {
        try (BufferedReader br = new BufferedReader(
                new FileReader("bookings.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] bookingData = line.split("\\|");
                if (bookingData.length < 4)
                    continue;
                if (mobNo.equals(bookingData[0])
                        && showId == Integer.parseInt(bookingData[2])) {
                    try (BufferedReader br1 = new BufferedReader(
                            new FileReader("shows.txt"))) {
                        String showLine;
                        while ((showLine = br1.readLine()) != null) {
                            String[] showData = showLine.split("\\|");
                            if (showId == Integer.parseInt(showData[0])) {
                                int totalAmount = Integer.parseInt(showData[4])
                                        * Integer.parseInt(bookingData[3]);

                                header("TICKET");
                                System.out.println(
                                        "Customer Name : " + bookingData[1]);
                                System.out.println(
                                        "Mobile Number : " + bookingData[0]);
                                System.out.println(
                                        "------------------------------------------------");
                                System.out.println(
                                        "Show ID       : " + showData[0]);
                                System.out.println(
                                        "Show Name     : " + showData[1]);
                                System.out.println(
                                        "Date          : " + showData[2]);
                                System.out.println(
                                        "Time          : " + showData[3]);
                                System.out.println(
                                        "------------------------------------------------");
                                System.out.println(
                                        "Seats Booked  : " + bookingData[3]);
                                System.out.println(
                                        "Ticket Price  : Rs. " + showData[4]);
                                System.out.println(
                                        "Total Amount  : Rs. " + totalAmount);
                                System.out.println(
                                        "================================================");
                                return;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(
                                "Unable to fetch show details.");
                        return;
                    }
                }
            }
            System.out.println("Booking not found.");
        } catch (Exception e) {
            System.out.println("Error reading booking data.");
        }
    }

    public static void revenueReport() {
        header("REVENUE REPORT");
        int totalRevenue = 0;
        try (BufferedReader br = new BufferedReader(
                new FileReader("shows.txt"))) {
            String showLine;
            System.out.printf(
                    "%-10s %-25s %-15s %-15s%n",
                    "Show ID",
                    "Show Name",
                    "Tickets Sold",
                    "Revenue");
            System.out.println(
                    "-------------------------------------------------------------");
            while ((showLine = br.readLine()) != null) {
                String[] showData = showLine.split("\\|");
                int showId = Integer.parseInt(showData[0]);
                String showName = showData[1];
                int ticketPrice = Integer.parseInt(showData[4]);
                int ticketsSold = 0;
                try (BufferedReader br1 = new BufferedReader(
                        new FileReader("bookings.txt"))) {

                    String bookingLine;

                    while ((bookingLine = br1.readLine()) != null) {
                        String[] bookingData = bookingLine.split("\\|");
                        if (showId == Integer.parseInt(bookingData[2])) {
                            ticketsSold += Integer.parseInt(bookingData[3]);
                        }
                    }
                }
                int revenue = ticketsSold * ticketPrice;
                totalRevenue += revenue;
                System.out.printf(
                        "%-10d %-25s %-15d Rs. %-10d%n",
                        showId,
                        showName,
                        ticketsSold,
                        revenue);
            }
            System.out.println(
                    "-------------------------------------------------------------");
            System.out.println(
                    "TOTAL REVENUE : Rs. " + totalRevenue);
        } catch (Exception e) {
            System.out.println(
                    "Error generating revenue report.");
        }
    }

    public static void programExit() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Successfully Exited.");
        System.out.println("~ Developed by RAHUL GUPTA.");
        System.exit(0);
    }
}
