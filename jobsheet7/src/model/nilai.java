package model;

public class nilai {
    String nim, kodeMK;
    int tugas, uts, uas;

    nilai(String nim, String kodeMK, int tugas, int uts, int uas) {
        this.nim = nim;
        this.kodeMK = kodeMK;
        this.tugas = tugas;
        this.uts = uts;
        this.uas = uas;
    }

    double hitungNilaiAkhir() {
        return (tugas * 0.3) + (uts * 0.3) + (uas * 0.4);
    }
}
