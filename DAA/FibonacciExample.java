import java.util.Scanner;

public class FibonacciExample {

    // Recursive Fibonacci
    public static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n; // base case
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Non-Recursive (Iterative) Fibonacci
    public static int fibonacciIterative(int n) {
        if (n <= 1)
            return n;

        int prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n (for nth Fibonacci number): ");
        int n = sc.nextInt();

        // Recursive call
        long startRec = System.nanoTime();
        int recResult = fibonacciRecursive(n);
        long endRec = System.nanoTime();

        // Iterative call
        long startItr = System.nanoTime();
        int itrResult = fibonacciIterative(n);
        long endItr = System.nanoTime();

        System.out.println("\nRecursive Fibonacci of " + n + " = " + recResult);
        System.out.println("Time (recursive): " + (endRec - startRec) + " ns");

        System.out.println("\nIterative Fibonacci of " + n + " = " + itrResult);
        System.out.println("Time (iterative): " + (endItr - startItr) + " ns");

        sc.close();
    }
}
