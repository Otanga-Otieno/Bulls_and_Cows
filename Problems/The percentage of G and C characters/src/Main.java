import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int length = str.length(), count = 0;

        for (int i = 0; i < length; ++i) {
            char c = str.charAt(i);

            if (c == 'C' || c == 'c' || c == 'G' || c == 'g') {
                ++count;
            }

        }
        System.out.println(((double)count / length) * 100);
    }
}