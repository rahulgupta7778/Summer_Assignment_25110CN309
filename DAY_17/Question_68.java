import java.util.Scanner;

public class Question_68 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr1[], arr2[], arr3[];
        int n1, n2;

        System.out.print("Enter the number of elements in first array : ");
        n1 = sc.nextInt();
        System.out.print("Enter the number of elements in second array : ");
        n2 = sc.nextInt();

        arr1 = new int[n1];
        arr2 = new int[n2];
        arr3 = new int[Math.min(n1, n2)];
        int n3 = 0;

        System.out.println("Enter elements of first array.");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print("Enter element " + (i + 1) + " here : ");
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter elements of second array.");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print("Enter element " + (i + 1) + " here : ");
            arr2[i] = sc.nextInt();
        }

        for (int i = 0; i < n2; i++) {
            boolean foundInFirst = false;

            for (int j = 0; j < n1; j++) {
                if (arr2[i] == arr1[j]) {
                    foundInFirst = true;
                    break;
                }
            }

            if (foundInFirst) {
                boolean alreadyAdded = false;
                for (int k = 0; k < n3; k++) {
                    if (arr2[i] == arr3[k]) {
                        alreadyAdded = true;
                        break;
                    }
                }

                if (!alreadyAdded) {
                    arr3[n3] = arr2[i];
                    n3++;
                }
            }
        }

        System.out.print("The array first created is : ");
        for (int i = 0; i < n1; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();

        System.out.print("The array second created is : ");
        for (int i = 0; i < n2; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();

        System.out.print("The array created common elements of first and second arrays : ");
        for (int i = 0; i < n3; i++) {
            System.out.print(arr3[i] + " ");
        }
        System.out.println();

        sc.close();
    }
}
