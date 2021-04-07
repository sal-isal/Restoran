package com.belajar;

import java.util.Scanner;

public class RestaurantMain {

    public double subTotal;
    public static double runningTotal;
    private static double itemPrice;
    static boolean ordering = true;
    static Scanner input = new Scanner(System.in);
    static Restaurant menu = new Restaurant();

    public static void main(String[] args) {

        menu.tambahMenuMakanan("Bala-Bala", 1_000, 20);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Gehu", 1_000, 20);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Tahu", 1_000, 10);

        int menuOption;
        int foodItem = 0;
        input = new Scanner(System.in);
        do{
            menu.tampilMenuMakanan();
            System.out.print("Pilih Nomor : ");
            menuOption = input.nextInt();
            switch (menuOption) {
                case 1:
                    if (menu.getStok(1-1) <= 0) break;
                    else itemPrice(1); break;
                case 2:
                    if (menu.getStok(2-1) <= 0) break;
                    itemPrice(2);
                    break;
                case 3:
                    if (menu.getStok(3-1) <= 0) break;
                    itemPrice(3);
                    break;
                case 4:
                    System.exit(0);
                break;
                default:
                    System.out.println("Pilihan Salah");
            }
        } while(ordering);

        sub_Total(quantity(foodItem), itemPrice(foodItem));
    }

    public static double itemPrice(int foodItem) {

        if (foodItem == 1) {
            System.out.println("Kamu Memesan Bala Bala");
            itemPrice = 1.000;
        }
        if (foodItem == 2) {
            System.out.println("Kamu Memesan Gehu");
            itemPrice = 1.000;
        }
        if (foodItem == 3) {
            System.out.println("Kamu Memesan Tahu");
            itemPrice = 1.000;
        }
        quantity(foodItem);

        return itemPrice;

    }


    public static double sub_Total(double quantity, double itemPrice) {

        double subTotal = quantity * itemPrice;
        System.out.printf("Total : Rp. %.3f\n", subTotal);
        System.out.println();
        return subTotal;

    }

    public static double quantity(int id) {
        double quantity = 0;
        do {
            System.out.println("Masukan Kuantitas : ");
            quantity = input.nextDouble();

            if (quantity > menu.getStok(id-1)) System.out.println("Stok Tidak Tersedia");
        }while(quantity > menu.getStok(id-1));


        sub_Total(quantity, itemPrice);
        menu.kurangStok(id-1, quantity);
        return quantity;

    }

}
