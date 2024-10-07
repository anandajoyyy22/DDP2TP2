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
}
