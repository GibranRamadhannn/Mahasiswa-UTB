/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenwisata;

/**
 *
 * @author mgibr
 */
public abstract class PaketWisata {
    protected String nama;
    protected String destinasi;
    protected double harga;
    
    //<!--- Definisi Variabel Paket Wisata --->
    public PaketWisata(String nama, String destinasi, double harga) {
        this.nama = nama;
        this.destinasi = destinasi;
        this.harga = harga;
    }

    //<!--- Tampilkan info Paket Wisata --->
    public String info() {
        return "Paket: " + nama + ", Destinasi: " + destinasi + ", Harga: " + harga;
    }
    
    //<!--- Abstract: Hitung Biaya --->
    public abstract double hitungBiaya(int jumlahOrang);
}
