import java.util.Random;
import java.util.Scanner;

public class Mastermind {

    // Array warna yang digunakan dalam permainan
    private static final String[] WARNA = {"M", "K", "H", "B", "U", "O"};
    // Kode rahasia yang dihasilkan
    private String kodeRahasia;

    // Tahap 1: Meng-generate kode rahasia
    /**
     * Method untuk meng-generate kode rahasia acak dengan panjang 4 karakter
     * dari array warna yang disediakan.
     * @return kodeRahasia Kode rahasia yang telah di-generate
     */
    public String generateKodeRahasia() {
        // Membuat objek Random untuk mengacak pilihan warna
        Random random = new Random();
        // StringBuilder untuk menyusun kode rahasia
        StringBuilder kode = new StringBuilder();

        // Loop untuk mengisi kode rahasia sepanjang 4 karakter
        for (int i = 0; i < 4; i++) {
            // Pilih warna secara acak dari array WARNA
            int index = random.nextInt(WARNA.length);
            // Tambahkan warna yang dipilih ke kode
            kode.append(WARNA[index]);
        }

        // Simpan kode rahasia untuk digunakan nanti
        this.kodeRahasia = kode.toString();
        // Kembalikan kode rahasia
        return kodeRahasia;

    }

    // Tahap 3: Implementasi cek tebakan
    /**
     * Method untuk memeriksa tebakan pengguna dan memberikan feedback
     * terkait jumlah warna yang benar dan posisi yang benar.
     * param tebakan Tebakan dari pengguna
     * return String Hasil cek tebakan berupa jumlah warna dan posisi yang benar
     */
    public String cekTebakan(String tebakan) {
        // Inisialisasi penghitung warna yang benar
        int benarWarna = 0;
        // Inisialisasi penghitung posisi yang benar
        int benarPosisi = 0;

        // Loop untuk membandingkan tebakan dengan kode rahasia
        for (int i = 0; i < 4; i++) {
            // Jika warna dan posisi sesuai, tambahkan ke benarPosisi
            if (tebakan.charAt(i) == kodeRahasia.charAt(i)) {
                benarPosisi++;
            } 
            // Jika warna benar tapi posisi salah, tambahkan ke benarWarna
            else if (kodeRahasia.indexOf(tebakan.charAt(i)) >= 0) {
                benarWarna++;
            }
        }

        // Kembalikan hasil perbandingan tebakan
        return "Hasil: " + benarWarna + " warna benar, " + benarPosisi + " posisi benar.";
    }

    public int[] cekTebakan2 (String tebakan2){ 
        int[] hasil = new int[2]; // public int[] cekTebakan2 (String tebakan2){ 
            int benarWarna = 0;
            int benarPosisi = 0;
    
            for (int i = 0; i < tebakan2.length(); i++){
                //mencari apakah karakter yang dipilih dari tebakan ada di dalam kode rahasia.
                if(tebakan2.charAt(i) == kodeRahasia.charAt(i)){ 
                    benarPosisi++;
    
                }else if (kodeRahasia.indexOf(tebakan2.charAt(i)) >= 0){
                    benarWarna++;
    
                }
    
            }
            hasil[0] = benarWarna;
            hasil[1] = benarPosisi;
            return hasil;
        

       
        // return "Hasil: " + benarWarna + " warna benar, " + benarPosisi + "posisi benar";

        // return new cekTebakan2(benarPosisi, benarWarna);    
        
    }

    // Tahap 4: Membuat main menu permainan
    /**
     * Method utama yang menjalankan permainan Mastermind. Program akan meminta
     * pemain menebak kode rahasia yang telah di-generate. Permainan akan
     * berulang hingga pemain berhasil atau menyerah.
     */
    public static void main(String[] args) {
        // Membuat objek Mastermind untuk menjalankan permainan
        Mastermind mastermind = new Mastermind();
        // Membuat Scanner untuk menerima input dari pengguna
        Scanner scanner = new Scanner(System.in);

        // Menyapa pengguna dan mulai permainan
        System.out.println("Selamat datang di permainan Mastermind!");
        // Generate kode rahasia
        System.out.println( mastermind.generateKodeRahasia());
        // Beritahu bahwa kode rahasia telah di-generate
        System.out.println("Kode rahasia telah di-generate.");

        // Loop permainan sampai pemain menang atau menyerah
        while (true) {
            // Minta pemain untuk memasukkan tebakan
            System.out.print("Masukkan tebakan Anda (4 warna, M/K/H/B/U/O): ");
            String tebakan = scanner.nextLine().toUpperCase();

            // Panggil method cekTebakan untuk memeriksa tebakan
            // String hasil = mastermind.cekTebakan(tebakan);
            int[] hasil = mastermind.cekTebakan2(tebakan);
            // Tampilkan hasil cek tebakan
            // System.out.println(hasil);
            System.out.println("Hasil: " + hasil[0] + " warna benar, " + hasil[1] + " posisi benar.");

            // Jika tebakan benar semua (4 posisi benar), pemain menang
            if (hasil[1] == 4) {
                System.out.println("Selamat, Anda menang!");
                break; // Keluar dari loop jika menang
            }

            // Tanya pemain apakah ingin mencoba lagi
            System.out.print("Apakah Anda ingin mencoba lagi? (y/n): ");
            String cobaLagi = scanner.nextLine();
            // Jika pemain tidak ingin mencoba lagi, akhiri permainan
            if (cobaLagi.equalsIgnoreCase("n")) {
                System.out.println("Terima kasih telah bermain.");
                break; // Keluar dari loop jika pemain menyerah

            }
        }

        // Tutup Scanner setelah selesai digunakan
        scanner.close();
    }

    // Tahap 1: Getter untuk kode rahasia (untuk keperluan testing atau tampilan)
    /**
     * Method untuk mendapatkan kode rahasia yang telah di-generate.
     * @return kodeRahasia Kode rahasia yang disimpan
     */
    public String getKodeRahasia() {
        return kodeRahasia;
    }

    // Tahap 3: Setter untuk kode rahasia (untuk keperluan testing)
    /**
     * Method untuk mengatur kode rahasia secara manual (digunakan untuk testing).
     * @param kodeRahasia Kode rahasia yang ingin diset
     */
    public void setKodeRahasia(String kodeRahasia) {
        this.kodeRahasia = kodeRahasia;
    }
}
