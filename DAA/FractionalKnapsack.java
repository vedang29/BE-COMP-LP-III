// PROGRAM - 3
import java.util.*;

public class FractionalKnapsack {
    static class Item {
        int value, weight, index;
        double ratio;

        Item(int v, int w, int i) {
            value = v;
            weight = w;
            index = i;
            ratio = (double) v / w;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of items: ");
        int n = sc.nextInt();
        System.out.print("Knapsack capacity: ");
        int cap = sc.nextInt();

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Value of item " + (i + 1) + ": ");
            int v = sc.nextInt();
            System.out.print("Weight of item " + (i + 1) + ": ");
            int w = sc.nextInt();
            items[i] = new Item(v, w, i);
        }

        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));
        double total = 0;
        int rem = cap;
        System.out.println("\nItems taken:");
        for (Item item : items) {
            if (rem == 0)
                break;
            if (item.weight <= rem) {
                total += item.value;
                rem -= item.weight;
                System.out.println(
                        "Item " + (item.index + 1) + " fully taken (V:" + item.value + ", W:" + item.weight + ")");
            } else {
                double f = (double) rem / item.weight;
                total += item.value * f;
                System.out.println("Item " + (item.index + 1) + " partially taken (" + f + " fraction, V:"
                        + (item.value * f) + ", W:" + rem + ")");
                rem = 0;
            }
        }
        System.out.println("\nMaximum profit = " + total);
        sc.close();
    }
}


































// // PROGRAM - 3
// import java.util.*;

// public class FractionalKnapsack {

// // Item class
// static class Item {
// int value, weight;
// double ratio;

// Item(int value, int weight) {
// this.value = value;
// this.weight = weight;
// this.ratio = (double) value / weight;
// }
// }

// // Method to solve fractional knapsack
// public static double fractionalKnapsack(int capacity, Item[] items) {
// // Sort items by value-to-weight ratio in descending order
// Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

// double totalValue = 0.0;
// int remainingCapacity = capacity;

// for (Item item : items) {
// if (remainingCapacity == 0) break;

// if (item.weight <= remainingCapacity) {
// totalValue += item.value;
// remainingCapacity -= item.weight;
// } else {
// // Take fraction of the item
// totalValue += item.ratio * remainingCapacity;
// remainingCapacity = 0;
// }
// }

// return totalValue;
// }

// // ---------------- MENU ----------------
// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// int n = 0, capacity = 0;
// Item[] items = null;

// while (true) {
// System.out.println("\n===== FRACTIONAL KNAPSACK MENU =====");
// System.out.println("1. Enter number of items & knapsack capacity");
// System.out.println("2. Enter item values and weights");
// System.out.println("3. Solve Fractional Knapsack");
// System.out.println("4. Exit");
// System.out.print("Enter your choice: ");
// int choice = sc.nextInt();

// switch (choice) {
// case 1:
// System.out.print("Enter number of items: ");
// n = sc.nextInt();
// System.out.print("Enter knapsack capacity: ");
// capacity = sc.nextInt();
// items = new Item[n];
// break;

// case 2:
// if (items == null) {
// System.out.println("Enter number of items first (option 1).");
// break;
// }
// for (int i = 0; i < n; i++) {
// System.out.print("Enter value of item " + (i + 1) + ": ");
// int value = sc.nextInt();
// System.out.print("Enter weight of item " + (i + 1) + ": ");
// int weight = sc.nextInt();
// items[i] = new Item(value, weight);
// }
// break;

// case 3:
// if (items == null) {
// System.out.println("Enter items first (option 1 & 2).");
// break;
// }
// double maxProfit = fractionalKnapsack(capacity, items);
// System.out.println("Maximum profit = " + maxProfit);
// break;

// case 4:
// System.out.println("Exiting program...");
// sc.close();
// return;

// default:
// System.out.println("Invalid choice! Try again.");
// }
// }
// }
// }