import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int n = scanner.nextInt();
        char[] arr = str.toCharArray();
        char[] val = new char[arr.length];
        int v = 0;

        if (n <= str.length()) {
            for (int i = n; i < str.length(); ++i) {
                val[v] = str.charAt(i);
                ++v;
            }
            for (int i = 0; i < n; ++i) {
                val[v] = str.charAt(i);
                ++v;
            }
            System.out.println(String.valueOf(val));
        } else {
            System.out.println(str);
        }

    }
}