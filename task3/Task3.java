import java.util.Arrays;
import java.util.Locale;
import java.util.stream.IntStream;

public class Task3 {
   public static void main(String[] args) {
      System.out.println(solutions(1, 0, -1));
      System.out.println(findZip("all zip files are zipped"));
      System.out.println(checkPerfect(6));
      System.out.println(flipEndChars("Cat, dog, and mouse."));
      System.out.println(isValidHexCode("#CD5C5C"));
      System.out.println(same(new int[] { 1, 3, 4, 4, 4 }, new int[] { 2, 5, 7 }));
      System.out.println(isKaprekar(3));
      System.out.println(longestZero("01100001011000"));
      System.out.println(nextPrime(12));
      System.out.println(rightTriangle(3, 4, 5));
   }

   public static int solutions(int a, int b, int c) {
      double d = (b * b - 4 * a * c);
      if (d > 0) {
         return 2;
      } else if (d == 0) {
         return 1;
      } else {
         return 0;
      }
   }

   public static int findZip(String str) {
      return str.indexOf("zip", str.indexOf("zip") + 1);
   }

   public static boolean checkPerfect(int n) {
      int[] del = new int[n];
      for (int i = 1; i < n / 2 + 1; i++) {
         if (n % i == 0) {
            del[i] = i;
         }
      }
      return IntStream.of(del).sum() == n;
   }

   public static String flipEndChars(String str) {
      if (str.length() < 2) {
         return "Incompatible.";
      } else if (str.charAt(0) == str.charAt(str.length() - 1)) {
         return "Two's a pair.";
      } else {
         char[] result = str.toCharArray();
         char tmp = result[0];
         result[0] = result[str.length() - 1];
         result[str.length() - 1] = tmp;
         return String.valueOf(result);
      }
   }

   public static boolean isValidHexCode(String code) {
      return code.toLowerCase(Locale.ENGLISH).matches("#[a-f\\d]{6}");
   }

   public static boolean same(int[] arr1, int[] arr2) {
      return Arrays.stream(arr1).distinct().count() == Arrays.stream(arr2).distinct().count();
   }

   public static boolean isKaprekar(int n) {
      String sqr = Integer.toString(n * n);
      if ((sqr == "1") | (sqr == "0")) {
         return true;
      } else {
         if (sqr.length() == 1) {
            return false;
         }
         String start = sqr.substring(0, sqr.length() / 2);
         String finish = sqr.substring(sqr.length() / 2);
         return Integer.valueOf(start) + Integer.valueOf(finish) == n;
      }
   }

   public static String longestZero(String str) {
      String[] arr = str.split("1");
      int max = -1;
      for (String string : arr) {
         if (string.length() > max) {
            max = string.length();
         }
      }
      return "0".repeat(max);
   }
   
   public static boolean prime(int n){
      for (int i=2; i<=Math.sqrt(n); i++)
          if (n%i==0)
              return false;
      return n > 1;
  }
   public static int nextPrime(int n){
      if (prime(n)) {
         return n;
      } else {
         while (!prime(n)){
            n++;
         }
         return n;
      }
   }

   public static boolean rightTriangle(int... sides){
      Arrays.sort(sides);
      return sides[0] * sides[0] + sides[1] * sides[1] == sides[2] * sides[2];
  }
}
