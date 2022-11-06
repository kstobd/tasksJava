import java.util.Arrays;
import java.util.stream.IntStream;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(repeat("mice", 5));
        System.out.println(differenceMaxMin(new int[] { 10, 4, 1, 4, -10, -50, 32, 21 }));
        System.out.println(isAvgWhole(new int[] { 1, 3 }));
        System.out.println(Arrays.toString(cumulativeSum(new int[] { 1, 2, 3 })));
        System.out.println(getDecimalPlaces("43.20"));
        System.out.println(Fibonacci(7));
        System.out.println(isValid("59001"));
        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(boxSeq(1));
    }

    public static String repeat(String s, int n) {
        String str = "";
        for (char ch : s.toCharArray()) {
            for (int i = 0; i < n; i++) {
                str += ch;
            }
        }
        return str;
    }

    public static int differenceMaxMin(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max - min;
    }

    public static boolean isAvgWhole(int[] arr) {
        return IntStream.of(arr).sum() % arr.length == 0;
    }

    public static int[] cumulativeSum(int[] arr) {
        int[] rez = new int[arr.length];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            rez[i] = sum + arr[i];
            sum += arr[i];
        }
        return rez;
    }

    public static int getDecimalPlaces(String str) {
        String[] newStr = str.split("\\.");
        return newStr[1].length();
    }

    public static int Fibonacci(int n) {
        int n0 = 1;
        int n1 = 1;
        int n2 = 0;
        for (int i = 3; i <= n; i++) {
            n2 = n0 + n1;
            n0 = n1;
            n1 = n2;
        }
        return n2;
    }

    public static boolean isValid(String postIndex) {
        return postIndex.matches("\\d{5}");
    }

    public static boolean isStrangePair(String str1, String str2) {
        return ((str1.charAt(0) == str2.charAt(str2.length() - 1))
                && (str1.charAt(str1.length() - 1) == str2.charAt(0)));
    }

    public static boolean isPrefix(String word, String pref){
        return word.startsWith(pref.replace("-", ""));
    }

    public static boolean isSuffix(String word, String suf){
        return word.endsWith(suf.replace("-", ""));
    }

    public static int boxSeq(int number) {
        return (number + 1)/2*3 - number/2;
    }
}