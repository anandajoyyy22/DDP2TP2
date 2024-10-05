import org.junit.*;
import static org.junit.Assert.*;

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
}
