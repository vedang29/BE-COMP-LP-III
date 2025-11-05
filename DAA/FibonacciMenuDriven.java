// PROGRAM - 1
// Fibonacci with Step Count (Recursive vs Iterative)
// Added Step-count as mentioned in the problem statement

import java.util.Scanner;

public class FibonacciMenuDriven {

    // ----------- STEP COUNTERS -----------
    static int recursiveSteps = 0;
    static int iterativeSteps = 0;

    // ----------- RECURSIVE METHOD -----------
    // Time: O(2^n) | Space: O(n)
    public static int fibRecursive(int n) {
        recursiveSteps++; // Count each recursive call
        if (n <= 1)
            return n;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public static void printRecursiveSeries(int n) {
        System.out.print("Series (Recursive): ");
        for (int i = 0; i <= n; i++) {
            System.out.print(fibRecursive(i) + " ");
        }
        System.out.println();
    }

    // ----------- ITERATIVE METHOD -----------
    // Time: O(n) | Space: O(1)
    public static int fibIterative(int n) {
        if (n <= 1)
            return n;

        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            iterativeSteps++; // Count each loop iteration
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static void printIterativeSeries(int n) {
        System.out.print("Series (Iterative): ");
        int a = 0, b = 1;
        if (n >= 0)
            System.out.print(a + " ");
        if (n >= 1)
            System.out.print(b + " ");

        for (int i = 2; i <= n; i++) {
            int c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
        System.out.println();
    }

    // ----------- MAIN MENU -----------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, n;

        while (true) {
            System.out.println("\n===== Fibonacci Menu =====");
            System.out.println("1. Recursive Fibonacci");
            System.out.println("2. Iterative Fibonacci");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 3) {
                System.out.println("Exiting program...");
                break;
            }

            System.out.print("Enter n (position of Fibonacci number): ");
            n = sc.nextInt();

            switch (choice) {
                case 1:
                    recursiveSteps = 0; // Reset counter
                    printRecursiveSeries(n);
                    System.out.println("Result (Recursive nth term): " + fibRecursive(n));
                    System.out.println("Recursive Steps: " + recursiveSteps);
                    break;

                case 2:
                    iterativeSteps = 0; // Reset counter
                    printIterativeSeries(n);
                    System.out.println("Result (Iterative nth term): " + fibIterative(n));
                    System.out.println("Iterative Steps: " + iterativeSteps);
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }

        sc.close();
    }
}





// // PROGRAM - 1
// // Convention 1 (Zero-based index, used in the program)
// import java.util.Scanner;

// public class FibonacciMenuDriven {

// // ----------------- RECURSIVE METHOD -----------------
// // Time Complexity: O(2^n) | Space Complexity: O(n)
// public static int fibRecursive(int n) {
// if (n <= 1)
// return n;
// return fibRecursive(n - 1) + fibRecursive(n - 2);
// }

// // Method to print Fibonacci series using recursion
// public static void printRecursiveSeries(int n) {
// System.out.print("Series (Recursive): ");
// for (int i = 0; i <= n; i++) {
// System.out.print(fibRecursive(i) + " ");
// }
// System.out.println();
// }

// // ----------------- ITERATIVE METHOD -----------------
// // Time Complexity: O(n) | Space Complexity: O(1)
// public static int fibIterative(int n) {
// if (n <= 1)
// return n;

// int a = 0, b = 1, c = 0;
// for (int i = 2; i <= n; i++) {
// c = a + b;
// a = b;
// b = c;
// }
// return c;
// }

// // Method to print Fibonacci series using iteration
// public static void printIterativeSeries(int n) {
// System.out.print("Series (Iterative): ");
// int a = 0, b = 1;
// if (n >= 0) System.out.print(a + " ");
// if (n >= 1) System.out.print(b + " ");

// for (int i = 2; i <= n; i++) {
// int c = a + b;
// System.out.print(c + " ");
// a = b;
// b = c;
// }
// System.out.println();
// }

// // ----------------- MAIN (MENU) -----------------
// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// int choice, n;

// while (true) {
// System.out.println("\n===== Fibonacci Menu =====");
// System.out.println("1. Recursive Fibonacci");
// System.out.println("2. Iterative Fibonacci");
// System.out.println("3. Exit");
// System.out.print("Enter your choice: ");
// choice = sc.nextInt();

// if (choice == 3) {
// System.out.println("Exiting program...");
// break;
// }

// System.out.print("Enter n (position of Fibonacci number): ");
// n = sc.nextInt();

// switch (choice) {
// case 1:
// printRecursiveSeries(n);
// System.out.println("Result (Recursive nth term): " + fibRecursive(n));
// break;

// case 2:
// printIterativeSeries(n);
// System.out.println("Result (Iterative nth term): " + fibIterative(n));
// break;

// default:
// System.out.println("Invalid choice! Try again.");
// }
// }

// sc.close();
// }
// }