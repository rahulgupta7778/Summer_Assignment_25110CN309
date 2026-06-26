// Write a program to Create ATM simulation.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Question_103 {
    public static Scanner sc = new Scanner(System.in);
    public static int attempts = 0;

    public static void main(String[] args) {
        header("ABC BANK");
        programStarter();
    }

    public static void header(String str) {
        System.out.println("============================================================");
        System.out.println("                        " + str);
        System.out.println("============================================================");

    }

    public static void programStarter() {
        while (attempts < 3) {
            System.out.print("Enter your ACCOUNT NUMBER : ");
            int accNo = sc.nextInt();
            if (accNo == 198237645) { // Secret Admin ID
                adminLogin();
                return;
            }
            System.out.print("Enter your PIN : ");
            int pin = sc.nextInt();
            if (loginChecker(accNo, pin)) {
                postUserLogin(accNo);
                break;
            } else {
                continue;
            }
        }
    }

    public static void adminLogin() {
        while (true) {
            System.out.print("Enter your ID : ");
            int adminid = sc.nextInt();
            System.out.print("Enter your PASSWORD : ");
            int pass = sc.nextInt();
            if (adminLoginChecker(adminid, pass)) {
                postAdminLogin(adminid);
                break;
            } else {
                continue;
            }
        }
    }

    public static boolean adminLoginChecker(int adminId, int pass) {
        try (BufferedReader br = new BufferedReader(new FileReader("adminLoginInfo.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                int fileId = Integer.parseInt(data[0]);
                int filePass = Integer.parseInt(data[1]);
                if (fileId == adminId && filePass == pass) {
                    System.out.println("Login Successfull !");
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Server Error ! Please try after sometime.");
            return false;
        }
        return false;
    }

    public static boolean loginChecker(int accNo, int pin) {
        ArrayList<String> records = new ArrayList<>();
        boolean accountFound = false;
        try (BufferedReader br = new BufferedReader(new FileReader("userInfo.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                int fileAccNo = Integer.parseInt(data[0]);
                int filePin = Integer.parseInt(data[1]);
                String fileStatus = data[3];
                if (fileAccNo == accNo) {
                    accountFound = true;
                    if (fileStatus.equals("LOCKED")) {
                        System.out.println("Your account is LOCKED! Please contact the bank.");
                        programExit();
                    }
                    if (filePin == pin) {
                        attempts = 0;
                        System.out.println("Successfully LOGGED IN.");
                        return true;
                    }
                    attempts++;
                    System.out.println("Failed Login! Wrong PIN entered.");
                    System.out.println("Attempts Remaining: " + (3 - attempts));
                    if (attempts >= 3) {
                        String updatedRecord = fileAccNo + "|" +
                                filePin + "|" +
                                data[2] + "|" +
                                "LOCKED";
                        records.add(updatedRecord);
                        while ((line = br.readLine()) != null) {
                            records.add(line);
                        }
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter("userInfo.txt"))) {
                            for (String record : records) {
                                bw.write(record);
                                bw.newLine();
                            }
                        }
                        System.out.println(
                                "Account Locked! You have reached the maximum login attempts.");
                        programExit();
                    }

                    return false;
                }
                records.add(line);
            }
            if (!accountFound) {
                System.out.println("Sorry! No account found with this account number.");
            }
        } catch (IOException e) {
            System.out.println("Server Error occurred! Please try again later.");
        }
        return false;
    }

    public static void postUserLogin(int accNo) {
        while (true) {
            System.out.println();
            System.out.println("\n-------------------------------------------------------------------");
            System.out.println("[1] Debit Money");
            System.out.println("[2] Check Balance");
            System.out.println("[3] Get Transaction Receipt");
            System.out.println("[4] Exit");
            System.out.print("Enter your Choice : ");
            int choice = sc.nextInt();
            if (choice == 1) {
                debitMoney(accNo);
            } else if (choice == 2) {
                checkBalance(accNo);
            } else if (choice == 3) {
                receiptGenerator(accNo);
            } else if (choice == 4) {
                programExit();
                return;
            } else {
                System.out.println("Invalid Input ! Please re - enter your choice.");
                continue;
            }
        }
    }

    public static void debitMoney(int accNo) {
        int debitAmount;
        while (true) {
            System.out.print("Enter debit amount : ");
            debitAmount = sc.nextInt();
            if (debitAmount > 0) {
                break;
            }
            System.out.println("Invalid Amount!");
            System.out.println("Please enter a valid withdrawal amount.");
        }
        try (BufferedReader br = new BufferedReader(new FileReader("atmTotalMoney.txt"))) {
            String line = br.readLine();
            int atmAmount = Integer.parseInt(line);
            if (atmAmount < debitAmount) {
                System.out.println();
                System.out.println("\n-------------------------------------------------------------------");
                System.out.println("Transaction Failed!");
                System.out.println("The ATM currently does not have sufficient cash.");
                System.out.println("Please try a smaller amount or visit another ATM.");
                return;
            }
            try (BufferedReader br2 = new BufferedReader(new FileReader("userInfo.txt"))) {
                ArrayList<String> records = new ArrayList<>();
                String line2;
                int updatedBalance = 0;
                while ((line2 = br2.readLine()) != null) {
                    String[] data = line2.split("\\|");
                    int fileAccNo = Integer.parseInt(data[0]);
                    int filepin = Integer.parseInt(data[1]);
                    int fileBalance = Integer.parseInt(data[2]);
                    if (fileAccNo == accNo) {
                        if (debitAmount >= fileBalance) {
                            System.out.println();
                            System.out.println("\n-------------------------------------------------------------------");
                            System.out.println("Transaction Declined!");
                            System.out.println("Insufficient funds available in your account.");
                            System.out.println("Please enter a smaller amount.");
                            return;
                        }
                        fileBalance -= debitAmount;
                        updatedBalance = fileBalance;
                        String newRecord = (accNo + "|" + filepin + "|" + fileBalance + "|" + "ACTIVE");
                        records.add(newRecord);
                    } else {
                        records.add(line2);
                    }
                }
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("userInfo.txt"))) {
                    for (String record : records) {
                        bw.write(record);
                        bw.newLine();
                    }
                    try (BufferedWriter bw2 = new BufferedWriter(new FileWriter("atmTotalMoney.txt"))) {
                        bw2.write(String.valueOf(atmAmount - debitAmount));
                    } catch (Exception e) {
                        System.out.println("Transaction Warning!");
                        System.out.println("Unable to update ATM cash records.");
                        System.out.println("Please contact system administrator.");
                    }
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactionHistory.txt", true))) {

                        LocalDateTime now = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                        String dateTime = now.format(formatter);

                        writer.write(accNo + "|DEBIT|" + debitAmount + "|" + updatedBalance + "|" + dateTime);
                        writer.newLine();
                        System.out.println("\n-------------------------------------------------------------------");
                        System.out.println("Transaction Successful.");
                        System.out.println("Debited Amount : Rs. " + debitAmount);
                        System.out.println("Available Balance : Rs. " + updatedBalance);
                        System.out.println("Date and Time : " + dateTime);
                        System.out.println("Thank you for banking with us.");
                        System.out.println("\n-------------------------------------------------------------------");
                    } catch (Exception e) {
                        System.out.println("Transaction Completed.");
                        System.out.println("However, transaction history could not be recorded.");
                    }
                } catch (Exception e) {
                    System.out.println("Transaction Failed!");
                    System.out.println("An error occurred while updating account records.");
                    System.out.println("Please verify your balance before retrying.");
                    programExit();
                }
            } catch (Exception e) {
                System.out.println("Bank Server Error.");
                System.out.println("Unable to access account information.");
                System.out.println("Please try again after some time.");
                programExit();
            }
        } catch (Exception e) {
            System.out.println("ATM Service Unavailable.");
            System.out.println("Unable to access ATM cash records.");
            System.out.println("Please try again later.");
            programExit();
        }
    }

    public static void checkBalance(int accNo) {
        try (BufferedReader br = new BufferedReader(new FileReader("userInfo.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                int fileAccNo = Integer.parseInt(data[0]);
                int fileBalance = Integer.parseInt(data[2]);

                if (fileAccNo == accNo) {
                    String currentTime = LocalDateTime.now()
                            .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
                    System.out.println("\n-------------------------------------------------------------------");
                    System.out.println("Account Number : " + accNo);
                    System.out.println("Available Balance : Rs. " + fileBalance);
                    System.out.println("Balance Inquiry Time : " + currentTime);
                    System.out.println("\n-------------------------------------------------------------------");
                    return;
                }
            }

        } catch (Exception e) {
            System.out.println("Bank Server Error.");
            System.out.println("Unable to retrieve account balance.");
            System.out.println("Please try again later.");
            return;
        }
    }

    public static void receiptGenerator(int accNo) {
        try (BufferedReader br = new BufferedReader(new FileReader("transactionHistory.txt"))) {
            boolean found = false;
            String line;
            System.out.println("===================================================================");
            System.out.println("                             ABC BANK");
            System.out.println("               Greater Noida | Knowledge Park - 2");
            System.out.println("===================================================================");
            System.out.printf("         Transaction History (Account Number : %d)", accNo);
            System.out.println("\n-------------------------------------------------------------------");

            System.out.printf("%-12s %-10s %-15s %-20s%n",
                    "Action",
                    "Amount",
                    "Balance",
                    "Date & Time");
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                int fileAccNo = Integer.parseInt(data[0]);

                if (fileAccNo == accNo) {
                    found = true;
                    System.out.println("-------------------------------------------------------------------");
                    System.out.printf("%-12s %-10s %-15s %-25s%n",
                            data[1],
                            data[2],
                            data[3],
                            data[4]);
                }
            }
            if (!found) {
                System.out.println("No transaction data found.");
            }
            System.out.println("-------------------------------------------------------------------");
            System.out.println("                     Thanks for Visiting");
            System.out.println("===================================================================");
            return;
        } catch (Exception e) {
            System.out.println("Server Error ! Please try after sometime.");
            return;
        }
    }

    public static void atmCreditor(int adminId) {
        int credit = 0;
        System.out.println("\n-------------------------------------------------------------------");
        while (true) {
            System.out.print("Enter Credit Amount : ");
            credit = sc.nextInt();
            if (credit > 0) {
                break;
            } else {
                System.out.println("Invalid Amount! Please enter a positive amount.");
                continue;
            }
        }
        try (BufferedReader br = new BufferedReader(new FileReader("atmTotalMoney.txt"))) {
            String line = br.readLine();
            int atmAmount = Integer.parseInt(line);
            atmAmount += credit;
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("atmTotalMoney.txt"))) {
                bw.write(String.valueOf(atmAmount));
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("atmAdminTransaction.txt", true))) {

                    LocalDateTime now = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                    String dateTime = now.format(formatter);

                    writer.write(adminId + "|CREDIT|" + credit + "|" + atmAmount + "|" + dateTime);
                    writer.newLine();
                    System.out.println("\n-------------------------------------------------------------------");
                    System.out.println("ATM Cash Refilled Successfully.");
                    System.out.println("Admin ID            : " + adminId);
                    System.out.println("Credited Amount     : Rs. " + credit);
                    System.out.println("Current ATM Balance : Rs. " + atmAmount);
                    System.out.println("Date and Time       : " + dateTime);
                    System.out.println("-------------------------------------------------------------------");
                    return;
                } catch (Exception e) {
                    System.out.println("Credit Completed.");
                    System.out.println("However, transaction history could not be recorded.");
                }
                return;
            } catch (Exception e) {
                System.out.println("Credit Failed!");
                System.out.println("Unable to update ATM balance records.");
                System.out.println("Please try again later.");
                return;
            }
        } catch (Exception e) {
            System.out.println("ATM Service Unavailable.");
            System.out.println("Unable to access ATM records.");
            System.out.println("Please try again later.");
            return;
        }
    }

    public static void userStatusEditor() {
        System.out.println("------------------------------------------------------------");
        int accNo;
        while (true) {
            System.out.print("Enter User's Account Number : ");
            accNo = sc.nextInt();
            if (accNo <= 0) {
                System.out.println("Invalid Account Number! Please enter a valid Account Number.");
            } else {
                break;
            }
        }
        ArrayList<String> records = new ArrayList<>();
        boolean accountFound = false;
        try (BufferedReader br = new BufferedReader(new FileReader("userInfo.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                int fileAccNo = Integer.parseInt(data[0]);
                if (fileAccNo == accNo) {
                    accountFound = true;
                    if (data[3].equals("ACTIVE")) {
                        System.out.println("This account is already ACTIVE.");
                        return;
                    }
                    String newRecord = data[0] + "|" +
                            data[1] + "|" +
                            data[2] + "|" +
                            "ACTIVE";
                    records.add(newRecord);
                } else {
                    records.add(line);
                }
            }

        } catch (Exception e) {
            System.out.println("Unable to access user records.");
            System.out.println("Please try again later.");
            return;
        }
        if (!accountFound) {
            System.out.println("No account found with Account Number : " + accNo);
            return;
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("userInfo.txt"))) {
            for (String record : records) {
                bw.write(record);
                bw.newLine();
            }
            System.out.println("------------------------------------------------------------");
            System.out.println("Account Status Updated Successfully.");
            System.out.println("Account Number : " + accNo);
            System.out.println("New Status     : ACTIVE");
            System.out.println("------------------------------------------------------------");
            return;

        } catch (Exception e) {
            System.out.println("Failed to update account status.");
            System.out.println("Please try again later.");
            return;
        }
    }

    public static void checkAtmBalance() {
        try (BufferedReader br = new BufferedReader(new FileReader("atmTotalMoney.txt"))) {
            String line = br.readLine();

            String currentTime = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
            System.out.println("\n-------------------------------------------------------------------");
            System.out.println("Available ATM Balance : Rs. " + line);
            System.out.println("Balance Inquiry Time : " + currentTime);
            System.out.println("\n-------------------------------------------------------------------");
            return;

        } catch (Exception e) {
            System.out.println("Bank Server Error.");
            System.out.println("Unable to retrieve ATM balance.");
            System.out.println("Please try again later.");
            return;
        }
    }

    public static void atmTransactionChecker() {
        try (BufferedReader br = new BufferedReader(new FileReader("atmAdminTransaction.txt"))) {
            String line;
            boolean found = false;
            System.out.println("===================================================================");
            System.out.println("                             ABC BANK");
            System.out.println("               Greater Noida | Knowledge Park - 2");
            System.out.println("===================================================================");
            System.out.println("                      ATM Transaction History");
            System.out.println("-------------------------------------------------------------------");
            System.out.printf("%-12s %-12s %-12s %-15s %-20s%n",
                    "Admin ID",
                    "Action",
                    "Amount",
                    "ATM Balance",
                    "Date & Time");
            while ((line = br.readLine()) != null) {
                found = true;
                String[] data = line.split("\\|");
                System.out.println("-------------------------------------------------------------------");
                System.out.printf("%-12s %-12s %-12s %-15s %-20s%n",
                        data[0],
                        data[1],
                        data[2],
                        data[3],
                        data[4]);
            }
            if (!found) {
                System.out.println("No ATM transaction records found.");
            }
            System.out.println("===================================================================");

        } catch (Exception e) {
            System.out.println("Server Error!");
            System.out.println("Unable to retrieve ATM transaction records.");
            System.out.println("Please try again later.");
        }
    }

    public static void postAdminLogin(int adminId) {
        while (true) {
            System.out.println();
            System.out.println("\n-------------------------------------------------------------------");
            System.out.println("[1] Refill ATM");
            System.out.println("[2] Check Balance");
            System.out.println("[3] Change Customer Status");
            System.out.println("[4] Check ATM Transaction History");
            System.out.println("[5] Exit");
            System.out.print("Enter your Choice : ");
            int choice = sc.nextInt();
            if (choice == 1) {
                atmCreditor(adminId);
            } else if (choice == 2) {
                checkAtmBalance();
            } else if (choice == 3) {
                userStatusEditor();
            } else if (choice == 4) {
                atmTransactionChecker();
            } else if (choice == 5) {
                programExit();
                return;
            } else {
                System.out.println("Invalid Input ! Please re - enter your choice.");
                continue;
            }
        }
    }

    public static void programExit() {
        System.out.println("------------------------------------------------------------");
        System.out.println("Successfully Exited.");
        System.out.println("~ Developed by RAHUL GUPTA.");
        System.exit(0);
    }
}
