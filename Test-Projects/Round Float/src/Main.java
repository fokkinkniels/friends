public class Main {
    public static void main(String[] args) {

        Test();
    }

    public static float Round(float input, int length){

        String bigNum = String.valueOf(input);
        String[] parts = bigNum.split("\\.");
        parts[1] = parts[1].substring(0, length);
        String smallNum = parts[0] +"."+ parts[1];
        return Float.parseFloat(smallNum);
    }

    public static void Test(){

        float unRounded = 192.1252521155f;
        int decimals = 3;
        float rounded = Round(unRounded, decimals);
        System.out.println(rounded);
    }
}
