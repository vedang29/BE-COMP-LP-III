import java.util.*;

public class HuffmanEncoding {
    static class Node {
        char ch;
        int freq;
        Node left, right;
    }

    static Map<Character, String> codes = new HashMap<>();
    static Node root;

    static void buildTree(String text) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.freq));
        for (var e : freq.entrySet()) {
            Node n = new Node();
            n.ch = e.getKey();
            n.freq = e.getValue();
            pq.add(n);
        }

        while (pq.size() > 1) {
            Node l = pq.poll(), r = pq.poll();
            Node p = new Node();
            p.ch = '-';
            p.freq = l.freq + r.freq;
            p.left = l;
            p.right = r;
            pq.add(p);
        }

        root = pq.poll();
        codes.clear();
        genCodes(root, "");
    }

    static void genCodes(Node n, String code) {
        if (n == null)
            return;
        if (n.left == null && n.right == null) {
            codes.put(n.ch, code);
            return;
        }
        genCodes(n.left, code + "0");
        genCodes(n.right, code + "1");
    }

    static String encode(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray())
            sb.append(codes.get(c));
        return sb.toString();
    }

    static String decode(String enc) {
        StringBuilder sb = new StringBuilder();
        Node c = root;
        for (char ch : enc.toCharArray()) {
            c = (ch == '0') ? c.left : c.right;
            if (c.left == null && c.right == null) {
                sb.append(c.ch);
                c = root;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        buildTree(text);
        String enc = encode(text);
        System.out.println("Codes: " + codes);
        System.out.println("Encoded: " + enc);
        System.out.println("Decoded: " + decode(enc));
        sc.close();
    }
}




















// // PROGRAM - 2
// // Note : Characters with same frequency get codes based on their insertion
// order
// import java.util.*;

// public class HuffmanEncoding {

// // Node class inside same file
// static class HuffmanNode {
// char ch;
// int freq;
// HuffmanNode left, right;
// }

// static Map<Character, String> huffmanCodes = new HashMap<>();
// static HuffmanNode root;

// // Build Huffman Tree
// public static void buildHuffmanTree(String text) {
// Map<Character, Integer> freqMap = new HashMap<>();
// for (char ch : text.toCharArray())
// freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);

// PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(Comparator.comparingInt(n
// -> n.freq));

// for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
// HuffmanNode node = new HuffmanNode();
// node.ch = entry.getKey();
// node.freq = entry.getValue();
// pq.add(node);
// }

// while (pq.size() > 1) {
// HuffmanNode left = pq.poll();
// HuffmanNode right = pq.poll();
// HuffmanNode newNode = new HuffmanNode();
// newNode.ch = '-';
// newNode.freq = left.freq + right.freq;
// newNode.left = left;
// newNode.right = right;
// pq.add(newNode);
// }

// root = pq.poll();
// huffmanCodes.clear();
// generateCodes(root, "");
// }

// // Recursive method to generate Huffman Codes
// public static void generateCodes(HuffmanNode node, String code) {
// if (node == null) return;

// if (node.left == null && node.right == null) {
// huffmanCodes.put(node.ch, code);
// return;
// }
// generateCodes(node.left, code + "0");
// generateCodes(node.right, code + "1");
// }

// // Encode text using generated codes
// public static String encode(String text) {
// StringBuilder encoded = new StringBuilder();
// for (char ch : text.toCharArray()) {
// encoded.append(huffmanCodes.get(ch));
// }
// return encoded.toString();
// }

// // Decode encoded string using Huffman tree
// public static String decode(String encodedText) {
// StringBuilder decoded = new StringBuilder();
// HuffmanNode current = root;
// for (int i = 0; i < encodedText.length(); i++) {
// current = (encodedText.charAt(i) == '0') ? current.left : current.right;

// if (current.left == null && current.right == null) {
// decoded.append(current.ch);
// current = root;
// }
// }
// return decoded.toString();
// }

// // ---------------- MENU ----------------
// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// String text = "", encodedText = "";

// while (true) {
// System.out.println("\n===== HUFFMAN ENCODING MENU =====");
// System.out.println("1. Enter Text");
// System.out.println("2. Build Huffman Tree & Show Codes");
// System.out.println("3. Encode Text");
// System.out.println("4. Decode Encoded Text");
// System.out.println("5. Exit");
// System.out.print("Enter your choice: ");
// int choice = sc.nextInt();
// sc.nextLine();

// switch (choice) {
// case 1:
// System.out.print("Enter text: ");
// text = sc.nextLine();
// break;

// case 2:
// if (text.isEmpty()) {
// System.out.println("No text found! Enter text first.");
// break;
// }
// buildHuffmanTree(text);
// System.out.println("Huffman Codes: " + huffmanCodes);
// break;

// case 3:
// if (huffmanCodes.isEmpty()) {
// System.out.println("Build Huffman tree first.");
// break;
// }
// encodedText = encode(text);
// System.out.println("Encoded Text: " + encodedText);
// break;

// case 4:
// if (encodedText.isEmpty()) {
// System.out.println("No encoded text found! Encode first.");
// break;
// }
// System.out.println("Decoded Text: " + decode(encodedText));
// break;

// case 5:
// System.out.println("Exiting program...");
// sc.close();
// return;

// default:
// System.out.println("Invalid choice! Try again.");
// }
// }
// }
// }