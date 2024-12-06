import java.util.Scanner;

public class StudiKasusKafe {
    static Scanner sc = new Scanner(System.in);
    static void tambahkanPesanan(String pelanggan[][], int urutanPelanggan, String namaMenu[], int harga[], int item[][]) {
        System.out.print("Masukkan nama pelanggan: ");
        pelanggan[urutanPelanggan][0] = sc.nextLine();
        System.out.print("Masukkan nomor meja: ");
        pelanggan[urutanPelanggan][1] = sc.nextLine();

        System.out.println("===== MENU KAFE =====");
        System.out.println("1. Kopi Hitam - Rp 15000");
        System.out.println("2. Latte - Rp 22000");
        System.out.println("3. Teh Tarik - Rp 17000");
        System.out.println("4. Mie Goreng - Rp 18000");

        while (true) {
            System.out.print("Pilih menu (Masukkan nomor menu, atau 0 untuk selesai): ");
            
        }
    }
    
    static void tampilkanDaftarPesanan() {

    }
    public static void main(String[] args) {
        int jumlahItem, totalHargaPesanan, pilihan, urutanPelanggan = 0;
        int item[][] = new int[10][1];
        String pelanggan[][] = new String[25][2];
        String namaMenu[] = {"Kopi Hitam", "Latte", "Teh Tarik", "Mie Goreng"};
        boolean selesai = true;
        int harga[] = {15000, 22000, 12000, 18000};

        while (selesai) {
            System.out.println("===== MENU UTAMA =====");
            System.out.println("1. Tambahkan Pesanan");
            System.out.println("2. Tampilkan Daftar Pesanan");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    tambahkanPesanan(pelanggan, urutanPelanggan, namaMenu, harga, item);
                    urutanPelanggan++;
                    break;
                case 2:
                    tampilkanDaftarPesanan();
                    break;
                case 3:
                    selesai = false;
                    System.out.println("Program selesai!");
                    break;
                default:
                    System.out.println("Masukkan tidak valid");
                    break;
            }

        }
            
    }
}