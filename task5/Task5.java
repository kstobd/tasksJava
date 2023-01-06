import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Task5 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        for (int crypt : encrypt("Hello")) {
            System.out.print(crypt + " ");
        }
        System.out.println();
        System.out.println(decrypt(new int[] { 72, 33, -73, 84, -12, -3, 13, -13, -68 }));
        System.out.println(canMove("Rook", "A8", "H8"));
        System.out.println(canComplete("butl", "beautiful"));
        System.out.println(sumDigProd(6, 28));
        System.out.println(sameVowelGroup(new String[] { "toe", "ocelot", "maniac" }));
        System.out.println(validateCard("1234567890123456"));
        System.out.println(numToEng(284));
        System.out.println(getSha256Hash("password123"));
        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
        System.out.println(hexLattice(7));

    }

    public static int[] encrypt(String str) {
        int[] rez = new int[str.length()];
        char[] charArr = str.toCharArray();
        rez[0] = charArr[0];
        for (int i = 1; i < charArr.length; i++) {
            rez[i] = charArr[i] - charArr[i - 1];
        }
        return rez;
    }

    public static String decrypt(int[] arr) {
        String rez = Character.toString(arr[0]);
        int tmp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            rez += Character.toString(tmp + arr[i]);
            tmp += arr[i];
        }
        return rez;
    }

    public static boolean canMove(String figure, String start, String finish) {
        int x = finish.toUpperCase().charAt(0) - start.toUpperCase().charAt(0);int y = finish.charAt(1) - start.charAt(1);
        boolean rezult = false;
        switch (figure) {
            case "Pawn":
                rezult = (y == 0 && x == 1);
                break;
            case "Rook":
                rezult = (x == 0 || y == 0);
                break;
            case "Horse":
                rezult = ((Math.abs(x) == 2 && Math.abs(y) == 1) || (Math.abs(y) == 2 && Math.abs(x) == 1));
                break;
            case "Bishop":
                rezult = (Math.abs(x) == Math.abs(y));
                break;
            case "Queen":
                rezult = ((Math.abs(x) == Math.abs(y)) || (x == 0 || y == 0));
                break;
            case "King":
                rezult = (((Math.abs(x) == Math.abs(y)) || (x == 0 || y == 0)) && x < 2 && y < 2);
                break;
        }
        return rezult;
    }

    public static boolean canComplete(String mini, String orig) {
        char[] chArr = mini.toCharArray();
        int count = 0;
        char[] orChar = orig.toCharArray();
        for (char c : orChar) {
            if (c == chArr[count]) {
                count += 1;
            }
        }
        return (count == chArr.length);
    }

    public static int sumDigProd(int... arr) {
        int tmp = 1;
        int num = Arrays.stream(arr).sum();
        while (num > 10) {
            while (num > 0) {
                tmp *= num % 10;
                num = num / 10;
            }
            num = tmp;
            tmp = 1;
        }
        return num;
    }

    public static ArrayList<String> sameVowelGroup(String[] arr) {
        ArrayList<String> rez = new ArrayList<>();
        rez.add(arr[0]);
        Set<Character> set = new HashSet<Character>();
        String newW = arr[0].replaceAll(
                "[^AEIOUaeiou]", "");
        char[] firstVol = newW.toCharArray();
        for (char c : firstVol) {
            set.add(c);
        }
        Set<Character> tmpSet = new HashSet<Character>();
        for (int i = 1; i < arr.length; i++) {
            tmpSet.clear();
            String newW1 = arr[i].replaceAll(
                    "[^AEIOUaeiou]", "");
            char[] pin = newW1.toCharArray();
            for (char c : pin) {
                tmpSet.add(c);
            }
            if (set.equals(tmpSet)) {
                rez.add(arr[i]);
            }
        }
        return rez;
    }

    public static boolean validateCard(String num) {
        if (num.length() < 14 || num.length() > 19) {
            return false;
        }
        int digit = num.charAt(num.length() - 1) - 48, d;
        int sum = 0;
        num = num.substring(0, num.length() - 1);
        int[] arr = new int[num.length()];
        for (int i = 0; i < arr.length; i++) {
            d = num.charAt(arr.length - i - 1) - 48;
            arr[i] = (i % 2 == 0 ? (d / 5 + d * 2 % 10) : d);
            if (i % 2 == 1) {
                arr[i] += d;
            } else {
                d *= 2;
                if (d >= 10) {
                    arr[i] += d / 10 + d % 10;
                } else {
                    arr[i] += d;
                }
            }
            sum += arr[i];
        }
        return (digit == 10 - sum % 10);
    }

    public static String numToEng(int n) {
        String s = "";
        int d = 100;
        if (n == 0) {
            return "zero";
        }
        while (n > 0) {
            switch (d == 10 ? n / d * 10 : n / d) {
                case 1:
                    s += "one ";
                    break;
                case 2:
                    s += "two ";
                    break;
                case 3:
                    s += "three ";
                    break;
                case 4:
                    s += "four ";
                    break;
                case 5:
                    s += "five ";
                    break;
                case 6:
                    s += "six ";
                    break;
                case 7:
                    s += "seven ";
                    break;
                case 8:
                    s += "eight ";
                    break;
                case 9:
                    s += "nine ";
                    break;
                case 10:
                    s += "ten ";
                    break;
                case 11:
                    s += "eleven ";
                    break;
                case 12:
                    s += "twelve ";
                    break;
                case 13:
                    s += "thirteen ";
                    break;
                case 14:
                    s += "fourteen ";
                    break;
                case 15:
                    s += "fifteen ";
                    break;
                case 16:
                    s += "sixteen ";
                    break;
                case 17:
                    s += "seventeen ";
                    break;
                case 18:
                    s += "eighteen ";
                    break;
                case 19:
                    s += "nineteen ";
                    break;
                case 20:
                    s += "twenty ";
                    break;
                case 30:
                    s += "thirty ";
                    break;
                case 40:
                    s += "forty ";
                    break;
                case 50:
                    s += "fifty ";
                    break;
                case 60:
                    s += "sixty ";
                    break;
                case 70:
                    s += "seventy ";
                    break;
                case 80:
                    s += "eighty ";
                    break;
                case 90:
                    s += "ninety ";
                    break;
            }
            if (n > 99) {
                s += "hundred ";
            }
            n %= d;
            d /= 10;
            if (n < 20) {
                d = 1;
            }
        }
        return s;
    }

    public static String getSha256Hash(String s) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(s.getBytes());
        byte[] hash = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : hash) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }

    public static String correctTitle(String str) {
        str = str.toLowerCase();
        int s = 0, e;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ' || str.length() - 1 == i) {
                e = i;
                switch (str.substring(s, e)) {
                    case "of":
                    case "the":
                    case "in":
                    case "and":
                        break;
                    default:
                        str = str.replace(str.substring(s, e),
                                str.substring(s, s + 1).toUpperCase() + str.substring(s + 1, e));
                        break;
                }
                s = e + 1;
            }
        }
        return str;
    }

    public static String hexLattice(int num) {
        if (num < 0) {
            return "Invalid";
        }
        int currentLine = 1;
        int i = 0;
        int step = 6;
        // Проверяем является ли число центрированным шестиугольным
        // находим количество итераций
        while (currentLine < num) {
            i++;
            currentLine += step * i;
        }
        if (currentLine == num) {
            String ans = "";
            int space = i;
            // Строки до центра включая
            for (int j = 0; j < i + 1; j++) {
                String line = "";
                line += " ".repeat(space - j);
                String middle = "";
                middle += "o ".repeat(i + 1 + j);
                middle = middle.strip();
                line += middle;
                line += " ".repeat(space - j) + "\n";
                ans += line;
            }
            // Строки от центра
            for (int j = i - 1; j >= 0; j--) {
                String line = "";
                line += " ".repeat(space - j);
                String middle = "";
                middle += "o ".repeat(i + 1 + j);
                middle = middle.strip();
                line += middle;
                line += " ".repeat(space - j) + "\n";
                ans += line;
            }
            return ans;
        } else {
            return "Invalid";
        }
    }
}