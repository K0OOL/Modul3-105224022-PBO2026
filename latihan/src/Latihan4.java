import java.util.Scanner;

public class Latihan4 {
    public static void main(String[] args) {

        Scanner i = new Scanner(System.in);
        double nilai = 0;
        int absensi = 0;

        System.out.print("masukan nilai: ");
        nilai = i.nextDouble();

        System.out.print("masukan absensi: ");
        absensi = i.nextInt();

        String hasil = (nilai >= 75 && absensi > 80) ? "lulus" : "tidak lulus";
        System.out.println(hasil);
        i.close();
    }

}