package com.belajar;

public class Restaurant {
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    public static byte id = 0;

    public Restaurant() {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }

    public Restaurant(String nama, double harga, int stock) {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }

    public void tambahMenuMakanan(String nama, double harga, int stok) {
        this.nama_makanan[id] = nama;
        this.harga_makanan[id] = harga;
        this.stok[id] = stok;
    }

    public void tampilMenuMakanan(){
        for(int i =0; i<=id;i++){
            if(!isOutOfStock(i)){
                System.out.println(i+1 +" "+ nama_makanan[i] +" ["+stok[i]+"]"+"\tRp. "+harga_makanan[i]);
            }
        }
        System.out.println("4. Keluar");
    }
    public void kurangStok(int id, double qty){
        this.stok[id] -= qty;
    }

    public boolean isOutOfStock(int id){
        if(stok[id] <= 0){
            return true;
        }else{
            return false;
        }
    }
    public static void nextId(){
        id++;
    }


    public String[] getNama_makanan() {
        return nama_makanan;
    }

    public void setNama_makanan(String[] nama_makanan) {
        this.nama_makanan = nama_makanan;
    }

    public double[] getHarga_makanan() {
        return harga_makanan;
    }

    public void setHarga_makanan(double[] harga_makanan) {
        this.harga_makanan = harga_makanan;
    }

    public int getStok(int id) {
        return stok[id];
    }

    public void setStok(int[] stok) {
        this.stok = stok;
    }

}
