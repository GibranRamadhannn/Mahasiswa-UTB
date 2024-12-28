/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenwisata;

/**
 *
 * @author mgibr
 */
public class WisataBudaya extends PaketWisata implements LayananWisata {
    private String jenisBudaya;
    
    //<!--- Definisi Variabel Wisata Budaya --->
    public WisataBudaya(String nama, String destinasi, double harga, String jenisBudaya) {
        super(nama, destinasi, harga);
        this.jenisBudaya = jenisBudaya;
    }

    //<!--- Override: Menampilkan Daftar Paket --->
    @Override
    public String daftarPaket() {
        return "[Wisata Budaya] " + info() + ", Jenis Budaya: " + jenisBudaya;
    }

    //<!--- Override: Booking Perjalanan --->
    @Override
    public String booking(String namaPaket, int jumlahOrang) {
        double totalHarga = harga * jumlahOrang;
        return "Booking " + namaPaket + " untuk " + jumlahOrang + " orang berhasil. Total harga: " + totalHarga;
    }
    
    //<!--- Override: Hitung Biaya --->
    @Override
    public double hitungBiaya(int jumlahOrang) {
        double diskon = 0;
        if (jumlahOrang > 10) {
            diskon = 0.1;
        }
        return (harga * jumlahOrang) * (1 - diskon);
    }
}
