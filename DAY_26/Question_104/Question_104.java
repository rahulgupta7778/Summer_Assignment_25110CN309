// Write a program to Create quiz application.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Question_104 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("======================================================");
        System.out.println("                   QUIZ APPLICATION                   ");
        System.out.println("======================================================");
        userSide();
        return;
    }

    public static void postAdminLogin() {
        while (true) {
            System.out.println("------------------------------------------------------");
            System.out.println("Total Questions : " + questionCount());
            System.out.println("[1] Add Questions.");
            System.out.println("[2] Delete a Question.");
            System.out.println("[3] Exit.");
            System.out.print("Enter your Choice : ");
            int choice = sc.nextInt();
            if (choice == 1) {
                int id = questionIdInput();
                addQuestion(id);
            } else if (choice == 2) {
                if (questionCount() <= 20) {
                    System.out.println("Sorry! Deletion not allowed.");
                    System.out.println("Minimum 20 questions must remain in the system.");
                } else {
                    int id = questionIdInputDelete();
                    deleteQuestion(id);
                }
            } else if (choice == 3) {
                System.out.println("Exiting Admin Panel...");
                programExit();
            } else {
                System.out.println("Invalid Input! Please re-enter your choice.");
            }
        }
    }

    public static int questionCount() {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("questions.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length >= 7) {
                    count++;
                }
            }
        } catch (Exception e) {
            System.out.println("Unable to count questions.");
        }
        return count;
    }

    public static int questionIdInput() {
        int id;
        while (true) {
            System.out.print("Enter question ID: ");
            id = sc.nextInt();
            if (id < 400) {
                System.out.println("Invalid Question Id! Must be >= 400.");
                continue;
            }
            if (isQuestionIdExists(id)) {
                System.out.println("This question ID already exists. Try another.");
                continue;
            }
            return id;
        }
    }

    public static int questionIdInputDelete() {
        int id;
        while (true) {
            System.out.print("Enter question ID: ");
            id = sc.nextInt();
            if (id < 400) {
                System.out.println("Invalid Question Id! Must be >= 400.");
                continue;
            }
            if (!isQuestionIdExists(id)) {
                System.out.println("Question ID does not exist. Try again.");
                continue;
            }
            return id;
        }
    }

    public static boolean isQuestionIdExists(int id) {
        try (BufferedReader br = new BufferedReader(new FileReader("questions.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                try {
                    if (data.length > 0 && Integer.parseInt(data[0]) == id) {
                        return true;
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR! Please try after sometime.");
        }
        return false;
    }

    public static void addQuestion(int id) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("questions.txt", true))) {
            sc.nextLine();
            System.out.print("Enter question: ");
            String question = sc.nextLine();
            System.out.print("Enter option 1: ");
            String a = sc.nextLine();
            System.out.print("Enter option 2: ");
            String b = sc.nextLine();
            System.out.print("Enter option 3: ");
            String c = sc.nextLine();
            System.out.print("Enter option 4: ");
            String d = sc.nextLine();
            int answer;
            while (true) {
                System.out.print("Enter correct answer (1-4): ");
                try {
                    answer = Integer.parseInt(sc.nextLine());
                    if (answer >= 1 && answer <= 4) {
                        break;
                    }
                    System.out.println("Answer must be between 1 and 4.");

                } catch (Exception e) {
                    System.out.println("Invalid input.");
                }
            }
            String record = id + "|" + question + "|" + a + "|" + b + "|" + c + "|" + d + "|" + answer;
            bw.write(record);
            bw.newLine();
            System.out.println("Question added successfully!");
        } catch (Exception e) {
            System.out.println("Error while saving question!");
        }
    }

    public static void deleteQuestion(int id) {
        ArrayList<String> record = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("questions.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                try {
                    if (data.length > 0 && Integer.parseInt(data[0]) == id) {
                        continue;
                    }
                    record.add(line);
                } catch (Exception e) {
                    record.add(line);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading questions file!");
            return;
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("questions.txt"))) {
            for (String rec : record) {
                bw.write(rec);
                bw.newLine();
            }
            System.out.println("Question deleted successfully!");
        } catch (Exception e) {
            System.out.println("Error updating questions file!");
        }
    }

    public static void userSide() {
        while (true) {
            System.out.println("------------------------------------------------------");
            System.out.println("Want to start Quiz ? ");
            System.out.println("[1] Yes");
            System.out.println("[2] Exit");
            System.out.print("Enter your Choice : ");
            int choice = sc.nextInt();
            if (choice == 1) {
                quizStarter();
            } else if (choice == 2) {
                programExit();
            } else if (choice == 3) {
                System.out.print("Enter your ID : ");
                int accNo = sc.nextInt();
                if (accNo == 192837465) { // Secret Admin ID
                    postAdminLogin();
                    return;
                } else {
                    System.out.println("Access Denied!");
                }
            } else {
                System.out.println("Invalid Input ! Please enter a valid input.");
                continue;
            }
        }
    }

    public static void quizStarter() {
        ArrayList<String> questions = new ArrayList<>();
        int score = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("questions.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    questions.add(line);
                }
            }
        } catch (Exception e) {
            System.out.println("Server Error! Please try after sometime.");
            return;
        }
        if (questions.isEmpty()) {
            System.out.println("No questions available.");
            return;
        }
        if (questions.size() < 20) {
            System.out.println("At least 20 questions are required to start the quiz.");
            return;
        }
        Collections.shuffle(questions);
        int totalQuestions = 20;
        for (int i = 0; i < totalQuestions; i++) {
            String[] data = questions.get(i).split("\\|");
            if (data.length < 7) {
                continue;
            }
            System.out.println("------------------------------------------------------");
            System.out.println("Question " + (i + 1));
            System.out.println(data[1]);
            System.out.println("[1] " + data[2]);
            System.out.println("[2] " + data[3]);
            System.out.println("[3] " + data[4]);
            System.out.println("[4] " + data[5]);
            int ansChoice;
            while (true) {
                System.out.print("Enter your choice : ");
                if (sc.hasNextInt()) {
                    ansChoice = sc.nextInt();
                    if (ansChoice >= 1 && ansChoice <= 4) {
                        break;
                    }
                } else {
                    sc.next();
                }
                System.out.println("Invalid Choice! Please enter 1-4.");
            }
            try {
                int correctOption = Integer.parseInt(data[6]);

                if (ansChoice == correctOption) {
                    score += 10;
                    System.out.println("Correct!");
                } else {
                    System.out.println("Wrong!");
                    System.out.println("Correct Answer : " + data[correctOption + 1]);
                }
            } catch (Exception e) {
                System.out.println("Question data corrupted. Skipping...");
            }
        }
        System.out.println("------------------------------------------------------");
        System.out.println("RESULT");
        System.out.println("Total Score : " + score + "/" + (totalQuestions * 10));
        System.out.println("Correct Answers : " + (score / 10) + "/" + totalQuestions);
        double percentage = (score * 100.0) / (totalQuestions * 10);
        if (percentage >= 60) {
            System.out.println("CONGRATULATIONS! You passed.");
            System.out.printf("Percentage : %.2f%%\n", percentage);
        } else {
            System.out.println("You Failed.");
            System.out.printf("Percentage : %.2f%%\n", percentage);
        }
    }

    public static void programExit() {
        System.out.println();
        System.out.println("Successfully Exited");
        System.out.println("~ Developed By RAHUL GUPTA.");
        System.exit(0);

    }

}