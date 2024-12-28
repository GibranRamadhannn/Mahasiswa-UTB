/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemenwisata;
import java.util.Date;

/**
 *
 * @author mgibr
 */
public class WisataAlam extends PaketWisata implements LayananWisata {
    private String jenisEkosistem;
    public Perjalanan perjalanan;
    
    //<!--- Definisi Variabel Wisata Alam --->
    public WisataAlam(String nama, String destinasi, double harga, String jenisEkosistem) {
        super(nama, destinasi, harga);
        this.jenisEkosistem = jenisEkosistem;
    }
    
    //<!--- Override: Tampilkan Daftar Paket --->
    @Override
    public String daftarPaket() {
        return "[Wisata Alam] " + info() + ", Ekosistem: " + jenisEkosistem;
    }

    //<!--- Override: Booking Perjalanan --->
    @Override
    public String booking(String namaPaket, int jumlahOrang) {
        perjalanan = new Perjalanan(new Date(), jumlahOrang, "Booked");
        double totalHarga = harga * jumlahOrang;
        return "Booking " + namaPaket + " untuk " + jumlahOrang + " orang berhasil. Total harga: " + totalHarga;
    }
    
    //<!--- Override: Hitung Biaya --->
    @Override
    public double hitungBiaya(int jumlahOrang) {
        double biayaTransportasi = 50000; // Biaya transportasi per orang
        double biayaPemandu = 100000;    // Biaya pemandu wisata
        return (harga * jumlahOrang) + (biayaTransportasi * jumlahOrang) + biayaPemandu;
    }
    
    //<!--- Getter Info Perjalanan --->
    public String getInfoPerjalanan() {
        if (perjalanan != null) {
            return perjalanan.getPerjalanan();
        } else {
            return "Belum ada perjalanan yang dipesan.";
        }
    }
}
