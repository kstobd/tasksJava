public class taks2Prag{
    public static void main(String[] args) {
        System.out.println(getDecimalPlaces("43.0120"));
    }
    public static int getDecimalPlaces(String str){
        String[] rezStr = str.split("\\.");
        if (rezStr.length == 1){
            return 0;
        }
        return rezStr[1].length();
    }
}