package com.baron.c10_algorithm;

public class KMPAlgorithm {

    public static void main(String[] args) {
        String str = "ABCABDA";
        String needle = "ABD";

        int ans = search(str, needle);

        System.out.println(ans);
    }

    public static int search(String str, String needle) {
        int[] table = matchTable(needle);
        char[] s = str.toCharArray();
        char[] n = needle.toCharArray();

        for ( int i = 0, j = 0; i < s.length; i++ ) {
            while ( j > 0 && s[i] != n[j] ) {
                j = table[j-1];
            }

            if ( s[i] == n[j] ) {
                j++;
            }

            if ( j == n.length ) {
                return i - j + 1;
            }
        }

        return -1;
    }

    // 获取部分搜索表（部分匹配表）
    private static int[] matchTable(String s) {
        char[] c = s.toCharArray();

        int[] ans = new int[c.length];

        ans[0] = 0; // 当只有一个字符串时，不存在最长公共前后缀

        int j = 0;
        for ( int i = 1; i < c.length; i++ ){
            // 这里需要考虑的特殊情况是：ABABCABAA
            while ( j > 0 && c[i] != c[j] ) {
                j = ans[j-1];
            }

            if ( c[j] == c[i] ) {
                j++;
            }

            ans[i] = j;
        }

        return ans;
    }
}
