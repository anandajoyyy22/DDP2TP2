import org.junit.*;
import static org.junit.Assert.*;
// Tambahin: untuk test gunakan method cek tebakan2
// Progress 3 tes yang dinilai untuk tahap 2 adalah tes yang menggunakan cektebakan2 

public class MastermindTest {

    @Test
    public void testTebakanBenarSemua() {
        Mastermind mastermind = new Mastermind();
        mastermind.setKodeRahasia("MKHB");
        assertEquals("Hasil: 0 warna benar, 4 posisi benar.", mastermind.cekTebakan("MKHB"));
    }

    @Test
    public void testTebakanSalahSemua() {
        Mastermind mastermind = new Mastermind();
        mastermind.setKodeRahasia("MKHB");
        assertEquals("Hasil: 0 warna benar, 0 posisi benar.", mastermind.cekTebakan("OOOO"));
    }

    @Test
    public void testTebakanSebagianBenar() {
        Mastermind mastermind = new Mastermind();
        mastermind.setKodeRahasia("MKHB");
        assertEquals("Hasil: 0 warna benar, 3 posisi benar.", mastermind.cekTebakan("MKHU"));
    }

    @Test
    public void testTebakanWarnaBenarPosisiSalah() {
        Mastermind mastermind = new Mastermind();
        mastermind.setKodeRahasia("MKHB");
        assertEquals("Hasil: 4 warna benar, 0 posisi benar.", mastermind.cekTebakan("BHKM"));

    }

    @Test
    public void testTebakanWarnaBenarPosisiBenar() {
        Mastermind mastermind = new Mastermind();
        mastermind.setKodeRahasia("MKHB");
        assertEquals("Hasil: 2 warna benar, 2 posisi benar.", mastermind.cekTebakan("KMHB"));
    }

    @Test
    public void testTebakanWarnaSalahPosisiSalah() {
        Mastermind mastermind = new Mastermind();
        mastermind.setKodeRahasia("MKHB");
        int[] hasil = {0, 0};
        assertArrayEquals(hasil, mastermind.cekTebakan2("UUUU"));
    }

    @Test
    public void testTebakan3WarnaBenar3PosisiSalah() {
        Mastermind mastermind = new Mastermind();
        mastermind.setKodeRahasia("MKHB");
        int[] hasil = {3, 1};
        assertArrayEquals(hasil, mastermind.cekTebakan2("HMKB"));
    }

    @Test
    public void testTebakan2WarnaBenar2PosisiSalah() {
        Mastermind mastermind = new Mastermind();
        mastermind.setKodeRahasia("MKHB");
        int[] hasil = {2, 2};
        assertArrayEquals(hasil, mastermind.cekTebakan2("KMHB"));
    }

    @Test
    public void testTebakanWarnaBenarPosisiSalahh() {
        Mastermind mastermind = new Mastermind();
        mastermind.setKodeRahasia("MKMK");
        int[] hasil = {0, 2};
        assertArrayEquals(hasil, mastermind.cekTebakan2("MMMM"));
    }

    @Test
    public void testTebakanWarnaBenarPosisiSalahhh() {
        Mastermind mastermind = new Mastermind();
        mastermind.setKodeRahasia("MKHB");
        int[] hasil = {0, 1};
        assertArrayEquals(hasil, mastermind.cekTebakan2("MMMM"));
    }

// Pengujian baru untuk mengecek skor pemain
    @Test
    public void testSkorPemain() {
        Mastermind mastermind = new Mastermind();
        mastermind.setKodeRahasia("MKHB");
        
        // Melakukan tebakan pertama dan mendapatkan hasil
        int[] hasil1 = mastermind.cekTebakan2("KMHB"); // 2 warna benar, 2 posisi benar
        // Melakukan tebakan kedua dan mendapatkan hasil
        int[] hasil2 = mastermind.cekTebakan2("MKKH"); // 1 warna benar, 2 posisi benar
        
        // Simulasi skor pemain
        int skorPemain = (4 - hasil1[1]) + (4 - hasil2[1]); // Tambahkan skor dari kedua tebakan
        // Memeriksa apakah skor yang dihitung sesuai dengan ekspektasi
        assertEquals(4, skorPemain); // Pemain seharusnya mendapat skor 2
    }


    // Pengujian baru untuk hadiah
    @Test
    public void testTampilkanHadiah() {
        Mastermind mastermind = new Mastermind();
        // Simulasikan menang
        mastermind.setKodeRahasia("MKHB");
        int[] hasil = mastermind.cekTebakan2("MKHB"); // Tebakan benar
        assertEquals(4, hasil[1]); // Harus 4 posisi benar

        // Simulasikan tampilkan hadiah
        // Cek bahwa hadiah ditampilkan tidak menghasilkan exception
        try {
            mastermind.tampilkanHadiah(); // Metode untuk menampilkan hadiah
        } catch (Exception e) {
            fail("Hadiah tidak ditampilkan dengan benar: " + e.getMessage());
        }
    }
}