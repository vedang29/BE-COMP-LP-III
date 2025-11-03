import java.util.*;

public class Knapsack01 {

    // ---------------- DP Method ----------------
    public static int knapsackDP(int[] values, int[] weights, int n, int capacity) {
        int[][] dp = new int[n + 1][capacity + 1];

        // Build table dp[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0; // base case
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity]; // max profit
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
            System.out.println("4. Exit");
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
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}



// // THIS CODE SHOWS DP-TABLE
// import java.util.*;

// public class ZeroOneKnapsack {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int[] values = null;
//         int[] weights = null;
//         int n = 0;
//         int choice;

//         while (true) {
//             System.out.println("\n=== 0-1 Knapsack Menu ===");
//             System.out.println("1. Enter items (values & weights)");
//             System.out.println("2. Solve 0-1 Knapsack");
//             System.out.println("3. Exit");
//             System.out.print("Enter your choice: ");
//             choice = sc.nextInt();

//             switch (choice) {
//                 case 1:
//                     System.out.print("Enter number of items: ");
//                     n = sc.nextInt();
//                     values = new int[n];
//                     weights = new int[n];

//                     for (int i = 0; i < n; i++) {
//                         System.out.print("Item " + (i + 1) + " value: ");
//                         values[i] = sc.nextInt();
//                         System.out.print("Item " + (i + 1) + " weight: ");
//                         weights[i] = sc.nextInt();
//                     }
//                     break;

//                 case 2:
//                     if (values == null || weights == null || n == 0) {
//                         System.out.println("Please enter items first!");
//                         break;
//                     }

//                     System.out.print("Enter knapsack capacity: ");
//                     int capacity = sc.nextInt();

//                     int[][] dp = buildKnapsackDP(values, weights, n, capacity);
//                     System.out.println("\nDP Table:");
//                     printDPTable(dp, n, capacity);

//                     System.out.println("Maximum value that can be put in knapsack: " + dp[n][capacity]);
//                     break;

//                 case 3:
//                     System.out.println("Exiting program. Goodbye!");
//                     sc.close();
//                     return;

//                 default:
//                     System.out.println("Invalid choice!");
//             }
//         }
//     }

//     // Build DP table
//     private static int[][] buildKnapsackDP(int[] val, int[] wt, int n, int W) {
//         int[][] dp = new int[n + 1][W + 1];

//         for (int i = 0; i <= n; i++) {
//             for (int w = 0; w <= W; w++) {
//                 if (i == 0 || w == 0)
//                     dp[i][w] = 0;
//                 else if (wt[i - 1] <= w)
//                     dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
//                 else
//                     dp[i][w] = dp[i - 1][w];
//             }
//         }
//         return dp;
//     }

//     // Print DP table
//     private static void printDPTable(int[][] dp, int n, int W) {
//         System.out.print("   ");
//         for (int w = 0; w <= W; w++)
//             System.out.printf("%4d", w);
//         System.out.println();

//         for (int i = 0; i <= n; i++) {
//             System.out.printf("%2d ", i);
//             for (int w = 0; w <= W; w++)
//                 System.out.printf("%4d", dp[i][w]);
//             System.out.println();
//         }
//     }
// }



// THIS CODE DOESN'T SHOW DP-TABLE
// import java.util.*;

// public class ZeroOneKnapsack {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int[] values = null;
//         int[] weights = null;
//         int n = 0;
//         int choice;

//         while (true) {
//             System.out.println("\n=== 0-1 Knapsack Menu ===");
//             System.out.println("1. Enter items (values & weights)");
//             System.out.println("2. Solve 0-1 Knapsack");
//             System.out.println("3. Exit");
//             System.out.print("Enter your choice: ");
//             choice = sc.nextInt();

//             switch (choice) {
//                 case 1:
//                     System.out.print("Enter number of items: ");
//                     n = sc.nextInt();
//                     values = new int[n];
//                     weights = new int[n];

//                     for (int i = 0; i < n; i++) {
//                         System.out.print("Item " + (i + 1) + " value: ");
//                         values[i] = sc.nextInt();
//                         System.out.print("Item " + (i + 1) + " weight: ");
//                         weights[i] = sc.nextInt();
//                     }
//                     break;

//                 case 2:
//                     if (values == null || weights == null || n == 0) {
//                         System.out.println("Please enter items first!");
//                         break;
//                     }

//                     System.out.print("Enter knapsack capacity: ");
//                     int capacity = sc.nextInt();

//                     int maxValue = knapsackDP(values, weights, n, capacity);
//                     System.out.println("Maximum value that can be put in knapsack: " + maxValue);
//                     break;

//                 case 3:
//                     System.out.println("Exiting program. Goodbye!");
//                     sc.close();
//                     return;

//                 default:
//                     System.out.println("Invalid choice!");
//             }
//         }
//     }

//     // DP solution for 0-1 Knapsack
//     private static int knapsackDP(int[] val, int[] wt, int n, int W) {
//         int[][] dp = new int[n + 1][W + 1];

//         for (int i = 0; i <= n; i++) {
//             for (int w = 0; w <= W; w++) {
//                 if (i == 0 || w == 0)
//                     dp[i][w] = 0;
//                 else if (wt[i - 1] <= w)
//                     dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
//                 else
//                     dp[i][w] = dp[i - 1][w];
//             }
//         }
//         return dp[n][W];
//     }
// }
