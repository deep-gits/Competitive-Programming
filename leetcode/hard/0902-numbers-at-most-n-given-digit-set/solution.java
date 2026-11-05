class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = String.valueOf(n);
        int len = s.length();
        int ans = 0;
        int k = digits.length;
        
        for (int i = 1; i < len; i++) {
            ans += Math.pow(k, i);
        }
        
        for (int i = 0; i < len; i++) {
            boolean hasSameDigit = false;
            for (String d : digits) {
                char c = d.charAt(0);
                if (c < s.charAt(i)) {
                    ans += Math.pow(k, len - i - 1);
                } else if (c == s.charAt(i)) {
                    hasSameDigit = true;
                    break;
                }
            }
            if (!hasSameDigit) {
                return ans;
            }
        }
        
        return ans + 1;
    }
}