import java.util.Scanner;

public class SimulasiMenuATM {
    public static void main(String[] args) {
        Scanner i = new Scanner(System.in);
        double saldo = 500000;
        int opsi = 0;

        do {
            System.out.println("\nATM JAPA");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Tarik Tunai");
            System.out.println("3. Setor Tunai");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            opsi = i.nextInt();

            switch (opsi) {
                case 1:
                    System.out.println("Saldo Anda: " + saldo);
                    break;
                case 2:
                    System.out.print("Jumlah yang ingin ditarik: ");
                    int jumlah = i.nextInt();
                    if (jumlah > saldo) {
                        System.out.println("Saldo tidak cukup");
                    } else {
                        if (saldo - jumlah <= 50000) {
                            System.out.println("Tidak bisa menarik tunai, Saldo dibawah batas minimal.");
                        } else {
                            saldo -= jumlah;
                            System.out.println("Saldo Anda: " + saldo);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Jumlah yang ingin disetor: ");
                    jumlah = i.nextInt();
                    saldo += jumlah;
                    System.out.println("Saldo Anda: " + saldo);
                    break;
                case 4:
                    System.out.println("Terima kasih");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        } while (opsi != 4);

        i.close();
    }
}
