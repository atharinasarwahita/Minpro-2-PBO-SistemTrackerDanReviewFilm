package controller;

import java.util.Scanner;

public class ValidasiInput {
    
    private static Scanner scanner = new Scanner(System.in);

    // Validasi Input Int
    public static int inputAngka(String pesan) {
        System.out.print(pesan);
        while (!scanner.hasNextInt()) {
            System.out.println("Input harus angka!");
            scanner.next();
            System.out.print(pesan);
        }
        int hasil = scanner.nextInt();
        scanner.nextLine();
        return hasil;
    }
    
    public static double inputRating(String pesan) {
    System.out.print(pesan);
    while (!scanner.hasNextDouble()) {
        System.out.println("Input harus berupa angka!");
        scanner.next();
        System.out.print(pesan);
    }
    double hasil = scanner.nextDouble();
    scanner.nextLine();
    return hasil;
    }
    
    //Validasi Input String
    public static String inputTeks(String pesan) {
        System.out.print(pesan);
        String input = scanner.nextLine();
        while (input.isEmpty()) {
            System.out.println("Input tidak boleh kosong!");
            System.out.print(pesan);
            input = scanner.nextLine();
        }
        return input;
    }
    
    //Validasi Input Konfirmasi
    public static boolean inputKonfirmasi(String pesan) {
    while (true) {
        System.out.print(pesan);
        String input = scanner.nextLine().trim();
        if (input.equalsIgnoreCase("Y")) {
            return true;
        } else if (input.equalsIgnoreCase("N")) {
            return false;
        }
        System.out.println("Input tidak valid! Harap masukkan Y atau N.");
        }
    }
}    
