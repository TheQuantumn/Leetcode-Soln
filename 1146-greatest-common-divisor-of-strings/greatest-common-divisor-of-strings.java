class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int gcd = gcd(str1.length(), str2.length());
        String commonPrefix = str1.substring(0, gcd);

        // Check if both strings can be formed by repeating the commonPrefix
        if (str1.equals(commonPrefix.repeat(str1.length() / gcd)) &&
            str2.equals(commonPrefix.repeat(str2.length() / gcd))) {
            return commonPrefix;
        }
        return "";
    }

    // Efficient GCD using Euclidean Algorithm
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
