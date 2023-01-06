public class Task6 {
    public static void main(String[] args) {
        System.out.println(bell(1));
        System.out.println(translateWord("flag"));
    }

    public static int bell(int n) {
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = 1;
        int k = 1;
        for (int i = 1; i < n; i++) {
            down[0] = up[k - 1];
            for (int j = 0; j < k; j++) {
                down[j + 1] = down[j] + up[j];
            }
            k++;
            for (int j = 0; j < k; j++) {
                up[j] = down[j];
            }
        }
        return up[up.length - 1];
    }

    public static String translateWord(String word) {
        if (word.length() == 0) {
            return "";
        }
        String translatedWord;
        int e = 0;
        boolean upcase = false;
        String[] letters = word.split("");
        for (int i = 0; i < word.length(); i++) {
            if ("[euioaAEUIO]".contains(letters[i])) {
                e = i;
                break;
            }
        }
        upcase = word.charAt(0) < 'a';
        String tmp = word.toLowerCase();
        if (e > 0) {
            translatedWord = upcase + "ay";
        } else {
            translatedWord = upcase + "yay";
        }
        return translatedWord;
    }
}