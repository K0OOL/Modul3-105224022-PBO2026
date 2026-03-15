import java.util.Scanner;

public class SistemKioskMandiri {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // VIP
        String namaVIP = "VIP";
        int hargaVIP = 1500000;
        int stokVIP = 5;
        int minUsiaVIP = 18;

        // Festival
        String namaFestival = "Festival";
        int hargaFestival = 800000;
        int stokFestival = 25;
        int minUsiaFestival = 15;

        // Tribune
        String namaTribune = "Tribune";
        int hargaTribune = 500000;
        int stokTribune = 35;
        int minUsiaTribune = 0;

        // Dynamic Variable
        String namaAktif = "";
        int hargaAktif = 0;
        int minUsiaAktif = 0;

        // Transaction Variable
        int qty = 0;
        int usia = 0;
        int totalHarga = 0;
        int berhasil = 0;
        int pilihan = 0;
        boolean batalDarurat = false;

        while (true) {
            System.out.println("\n======================================");
            System.out.println("UNIVERSITAS PERTAMINA - SOUNDFEST 2026\nKiosk Tiket Mandiri v1.0");
            System.out.println("======================================\n");
            System.out.println("Selamat datang, Silahkan pilih kategori tiket anda.");
            System.out.println(
                    "[1] " + namaVIP + "\t\t Rp 1.500.000\t| Stok: " + stokVIP + "\t| Min Usia: " + minUsiaVIP + "thn");
            System.out.println("[2] " + namaFestival + "\t Rp 800.000\t| Stok: " + stokFestival + "\t| Min Usia: "
                    + minUsiaFestival + "thn");
            System.out.println("[3] " + namaTribune + "\t Rp 500.000\t| Stok: " + stokTribune + "\t| Semua Usia");
            System.out.println("--------------------------------------");
            System.out.print("\nMasukan Pilihan: ");
            if (sc.hasNextInt()) {
                pilihan = sc.nextInt();
            } else {
                sc.next();
                System.out.println("[!] Pilihan tidak valid, coba lagi.");
                continue;
            }

            if (pilihan == 4) {
                System.out.println("\n[SYS] Mesin dimatikan oleh teknisi, sampai jumpa.");
                break;
            }

            if (pilihan < 1 || pilihan > 3) {
                System.out.println("[!] Pilihan tidak valid, masukan angka 1-3.");
                continue;
            }

            if (pilihan == 1) {
                namaAktif = namaVIP;
                hargaAktif = hargaVIP;
                minUsiaAktif = minUsiaVIP;
            } else if (pilihan == 2) {
                namaAktif = namaFestival;
                hargaAktif = hargaFestival;
                minUsiaAktif = minUsiaFestival;
            } else if (pilihan == 3) {
                namaAktif = namaTribune;
                hargaAktif = hargaTribune;
                minUsiaAktif = minUsiaTribune;
            }

            totalHarga = 0;
            berhasil = 0;
            batalDarurat = false;

            System.out
                    .println("\nAnda memilih: " + namaAktif + " (Rp " + String.format("%,d", hargaAktif) + " / tiket)");

            do {
                System.out.print("Jumlah tiket yang ingin dibeli: ");
                if (sc.hasNextInt()) {
                    qty = sc.nextInt();
                } else {
                    sc.next();
                    qty = 0;
                }
                if (qty < 1) {
                    System.out.println("[!] Jumlah tiket minimal 1, coba lagi.");
                }
            } while (qty < 1);

            if (pilihan == 1 && qty > stokVIP) {
                System.out.println("[x] Stok " + namaVIP + " tidak mencukupi! Tersedia: " + stokVIP + " tiket.");
                continue;
            } else if (pilihan == 2 && qty > stokFestival) {
                System.out.println(
                        "[x] Stok " + namaFestival + " tidak mencukupi! Tersedia: " + stokFestival + " tiket.");
                continue;
            } else if (pilihan == 3 && qty > stokTribune) {
                System.out
                        .println("[x] Stok " + namaTribune + " tidak mencukupi! Tersedia: " + stokTribune + " tiket.");
                continue;
            }

            System.out.println("\n\nStok mencukupi. Memproses " + qty + " Tiket " + namaAktif + "...\n");

            for (int i = 1; i <= qty; i++) {

                System.out.println("\n\n--- Tiket ke " + i + " dari " + qty + "---");

                while (true) {
                    System.out.print("Masukan usia pemegang tiket ke-" + i + " (-1 untuk batal darurat): ");

                    if (sc.hasNextInt()) {
                        usia = sc.nextInt();
                    } else {
                        sc.next();
                        System.out.println("[!] Masukan angka valid.");
                        continue;
                    }

                    if (usia == -1) {
                        System.out.println("[!] Batal darurat - sisa pesanan telah dibatalkan.");
                        batalDarurat = true;
                        break;
                    }

                    if (usia < 1 || usia > 120) {
                        System.out.println("[!] Usia tidak logis.");
                        continue;
                    }

                    if (minUsiaAktif > 0 && usia < minUsiaAktif) {
                        System.out.println("[x] Tiket ke-" + i + " Ditolak - usia " + usia
                                + " thn tidak memenuhi syarat (min. " + minUsiaAktif + " thn).");
                        break;
                    }

                    if (pilihan == 1) {
                        stokVIP--;
                    } else if (pilihan == 2) {
                        stokFestival--;
                    } else {
                        stokTribune--;
                    }

                    totalHarga += hargaAktif;
                    berhasil++;
                    System.out.println("[!] Tiket ke-" + i + " Lolos - usia " + usia + " thn valid.");
                    break;
                }

                if (batalDarurat) {
                    break;
                }
            }

            System.out.println("\n======================================");
            System.out.println("\tNOTA TRANSAKSI\t");
            System.out.println("======================================");
            System.out.println("Kategori\t: " + namaAktif);
            System.out.println("Dipesan\t\t: " + qty + " Tiket");
            System.out.println("Berhasil\t: " + berhasil + " Tiket");
            System.out.println("Ditolak\t\t: " + (qty - berhasil) + " Tiket");
            System.out.println("Harga/tiket\t: Rp " + String.format("%,d", hargaAktif));
            System.out.println("--------------------------------------");
            System.out.println("Total Harga\t: Rp " + String.format("%,d", totalHarga));
            System.out.println("======================================");

            if (berhasil > 0) {
                System.out.println("Terima Kasih! Sampai jumpa di SoundFest 2026!");
            } else {
                System.out.println("Tidak ada tiket yang berhasil diproses.");
            }
        }
        sc.close();
    }
}
