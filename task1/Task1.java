public class Task1 {
    public static void main(String[] args){
        System.out.println(remainder(1, 3));
        System.out.println(triArea(3, 2));
        System.out.println(animals(2, 3, 5));
        System.out.println(profitableGamble(0.2, 50, 9));
        System.out.println(operation(24, 15, 9));
        System.out.println(ctoa('A'));
        System.out.println(addUpTo(3));
        System.out.println(nextEdge(8, 10));
        System.out.println(sumOfCubes(new int[] { 1, 5, 9 }));
        System.out.println(abcmath(42, 5, 10));
    }
    public static int remainder(int a, int b){
        return a % b;
    }
    public static double triArea(int a, int b){
        return 0.5 * a * b; 
    }
    public static int animals(int chickens, int cows, int pigs){
        return chickens * 2 + cows * 4 + pigs * 4; 
    }
    public static boolean profitableGamble(Double prob, int prize, int pay){
        return prob * prize > pay; 
    }
    public static String operation(int a, int b, int c){
        String rez = "";
        if ((b + c) == a) {
            rez = "added";
        }else if ((b + c) == a){
            rez = "subtracted";
        }else if ((b + c) == a){
            rez = "subtracted";
        }else if ((b + c) == a){
            rez = "subtracted";
        }else{
            rez = "None";
        }
        return rez; 
    }
    public static int ctoa(char s){
        return (int) s; 
    }
    public static int addUpTo(int n){
        return (1 + n) * n / 2; 
    }
    public static int nextEdge(int a, int b){
        return (a + b - 1); 
    }
    public static int sumOfCubes(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] * arr[i] * arr[i];
        }
        return sum;
    }
    public static boolean abcmath(int a, int b, int c) {
        int sum = a;
        for (int i = 0; i < b; i++) {
            sum += sum;
        }
        if (sum % c == 0){
            return true;
        }else{
            return false;
        } 
    }
}