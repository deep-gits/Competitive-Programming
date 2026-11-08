import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            
            while (t-- > 0) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                
                System.out.println(a % b);
            }
        }
        
        scanner.close();
    }
}