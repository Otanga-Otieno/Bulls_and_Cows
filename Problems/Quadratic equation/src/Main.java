import java.util.Scanner;

class Main {

    static double root1(double a, double b, double c) {
        double root1 = ((b * -1) - Math.sqrt((b * b) - (4 * a * c)))/(2 * a);
        return root1;
    }

    static double root2(double a, double b, double c) {
        double root2 = ((b * -1) + Math.sqrt((b * b) - (4 * a  * c)))/(2 * a);
        return root2;
    }

    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double root1 = root1(a, b, c);
        double root2 = root2(a, b, c);

        System.out.println( Math.min(root1, root2) + " " + Math.max(root1, root2));

    }
}