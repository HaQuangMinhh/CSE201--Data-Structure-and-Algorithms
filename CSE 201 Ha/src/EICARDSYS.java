import java.util.*;
import java.io.*;

 class EICARDSYS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        Map<String, Double> memberTotalPurchase = new HashMap<>();
        double totalDiscount = 0;

        for (int i = 0; i < n; i++) {
            String[] transaction = scanner.nextLine().split(" ");
            String customerId = transaction[0];
            long productPrice = Long.parseLong(transaction[1]);

            if (memberTotalPurchase.containsKey(customerId)) {
                double discount = calculateDiscount(customerId, productPrice, memberTotalPurchase);
                totalDiscount += discount;
            }

            updateMemberTotalPurchase(customerId, productPrice, memberTotalPurchase);
        }

        printDiscount(totalDiscount);
    }

    private static double calculateDiscount(String customerId, long productPrice, Map<String, Double> memberTotalPurchase) {
        double totalPurchaseValue = memberTotalPurchase.get(customerId);
        double discount = 0.0;

        if (totalPurchaseValue < 1000000) {
            discount = 0;
        } else if (totalPurchaseValue < 20000000) {
            discount = productPrice * 0.02;
        } else if (totalPurchaseValue < 50000000) {
            discount = productPrice * 0.03;
        } else if (totalPurchaseValue < 200000000) {
            discount = productPrice * 0.05;
        } else {
            discount = productPrice * 0.07;
        }

        return discount;
    }

    private static void updateMemberTotalPurchase(String customerId, long productPrice, Map<String, Double> memberTotalPurchase) {
        double totalPurchaseValue = memberTotalPurchase.getOrDefault(customerId, 0.0) + productPrice;
        memberTotalPurchase.put(customerId, totalPurchaseValue);
    }

    private static void printDiscount(double totalDiscount) {
        StringBuilder sb = new StringBuilder();
        if (totalDiscount % 1 == 0) {
            sb.append((int) totalDiscount);
        } else {
            sb.append(String.format("%.2f", totalDiscount));
        }
        System.out.println(sb);
    }
}