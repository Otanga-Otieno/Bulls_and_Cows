import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int sum1 = 0, sum2 = 0;

        for (int i = 0; i < str.length()/2; ++i) {
            char c = str.charAt(i);
            int val = Character.getNumericValue(c);
            sum1 += val;
        }

        for (int i = str.length()/2; i < str.length(); ++i) {
            char c = str.charAt(i);
            int val = Character.getNumericValue(c);
            sum2 += val;
        }

        if (sum1 == sum2) {
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }

    }
}