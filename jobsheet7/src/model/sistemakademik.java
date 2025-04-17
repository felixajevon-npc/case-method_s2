package model;

import java.util.Scanner;

public class sistemakademik {
    mahasiswa[] daftarMahasiswa = new mahasiswa[3];
    matakuliah[] daftarMK = new matakuliah[3];
    nilai[] daftarNilai = new nilai[5];
    Scanner scanner = new Scanner(System.in);

    void mulai() {
        isiData();

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
                    tampilkanMahasiswa();
                    break;
                case 2:
                    tampilkanMK();
                    break;
                case 3:
                    tampilkanPenilaian();
                    break;
                case 4:
                    urutkanNilaiAkhir();
                    break;
                case 5:
                    cariMahasiswa();
                    break;
                case 0:
                    System.out.println("Keluar...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }

    void isiData() {
        daftarMahasiswa[0] = new mahasiswa("22001", "Ali Rahman", "Informatika");
        daftarMahasiswa[1] = new mahasiswa("22002", "Budi Santoso", "Informatika");
        daftarMahasiswa[2] = new mahasiswa("22003", "Citra Dewi", "Sistem Informasi Bisnis");

        daftarMK[0] = new matakuliah("MK001", "Struktur Data", 3);
        daftarMK[1] = new matakuliah("MK002", "Basis Data", 3);
        daftarMK[2] = new matakuliah("MK003", "Desain Web", 3);

        daftarNilai[0] = new nilai("22001", "MK001", 80, 85, 90);
        daftarNilai[1] = new nilai("22001", "MK002", 70, 65, 68);
        daftarNilai[2] = new nilai("22002", "MK001", 75, 70, 80);
        daftarNilai[3] = new nilai("22003", "MK002", 85, 80, 88);
        daftarNilai[4] = new nilai("22003", "MK003", 65, 60, 75);
    }

    void tampilkanMahasiswa() {
        for (int i = 0; i < daftarMahasiswa.length; i++) {
            mahasiswa m = daftarMahasiswa[i];
            System.out.println("NIM: " + m.nim + " | Nama: " + m.nama + " | Prodi: " + m.prodi);
        }
    }

    void tampilkanMK() {
        for (int i = 0; i < daftarMK.length; i++) {
            matakuliah mk = daftarMK[i];
            System.out.println("Kode MK: " + mk.kodeMK + " | Nama: " + mk.namaMK + " | SKS: " + mk.sks);
        }
    }

    void tampilkanPenilaian() {
        for (int i = 0; i < daftarNilai.length; i++) {
            nilai n = daftarNilai[i];
            String nama = cariNamaMahasiswa(n.nim);
            String mk = cariNamaMK(n.kodeMK);
            double nilaiAkhir = n.hitungNilaiAkhir();
            System.out.printf("%s | %s | Nilai Akhir: %.1f\n", nama, mk, nilaiAkhir);
        }
    }

    void urutkanNilaiAkhir() {
        for (int i = 0; i < daftarNilai.length - 1; i++) {
            for (int j = 0; j < daftarNilai.length - i - 1; j++) {
                if (daftarNilai[j].hitungNilaiAkhir() < daftarNilai[j + 1].hitungNilaiAkhir()) {
                    nilai temp = daftarNilai[j];
                    daftarNilai[j] = daftarNilai[j + 1];
                    daftarNilai[j + 1] = temp;
                }
            }
        }
        tampilkanPenilaian();
    }

    void cariMahasiswa() {
        System.out.print("Masukkan NIM: ");
        String input = scanner.next();
        boolean ditemukan = false;

        for (int i = 0; i < daftarMahasiswa.length; i++) {
            if (daftarMahasiswa[i].nim.equals(input)) {
                System.out.println("Ditemukan: " + daftarMahasiswa[i].nama + " | Prodi: " + daftarMahasiswa[i].prodi);
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Mahasiswa tidak ditemukan.");
        }
    }

    String cariNamaMahasiswa(String nim) {
        for (int i = 0; i < daftarMahasiswa.length; i++) {
            if (daftarMahasiswa[i].nim.equals(nim)) {
                return daftarMahasiswa[i].nama;
            }
        }
        return "";
    }

    String cariNamaMK(String kodeMK) {
        for (int i = 0; i < daftarMK.length; i++) {
            if (daftarMK[i].kodeMK.equals(kodeMK)) {
                return daftarMK[i].namaMK;
            }
        }
        return "";
    }
}

