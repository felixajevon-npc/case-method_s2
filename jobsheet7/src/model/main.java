package model;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        mahasiswa[] daftarMahasiswa = new mahasiswa[3];
        matakuliah[] daftarMK = new matakuliah[3];
        penilaian[] daftarNilai = new penilaian[5];
        Scanner scanner = new Scanner(System.in);

        sistemakademik sistem = new sistemakademik(daftarMahasiswa, daftarMK, daftarNilai);
        sistem.isiData();

        int pilihan;
        do {
            System.out.println("\n=== MENU SISTEM AKADEMIK ===");
            System.out.println("1. Tampilkan Daftar Mahasiswa");
            System.out.println("2. Tampilkan Daftar Mata Kuliah");
            System.out.println("3. Tampilkan Data Penilaian");
            System.out.println("4. Urutkan Mahasiswa Berdasarkan Nilai Akhir");
            System.out.println("5. Cari Mahasiswa Berdasarkan NIM");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    sistem.tampilkanMahasiswa();
                    break;
                case 2:
                    sistem.tampilkanMK();
                    break;
                case 3:
                    sistem.tampilkanPenilaian();
                    break;
                case 4:
                    sistem.urutkanNilaiAkhir();
                    break;
                case 5:
                    scanner.nextLine(); // Clear the newline character
                    System.out.print("Masukkan NIM: ");
                    String nimInput = scanner.nextLine();
                    sistem.cariMahasiswa(nimInput);
                    break;
                case 0:
                    System.out.println("Keluar...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }
}
