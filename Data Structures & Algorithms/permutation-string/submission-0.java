class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s2.length();
        int m = s1.length();
        if (m > n) {
            return false;
        }
        int[] need = new int[26];
        int[] window = new int[26];

        for (char c : s1.toCharArray()) {
            need[c - 'a']++;
        }
        for (int i = 0; i < m; i++) {
            window[s2.charAt(i) - 'a']++;
        }
        if (matches(need, window)) {
            return true;
        }
        for (int right = m; right < n; right++) {
            char addChar = s2.charAt(right);
            char removeChar = s2.charAt(right - m);
            window[addChar - 'a']++;
            window[removeChar - 'a']--;

            if (matches(need, window)) {
                return true;
            }
        }
        return false;
    }
    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
