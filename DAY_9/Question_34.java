// Write a program to Print reverse number triangle.
// 12345
// 1234
// 123
// 12
// 1

public class Question_34 {
     public static void main(String[] args) {
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+" ");
            }
            System.err.println();
        }
    }
}
