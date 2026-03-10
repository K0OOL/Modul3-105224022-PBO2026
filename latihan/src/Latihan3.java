public class Latihan3 {
    public static void main(String[] args) {
        for (int i = 0; i <= 50; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                continue;
            } else {
                System.out.print(i + " ");
            }
        }
    }
}
