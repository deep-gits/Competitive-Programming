import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            
            if (y <= x) {
                System.out.println(y);
            } else {
                int extra = y - x;
                System.out.println(x + (extra * 2));
            }
        }
    }
}