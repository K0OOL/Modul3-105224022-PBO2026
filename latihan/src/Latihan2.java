import java.util.Scanner;

public class Latihan2 {
    public static void main(String[] args) {
        Scanner i = new Scanner(System.in);

        int loop = 0;
        int pin = 123456;

        while (loop <= 3) {
            System.out.print("Masukan PIN anda\t: ");
            pin = i.nextInt();
            if (pin == 123456) {
                System.out.println("PIN anda benar");
                break;
            } else {
                System.out.println("PIN anda salah");
                loop++;
                if (loop == 3) {
                    System.out.println("Akun diblokir");
                    break;
                }
            }
        }
        i.close();
    }
}
