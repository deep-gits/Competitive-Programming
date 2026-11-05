# CCHOCOLATES - Rating 520

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

_Description not available._

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-05T11:51:57.414Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        while (n-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            
            if ((a > b && a < c) || (a < b && a > c)) {
                System.out.println(a);
            } else if ((b > a && b < c) || (b < a && b > c)) {
                System.out.println(b);
            } else {
                System.out.println(c);
            }
        }
    }
}
```

---

[View on CodeChef](https://www.codechef.com/problems/CCHOCOLATES)