import java.util.Scanner;

public class PreTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukan Usia\t: ");
        int usia = sc.nextInt();

        System.out.print("Masukan Berat Badan\t: ");
        double bB = sc.nextDouble();

        System.out.print("Masukan Kadar Hemoglobin\t: ");
        double hb = sc.nextDouble();

        if (usia >= 17 && usia <= 65) {
            if (bB >= 45) {
                if (hb >= 12.5 && hb <= 17.0) {
                    System.out.println("Anda Memenuhi Syarat Donor Darah");
                } else {
                    System.out.println("Anda Tidak Memenuhi Syarat Donor Darah");
                }
            } else {
                System.out.println("Berat Badan Anda Kurang Dari 45 Kg");
            }
        } else {
            System.out.println("Usia Anda Tidak Memenuhi Syarat Donor Darah");
        }

        sc.close();
    }

}