// Write a program to Create menu-driven array operations system.

import java.util.Scanner;

public class Question_114 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("======= Window for ARRAYS operations =======");
        inputWindow();
    }

    public static void header(String title) {
        System.out.println();
        System.out.println("=====================================================");
        System.out.println("                 " + title);
        System.out.println("=====================================================");
    }

    public static void inputWindow() {
        int[] arr;
        int n;

        while (true) {
            System.out.print("Enter the number of elements in array : ");
            n = sc.nextInt();

            if (n > 0) {
                break;
            }

            System.out.println("Array size must be greater than 0.");
        }
        arr = new int[n];
        System.out.println("Enter the elements of the array.");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + " : ");
            arr[i] = sc.nextInt();
        }
        System.out.print("The array created is : ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("----------------------------------------------------");
        choiceTaker(arr);
    }

    public static void choiceTaker(int[] arr) {
        while (true) {
            System.out.println("[1] Search an element");
            System.out.println("[2] Sort the array.");
            System.out.println("[3] Find frequency of an element.");
            System.out.println("[4] Find maximum and minimum element.");
            System.out.println("[5] Find average.");
            System.out.println("[6] Remove Duplicates.");
            System.out.println("[7] Exit");
            System.out.println("----------------------------------------------------");
            System.out.print("Choose your operation now : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    search(arr);
                    break;
                case 2:
                    sort(arr);
                    break;
                case 3:
                    frequencyFinder(arr);
                    break;
                case 4:
                    maxAndMin(arr);
                    break;
                case 5:
                    average(arr);
                    break;
                case 6:
                    removeDuplicates(arr);
                    break;
                case 7:
                    System.out.println("\n~Successfully Exited.");
                    System.exit(0);
                default:
                    System.out.println("INVALID Input! Please enter a valid choice.");
                    continue;
            }
        }
    }

    public static int[] sortArray(int[] arr) {
        int[] array = arr.clone();
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static void sort(int[] arr) {
        header("SORT ARRAY");
        int[] array = arr.clone();
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.print("The sorted array is : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        endChoice();
    }

    public static void search(int[] arr) {
        header("SEARCH ELEMENT");
        System.out.print("Enter the element to be searched : ");
        int search = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == search) {
                System.out.println("Element found at position : " + (i + 1));
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Element not found.");
        }

        endChoice();
    }

    public static void frequencyFinder(int[] arr) {
        header("FREQUENCY FINDER");
        System.out.print("Enter the element for checking the frequency : ");
        int search = sc.nextInt();
        int n = arr.length;
        int freq = 0;
        for (int i = 0; i < n; i++) {
            if (search == arr[i]) {
                freq++;
            }
        }
        if (freq == 0) {
            System.out.println("Element not found.");
        } else {
            System.out.println("Frequency of element " + search + " is : " + freq);
        }
        endChoice();
    }

    public static void maxAndMin(int[] arr) {
        header("FIND MAXIMUM AND MINIMUM ELEMENT");
        int greatest = arr[0], smallest = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (smallest > arr[i]) {
                smallest = arr[i];
            }
            if (greatest < arr[i]) {
                greatest = arr[i];
            }
        }
        System.out.println("The greatest element : " + greatest);
        System.out.println("The smallest element : " + smallest);
        endChoice();
    }

    public static void removeDuplicates(int[] arr) {
        header("DUPLICATE REMOVER");
        int[] array = sortArray(arr);
        int n = array.length;
        if (n == 0 || n == 1) {
            System.out.println("The array after removing duplicates is the same.");
            return;
        }

        int uniqueIndex = 0;

        for (int i = 1; i < n; i++) {
            if (array[i] != array[uniqueIndex]) {
                uniqueIndex++;
                array[uniqueIndex] = array[i];
            }
        }

        System.out.print("The array after removing duplicates is : ");
        for (int i = 0; i <= uniqueIndex; i++) {
            System.out.print(array[i] + " ");
        }
        endChoice();
    }

    public static void average(int[] arr) {
        header("FIND AVERAGE");
        double sum = 0;
        for (int i : arr) {
            sum += i;
        }
        double avg = (sum / arr.length);
        System.out.println("Average : " + avg);
        endChoice();
    }

    public static void endChoice() {
        System.out.println();
        System.out.println("=====================================================");
        System.out.println("What do you want next ? ");
        System.out.println("[1] Perform another operation (IN SAME ARRAY).");
        System.out.println("[2] Perform operation (IN DIFFERENT ARRAY).");
        System.out.println("[3] Exit.");
        System.out.print("Enter your choice : ");
        while (true) {
            int choice = sc.nextInt();

            if (choice == 1) {
                return;
            } else if (choice == 2) {
                inputWindow();
                return;
            } else if (choice == 3) {
                System.exit(0);
            } else {
                System.out.println("Invalid Choice!");
            }
        }
    }
}
