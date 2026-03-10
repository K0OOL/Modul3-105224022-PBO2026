import java.util.Scanner;

public class Latihan1 {
    public static void main(String[] args) {
        Scanner i = new Scanner(System.in);

        System.out.print("Kalkulator java woi\nPilih salah satu operator matematika.\n+, -, *, /\t\t: ");
        String op = i.nextLine();

        System.out.print("Masukkan angka pertama\t: ");
        double a = i.nextDouble();

        System.out.print("Masukkan angka kedua\t: ");
        double b = i.nextDouble();

        switch (op) {
            case "+":
                System.out.println("Hasilnya\t: " + (a + b));
                break;
            case "-":
                System.out.println("Hasilnya\t: " + (a - b));
                break;
            case "*":
                System.out.println("Hasilnya\t: " + (a * b));
                break;
            case "/":
                if (b == 0) {
                    System.out.println("Error: Pembagian dengan nol tidak diizinkan.");
                } else {
                    System.out.println("Hasilnya\t\t: " + (a / b));
                }
                break;
            default:
                System.out.println("Error: Operator tidak valid.");
        }
        i.close();
    }
}
