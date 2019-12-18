package com.practices;

public class EncodeNumber {

    public static void main(String[] args) {
        System.out.println(encodeNum(0));
        System.out.println(encodeNum(53492));
        System.out.println(encodeNum(999999));
        System.out.println(encodeNum(1000000));
        System.out.println(encodeNum(1000001));
        System.out.println(encodeNum(29888885));
        System.out.println(encodeNum(298888853));
    }

    private static String encodeNum(int n) {
        StringBuilder sb = new StringBuilder();
        dfs(n, sb, 6);
        return sb.toString();
    }

    private static void dfs(int n, StringBuilder sb, int k) {
        int divisor = (int) Math.pow(10, k);

        if (divisor == 0) return;

        if (n < divisor) {
            while (n > 0) {
                sb.insert(0, n % 10);
                n /= 10;
            }

            while (sb.length() < 6) {
                sb.insert(0, '0');
            }

        } else {
            if (sb.length() == 0) {
                sb.insert(0, 'A');
                dfs(n - divisor, sb, k);
            } else {
                if (sb.charAt(0) != 'Z') {
                    char c = sb.charAt(0);
                    sb.deleteCharAt(0);
                    sb.insert(0, (char)(c + 1));
                    dfs(n - divisor, sb, k);
                } else {
                    sb.insert(0, 'A');
                    dfs(n - divisor, sb, k -1 );
                }
            }
        }
    }
}
