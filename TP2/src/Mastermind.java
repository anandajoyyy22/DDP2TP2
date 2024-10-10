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
     * @param tebakan Tebakan dari pengguna
     * @return String Hasil cek tebakan berupa jumlah warna dan posisi yang benar
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

    public int[] cekTebakan2(String tebakan) {
        int[] hasil = new int[2];  
        int benarWarna = 0;      
        int benarPosisi = 0;      
            
        boolean[] kodePosisiBenar = new boolean[4];
        boolean[] tebakanPosisiBenar = new boolean[4];
            
        //  warna dan posisi yang benar
        for (int i = 0; i < tebakan.length(); i++) {
            if (tebakan.charAt(i) == kodeRahasia.charAt(i)) {
                benarPosisi++;
                kodePosisiBenar[i] = true; 
                tebakanPosisiBenar[i] = true; 
            }
        }
            
        //  kalo posisinya salah
        for (int i = 0; i < tebakan.length(); i++) {
            if (!tebakanPosisiBenar[i]) { 
                for (int j = 0; j < kodeRahasia.length(); j++) {
                    //  warna yang cocok tetapi di posisi yang berbeda dan belum cocok
                    if (!kodePosisiBenar[j] && tebakan.charAt(i) == kodeRahasia.charAt(j)) {
                        benarWarna++;
                        kodePosisiBenar[j] = true;
                        break;
                    }
                }
            }
        }        
            
        hasil[0] = benarWarna;
        hasil[1] = benarPosisi;
        return hasil;
    }

    // Method untuk menampilkan hadiah
    /**
     * Method untuk menampilkan hadiah dalam bentuk seni ASCII.
     */
    public void tampilkanHadiah() { // Metode baru untuk menampilkan hadiah
        System.out.println("\nSelamat! Anda mendapatkan hadiah!");
        System.out.println("  _____");
        System.out.println(" |     |");
        System.out.println(" |  *  |");
        System.out.println(" |     |");
        System.out.println(" |_____|");
        System.out.println("   | |");
        System.out.println("   | |");
        System.out.println("   |_|");
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
        
        // Menanyakan jumlah pemain
        System.out.print("Masukkan jumlah pemain: ");
        int jumlahPemain = scanner.nextInt();
        scanner.nextLine(); // Mengambil newline setelah nextInt
        
        // Array untuk menyimpan nama pemain dan skor
        String[] namaPemain = new String[jumlahPemain];
        int[] skorPemain = new int[jumlahPemain];
        
        // Minta nama masing-masing pemain
        for (int i = 0; i < jumlahPemain; i++) {
            System.out.print("Masukkan nama pemain " + (i + 1) + ": ");
            namaPemain[i] = scanner.nextLine();
        }
        
        // Game Loop
        while (true) {
            // Generate kode rahasia
            mastermind.generateKodeRahasia();
            System.out.println("Kode rahasia telah di-generate.");

            // Loop untuk setiap pemain
            for (int i = 0; i < jumlahPemain; i++) {
                System.out.println("\nGiliran: " + namaPemain[i]);
                int kesempatan = 5; // Maximum attempts for each player

                while (kesempatan > 0) {
                    // Minta pemain untuk memasukkan tebakan
                    System.out.print("Masukkan tebakan Anda (4 warna, M/K/H/B/U/O): ");
                    String tebakan = scanner.nextLine().toUpperCase();

                    // Panggil method cekTebakan untuk memeriksa tebakan
                    int[] hasil = mastermind.cekTebakan2(tebakan);
                    // Tampilkan hasil cek tebakan
                    System.out.println("Hasil: " + hasil[0] + " warna benar, " + hasil[1] + " posisi benar.");

                    // Tambahkan skor untuk langkah ini
                    skorPemain[i] += (4 - hasil[1]); // Skor berkurang sesuai jumlah posisi yang benar

                    // Jika tebakan benar semua (4 posisi benar), pemain menang
                    if (hasil[1] == 4) {
                        System.out.println("Selamat, " + namaPemain[i] + ", Anda menang!");
                        break; // Keluar dari loop jika menang
                    }

                    // Mengurangi kesempatan
                    kesempatan--;

                    // Jika kesempatan habis
                    if (kesempatan == 0) {
                        System.out.println("Kesempatan Anda habis, " + namaPemain[i] + ". Kode rahasia adalah: " + mastermind.getKodeRahasia());
                    } else {
                        // Tanya pemain apakah ingin menyerah
                        System.out.print("Apakah Anda ingin menyerah? (y/n): ");
                        String menyerah = scanner.nextLine();
                        if (menyerah.equalsIgnoreCase("y")) {
                            break; // Keluar dari loop tebakan untuk pemain ini
                        }
                    }
                }
            }

            // Tanya pemain apakah ingin bermain lagi
            System.out.print("\nApakah Anda ingin bermain lagi? (y/n): ");
            String mainLagi = scanner.nextLine();
            if (mainLagi.equalsIgnoreCase("n")) {
                System.out.println("Terima kasih telah bermain.");
                break; // Keluar dari loop permainan
            }
        }

        // Tampilkan skor setiap pemain
        System.out.println("\nSkor Akhir:");
        int maxSkor = 0;
        String pemenang = "";

        for (int i = 0; i < jumlahPemain; i++) {
            System.out.println(namaPemain[i] + ": " + skorPemain[i] + " poin");
            if (skorPemain[i] > maxSkor) {
                maxSkor = skorPemain[i];
                pemenang = namaPemain[i];
            }
        }

        // Tampilkan pemenang
        System.out.println("\nPemenang: " + pemenang + " dengan " + maxSkor + " poin!");
        // Tampilkan hadiah untuk pemenang
        mastermind.tampilkanHadiah();

        // Tutup scanner
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

    // Tahap 3: Setter untuk kode rahasia (untuk keperluan testing atau tampilan)
    /**
     * Method untuk mengatur kode rahasia secara manual (untuk keperluan testing).
     * @param kodeRahasia Kode rahasia yang akan diatur
     */
    public void setKodeRahasia(String kodeRahasia) {
        this.kodeRahasia = kodeRahasia;
    }
}
