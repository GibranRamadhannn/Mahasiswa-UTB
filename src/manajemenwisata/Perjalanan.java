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
public class Perjalanan {
    private Date tanggalPerjalanan;
    private int jumlahPeserta;
    private String statusPemesanan;
    
    //<!--- Definisi Variabel Perjalanan --->
    public Perjalanan(Date tanggalPerjalanan, int jumlahPeserta, String statusPemesanan) {
        this.tanggalPerjalanan = tanggalPerjalanan;
        this.jumlahPeserta = jumlahPeserta;
        this.statusPemesanan = statusPemesanan;
    }
    
    //<!--- Getter: Tanggal Perjalanan --->
    public Date getTanggalPerjalanan() {
        return tanggalPerjalanan;
    }
    
    //<!--- Setter: Tanggal Perjalanan --->
    public void setTanggalPerjalanan(Date tanggalPerjalanan) {
        this.tanggalPerjalanan = tanggalPerjalanan;
    }
    
    //<!--- Getter: Jumlah Orang --->
    public int getJumlahPeserta() {
        return jumlahPeserta;
    }
    
    //<!--- Setter: Jumlah Orang --->
    public void setJumlahPeserta(int jumlahPeserta) {
        if (jumlahPeserta > 0) {
            this.jumlahPeserta = jumlahPeserta;
        } else {
            System.out.println("Jumlah peserta harus lebih dari 0.");
        }
    }
    
    //<!--- Getter: Status Pemesanan --->
    public String getStatusPemesanan() {
        return statusPemesanan;
    }
    
    //<!--- Setter: Status Pemesanan --->
    public void setStatusPemesanan(String statusPemesanan) {
        if (statusPemesanan.equalsIgnoreCase("Booked") || statusPemesanan.equalsIgnoreCase("Cancelled")) {
            this.statusPemesanan = statusPemesanan;
        } else {
            System.out.println("Status pemesanan hanya bisa 'Booked' atau 'Cancelled'.");
        }
    }
    
    //<!--- Getter: Perjalanan --->
    public String getPerjalanan() {
        return "Tanggal: " + tanggalPerjalanan + ", Jumlah Peserta: " + jumlahPeserta + ", Status: " + statusPemesanan;
    }
    
    //<!---Setter: Perjalanan --->
    public void setPerjalanan(Date tanggalPerjalanan, int jumlahPeserta, String statusPemesanan) {
        setTanggalPerjalanan(tanggalPerjalanan);
        setJumlahPeserta(jumlahPeserta);
        setStatusPemesanan(statusPemesanan);
    }
}
