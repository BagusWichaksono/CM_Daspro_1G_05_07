import java.util.Scanner;
public class StudiKasusKafe {
    static Scanner sc = new Scanner(System.in);
    static void menu(){
            System.out.println();
            System.out.println("===== MENU UTAMA =====");
            System.out.println("1. Tambahkan Pesanan");
            System.out.println("2. Tampilkan Daftar Pesanan");
            System.out.println("3. Keluar");
    }

    static void menu1(){
        System.out.println("===== MENU KAFE =====");
        System.out.println("1. Kopi Hitam - RP 15000");
        System.out.println("2. Latte - RP 22000");
        System.out.println("3. Teh Tarik - RP 12000");
        System.out.println("4. Mie Goreng -RP 18000");
    }

    static void tambahkanPesanan(String pelanggan[][], int urutanPelanggan, String namaMenu[], int harga[], int item[][]) {
        System.out.print("Masukkan nama pelanggan: ");
        pelanggan[urutanPelanggan][0] = sc.nextLine();
        System.out.print("Masukkan nomor meja: ");
        pelanggan[urutanPelanggan][1] = sc.nextLine();
        System.out.println();
        menu1();

        int totalHargaPesanan = 0;
        while (true) {
            System.out.println();
            System.out.print("Pilih menu (Masukkan nomor menu, atau 0 untuk selesai): ");
            int pilihan = sc.nextInt();
            if (pilihan == 0) {
                break;
            } else if (pilihan < 1 || pilihan > 4){
                System.out.println("Pilihan tidak valid, coba lagi");
                continue;
            }
            System.out.print("Masukkan Jumlah Item untuk "+namaMenu[pilihan-1]+": ");
            int jumlahItem = sc.nextInt();
            sc.nextLine();
            item[urutanPelanggan][pilihan-1] += jumlahItem;

            totalHargaPesanan += jumlahItem * harga[pilihan - 1];
        }
        System.out.println();
        System.out.println("Pesanan berhasil ditambahkan.");
        System.out.println("Total harga pesanan: Rp " +totalHargaPesanan);
    }
    static void tampilkanDaftarPesanan(String pelanggan[][], String namaMenu[], int harga[], int item[][], int totalPelanggan) {
        if (totalPelanggan == 0) {
            System.out.println("Belum ada Pesanan!");
        }
        System.out.println(" ===== DAFTAR PESANAN =====");
        for (int i = 0; i < totalPelanggan; i++) {
            if (pelanggan[i][0]== null) {
                continue;
            }
            System.out.println("Nama Pelanggan :"+pelanggan[i][0]);
            System.out.println("Nomor Meja :"+pelanggan[i][1]);
            System.out.println("Detail Pesanan: ");
            int totalHargaPesanan = 0;
            for (int j = 0; j < namaMenu.length; j++) {
                if (item[i][j] > 0) {
                    System.out.println("- "+ namaMenu[j]+ " x "+item[i][j]+ " = RP "+(item[i][j]*harga[j]));
                    totalHargaPesanan += item[i][j]*harga[j];
                }
            }
            System.out.println("Total Harga Pesanan :"+ totalHargaPesanan);
            System.out.println("--------------------------");
        }
    }
    public static void main(String[] args) {
        int jumlahItem, totalHargaPesanan, pilihan, urutanPelanggan = 0;
        int item[][] = new int[25][4];
        String pelanggan[][] = new String[25][2];
        String namaMenu[] = {"Kopi Hitam", "Latte", "Teh Tarik", "Mie Goreng"};
        int harga[] = {15000, 22000, 12000, 18000};

        while (true) {
            menu();
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            System.out.println();

            switch (pilihan) {
                case 1:
                    tambahkanPesanan(pelanggan, urutanPelanggan, namaMenu, harga, item);
                    urutanPelanggan++;
                    break;
                case 2:
                tampilkanDaftarPesanan(pelanggan, namaMenu, harga, item, urutanPelanggan);
                    break;
                case 3:
                    System.out.println("Program selesai!");
                    break;
                default:
                    System.out.println("Masukkan tidak valid");
                    break;
            }
            if (pilihan == 3) {
                break;
            }

        }
    }
}