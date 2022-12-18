import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    public static void main(String[] args) {
        for (String string : task1(10, 7, "hello my name is Bessie and this is my essay")) {
            if (string != "") {
                System.out.println(string);
            }
        }
        System.out.println(bracket("((()))(())()()(()())"));
        System.out.println(toSnakeCase("helloEdabit"));
        System.out.println(toCamelCase("hello_edabit"));
        System.out.println(overTime(16.00, 18.00, 30.00, 1.8));
        System.out.println(bugger(39));
        System.out.println(toStarShorthand("77777geff"));
        System.out.println(doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println(trouble(451999277, 41177722899L));
        System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A'));
    }

    public static String[] task1(int n, int k, String str) {
        String[] arrStr = str.split(" ");
        String[] rez = new String[str.length() / k + 1];
        Arrays.fill(rez, "");
        int cRez = 0;
        rez[cRez] += arrStr[0];
        int left = k - arrStr[0].length();
        for (int i = 1; i < arrStr.length; i++) {
            if (left >= arrStr[i].length()) {
                rez[cRez] += " " + arrStr[i];
                left -= arrStr[i].length() + 1;
            } else {
                cRez += 1;
                rez[cRez] = arrStr[i];
                left = k - arrStr[i].length();
            }
        }
        return rez;
    }

    public static ArrayList<String> bracket(String str) {
        ArrayList<String> rez = new ArrayList<>();
        String[] arrStr = str.split("");
        String tmp = "";
        int count = 0;
        for (String brac : arrStr) {
            if (brac.charAt(0) == '(') {
                count += 1;
            } else {
                count -= 1;
            }
            tmp += brac;
            if (count == 0) {
                rez.add(tmp);
                tmp = "";
            }
        }
        return rez;
    }

    public static String toSnakeCase(String str) {
        str += " ";
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (Character.isUpperCase(arr[i])) {
                arr[i] = Character.toLowerCase(arr[i]);
                for (int j = arr.length; j > i + 1; j--) {
                    arr[j - 1] = arr[j - 2];
                }
                arr[i] = '_';
                break;
            }
        }
        String rez = new String(arr);
        return rez;
    }

    public static String toCamelCase(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '_') {
                arr[i + 1] = Character.toUpperCase(arr[i + 1]);
                arr[i] = 0;
            }
        }
        String rez = new String(arr);
        return rez;
    }

    public static Double overTime(Double start, Double finish, Double cash, Double multi) {
        if (finish <= 17) {
            return (finish - start) * cash;
        } else {
            return ((17 - start) * cash) + ((finish - 17) * cash * multi);
        }
    }

    public static int bugger(int n) {
        int tmp = 1;
        int count = 0;
        while (String.valueOf(n).length() != 1) {
            while (n > 0) {
                tmp *= n % 10;
                n = n / 10;
            }
            count += 1;
            n = tmp;
            tmp = 1;
        }
        return count;
    }

    public static String toStarShorthand(String str) {
        // str = str.replaceAll("([a-z])\\1+", "*");
        // return str;
        String replStr;
        Matcher m = Pattern.compile("(.)\\1+").matcher(str);
        while (m.find()) {
            String sub = m.group();
            replStr = String.valueOf(sub.toCharArray()[0]) + "*" + sub.length();
            str = str.replaceAll(sub, replStr);
        }
        return str;
    }

    public static boolean doesRhyme(String str1, String str2) {
        str1 = str1.replaceAll("[^A-Za-zА-Яа-я0-9\\s]", "");
        str2 = str2.replaceAll("[^A-Za-zА-Яа-я0-9\\s]", "");
        String[] arrStr1 = str1.split(" ");
        String[] arrStr2 = str2.split(" ");
        String lastWord1 = arrStr1[arrStr1.length - 1].replaceAll(
                "[^AEIOUaeiou]", "");
        String lastWord2 = arrStr2[arrStr2.length - 1].replaceAll(
                "[^AEIOUaeiou]", "");
        char[] arr1 = lastWord1.toCharArray();
        char[] arr2 = lastWord2.toCharArray();
        Set<Character> set1 = new HashSet<Character>();
        for (Character character : arr1) {
            set1.add(character);
        }
        Set<Character> set2 = new HashSet<Character>();
        for (Character character : arr2) {
            set2.add(character);
        }
        return set1.equals(set2);
    }


    public static boolean trouble(long a, long b) {
        String strA = String.valueOf(a) + " ";
        char[] arrA = strA.toCharArray();
        Set<Character> set1 = new HashSet<Character>();
        for (int i = 0; i < arrA.length-3; i++) {
            if ((arrA[i] == arrA[i + 1]) & (arrA[i + 1] == arrA[i + 2]) & (arrA[i] == arrA[i + 2])
                    & (arrA[i] != arrA[i + 3])) {
                set1.add(arrA[i]);
            }
        }

        String strB = String.valueOf(b) + " ";
        char[] arrB = strB.toCharArray();
        for (int i = 0; i < arrB.length-2; i++) {
            if ((arrB[i] == arrB[i + 1]) & (arrB[i] != arrB[i + 2])) {
                if (set1.contains(arrB[i])){
                    return true;
                }
            }
        }
        return false;
    }

    public static int countUniqueBooks(String stringSequence, char bookEnd){
        boolean flag = false;
        boolean startFlag = true;
        int count = 0;
        int max = 0;
        for (char ch : stringSequence.toCharArray()) {
            if (flag == true){
                count += 1;
            } else {
                count = 0;
            }
            if ((ch == bookEnd) & (startFlag == true)) {
                flag = true;
                startFlag = false;
            } else if ((ch == bookEnd) & (startFlag == false)){
                startFlag = true;
                flag = false;
            }
            if (count > max){
                max = count;
            }
        }
        return max;
    }

}