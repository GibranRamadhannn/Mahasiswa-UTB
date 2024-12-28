/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package manajemenwisata;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mgibr
 */
public class ManajemenWisata {
    //<!--- Koleksi menyimpan inputan pengguna --->
    private static ArrayList<PaketWisata> daftarPaket = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    //<!========== Main begin: ==========>
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        
        do {
            System.out.println("========== SELAMAT DATANG DI WISATA GIBRAN ==========");
            System.out.println("Silahkan pilih menu dibawah ini!");
            System.out.println("1. Tambah Paket Wisata");
            System.out.println("2. Lihat Paket Wisata");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu (1-3): ");
            pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilihan) {
                case 1:
                    tambahPaketWisata(scanner);
                    break;
                case 2:
                    lihatDaftarPaket(scanner);
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan sistem.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
            
        } while (pilihan != 3);
        scanner.close();
    }
    //<!========== Main end: ==========>
    
    //<!========== FUNGSI MENAMBAH PAKET WISATA begin: ==========>
    private static void tambahPaketWisata(Scanner scanner) {
        System.out.println("\n--- Tambah Paket Wisata ---");
        System.out.print("Jenis Paket (1. Wisata Alam, 2. Wisata Budaya): ");
        int jenisPaket = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nama Paket: ");
        String nama = scanner.nextLine();
        System.out.print("Destinasi: ");
        String destinasi = scanner.nextLine();
        System.out.print("Harga: ");
        
        double harga = scanner.nextDouble();
        scanner.nextLine();

        if (jenisPaket == 1) {
            System.out.print("Jenis Ekosistem: ");
            String jenisEkosistem = scanner.nextLine();
            daftarPaket.add(new WisataAlam(nama, destinasi, harga, jenisEkosistem));
            System.out.println("Paket Wisata Alam berhasil ditambahkan.");
        } else if (jenisPaket == 2) {
            System.out.print("Jenis Budaya: ");
            String jenisBudaya = scanner.nextLine();
            daftarPaket.add(new WisataBudaya(nama, destinasi, harga, jenisBudaya));
            System.out.println("Paket Wisata Budaya berhasil ditambahkan.");
        } else {
            System.out.println("Jenis paket tidak valid.");
        }
    }
    //<!========== FUNGSI MENAMBAH PAKET WISATA end: ==========>
    
    //<!========== FUNGSI MELIHAT PAKET WISATA begin: ==========>
    private static void lihatDaftarPaket(Scanner scanner) {
        System.out.println("\n--- Daftar Paket Wisata ---");
        if (daftarPaket.isEmpty()) {
            System.out.println("Belum ada paket wisata yang tersedia.");
        } else {
            for (int i = 0; i < daftarPaket.size(); i++) {
                PaketWisata paket = daftarPaket.get(i);
                System.out.println((i + 1) + ". " + paket.info());
            }
            System.out.print("\nPilih paket untuk booking (0 untuk kembali): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            if (pilihan > 0 && pilihan <= daftarPaket.size()) {
                PaketWisata paketTerpilih = daftarPaket.get(pilihan - 1);
                bookingPaket(scanner, paketTerpilih);
            } else if (pilihan == 0) {
                System.out.println("Kembali ke menu utama.");
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }
    }
    //<!========== FUNGSI MELIHAT PAKET WISATA end: ==========>
    
    //<!========== FUNGSI BOOKING PAKET WISATA begin: ==========>
    private static void bookingPaket(Scanner scanner, PaketWisata paket) {
        System.out.println("\n--- Booking Paket Wisata ---");
        System.out.println("Paket yang dipilih: " + paket.info());
        System.out.print("Masukkan jumlah orang: ");
        int jumlahOrang = scanner.nextInt();
        scanner.nextLine();
        
        double totalHarga = paket.hitungBiaya(jumlahOrang);
        String laporanTerakhir = generateLaporan(paket, jumlahOrang, totalHarga);
        
        System.out.println("Booking berhasil!");
        System.out.println("Total harga: " + totalHarga);
        int opsi;
        
        do {
            System.out.println("\n1. Lihat Laporan Perjalanan");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.print("Pilih opsi: ");
            opsi = scanner.nextInt();
            scanner.nextLine();

            if (opsi == 1) {
                System.out.println("\n--- Laporan Perjalanan ---");
                System.out.println(laporanTerakhir);
            } else if (opsi != 0) {
                System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        } while (opsi != 0);
    }
    //<!========== FUNGSI BOOKING PAKET WISATA end: ==========>
    
    //<!========== FUNGSI LAPORAN PERJALANAN begin: ==========>
    private static String generateLaporan(PaketWisata paket, int jumlahOrang, double totalHarga) {
        return "Paket Wisata: " + paket.nama + "\n" +
               "Jumlah Orang: " + jumlahOrang + "\n" +
               "Total Harga: " + totalHarga + "\n";
    }
    //<!========== FUNGSI LAPORAN PERJALANAN end: ==========>
}


