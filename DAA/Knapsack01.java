// Same code just added functionality to print DP table

import java.util.*;

public class Knapsack01 {

    // Global DP table to print later
    static int[][] dpTable;

    // ---------------- DP Method ----------------
    public static int knapsackDP(int[] values, int[] weights, int n, int capacity) {
        dpTable = new int[n + 1][capacity + 1];

        // Build table dpTable[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dpTable[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dpTable[i][w] = Math.max(values[i - 1] + dpTable[i - 1][w - weights[i - 1]], dpTable[i - 1][w]);
                } else {
                    dpTable[i][w] = dpTable[i - 1][w];
                }
            }
        }

        return dpTable[n][capacity]; // Final result
    }

    // ---------------- PRINT DP TABLE ----------------
    public static void printDPTable(int n, int capacity) {
        if (dpTable == null) {
            System.out.println("Solve knapsack first (option 3).");
            return;
        }

        System.out.println("\n===== DP TABLE =====");
        System.out.print("W\\I\t");
        for (int i = 0; i <= n; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();

        for (int w = 0; w <= capacity; w++) {
            System.out.print(w + "\t");
            for (int i = 0; i <= n; i++) {
                System.out.print(dpTable[i][w] + "\t");
            }
            System.out.println();
        }
    }

    // ---------------- MENU ----------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0, capacity = 0;
        int[] values = null;
        int[] weights = null;

        while (true) {
            System.out.println("\n===== 0/1 KNAPSACK MENU =====");
            System.out.println("1. Enter number of items & knapsack capacity");
            System.out.println("2. Enter item values and weights");
            System.out.println("3. Solve 0/1 Knapsack");
            System.out.println("4. Display DP Table");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number of items: ");
                    n = sc.nextInt();
                    System.out.print("Enter knapsack capacity: ");
                    capacity = sc.nextInt();
                    values = new int[n];
                    weights = new int[n];
                    break;

                case 2:
                    if (values == null) {
                        System.out.println("Enter number of items first (option 1).");
                        break;
                    }
                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter value of item " + (i + 1) + ": ");
                        values[i] = sc.nextInt();
                        System.out.print("Enter weight of item " + (i + 1) + ": ");
                        weights[i] = sc.nextInt();
                    }
                    break;

                case 3:
                    if (values == null || weights == null) {
                        System.out.println("Enter items first (option 1 & 2).");
                        break;
                    }
                    int maxProfit = knapsackDP(values, weights, n, capacity);
                    System.out.println("Maximum profit = " + maxProfit);
                    break;

                case 4:
                    printDPTable(n, capacity);
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}


// import java.util.*;

// public class Knapsack01 {

//     // ---------------- DP Method ----------------
//     public static int knapsackDP(int[] values, int[] weights, int n, int capacity) {
//         int[][] dp = new int[n + 1][capacity + 1];

//         // Build table dp[][] in bottom-up manner
//         for (int i = 0; i <= n; i++) {
//             for (int w = 0; w <= capacity; w++) {
//                 if (i == 0 || w == 0) {
//                     dp[i][w] = 0; // base case
//                 } else if (weights[i - 1] <= w) {
//                     dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
//                 } else {
//                     dp[i][w] = dp[i - 1][w];
//                 }
//             }
//         }

//         return dp[n][capacity]; // max profit
//     }

//     // ---------------- MENU ----------------
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = 0, capacity = 0;
//         int[] values = null;
//         int[] weights = null;

//         while (true) {
//             System.out.println("\n===== 0/1 KNAPSACK MENU =====");
//             System.out.println("1. Enter number of items & knapsack capacity");
//             System.out.println("2. Enter item values and weights");
//             System.out.println("3. Solve 0/1 Knapsack");
//             System.out.println("4. Exit");
//             System.out.print("Enter your choice: ");
//             int choice = sc.nextInt();

//             switch (choice) {
//                 case 1:
//                     System.out.print("Enter number of items: ");
//                     n = sc.nextInt();
//                     System.out.print("Enter knapsack capacity: ");
//                     capacity = sc.nextInt();
//                     values = new int[n];
//                     weights = new int[n];
//                     break;

//                 case 2:
//                     if (values == null) {
//                         System.out.println("Enter number of items first (option 1).");
//                         break;
//                     }
//                     for (int i = 0; i < n; i++) {
//                         System.out.print("Enter value of item " + (i + 1) + ": ");
//                         values[i] = sc.nextInt();
//                         System.out.print("Enter weight of item " + (i + 1) + ": ");
//                         weights[i] = sc.nextInt();
//                     }
//                     break;

//                 case 3:
//                     if (values == null || weights == null) {
//                         System.out.println("Enter items first (option 1 & 2).");
//                         break;
//                     }
//                     int maxProfit = knapsackDP(values, weights, n, capacity);
//                     System.out.println("Maximum profit = " + maxProfit);
//                     break;

//                 case 4:
//                     System.out.println("Exiting program...");
//                     sc.close();
//                     return;

//                 default:
//                     System.out.println("Invalid choice! Try again.");
//             }
//         }
//     }
// }