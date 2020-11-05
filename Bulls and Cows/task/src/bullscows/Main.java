package bullscows;

import java.util.*;

public class Main {

    static void play(String secret) {
        Scanner scanner = new Scanner(System.in);
        int turns = 1;

        gameloop: while (true) {

            System.out.printf("Turn %d: \n", turns);
            System.out.println();
            String input = scanner.next();
            grader(secret, input);

            if (secret.equals(input)) {
                System.out.println("Congratulations! You guessed the secret code.");
                break gameloop;
            }
            ++turns;
        }


    }

    static String generateRandom(int n, int m) {
        boolean bool = true;
        ArrayList<Character> rands = new ArrayList<Character>();
        char[] possibles = new char[m];
        StringBuilder sb = new StringBuilder();
        Random r = new Random();

        int j = 0;
        for (int i = 0; i < m; ++i) {
            possibles[i] = (char) (j+48);
            if (i == 9) {
                j += 39;
            }
            ++j;
        }

        loop: while (bool) {
            int random = r.nextInt(m);

            char c = possibles[random];
                if (!(rands.contains(c))) {
                    rands.add(c);
                    if (rands.size() == n) {
                        break loop;
                    }
                }
            }
        return parse(rands);
    }

    static String parse(ArrayList<Character> list) {
        char[] arr = new char[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            arr[i] = list.get(i);
        }
        return String.valueOf(arr);
    }


    public static void grader(String secret, String number) {
        char[] arr = secret.toCharArray();
        ArrayList<Character> code = new ArrayList<>();
        for (char c: arr) {
            code.add(c);
        }

        int cow = 0, bull = 0;

        for (int i =0; i < code.size(); ++i) {
            if (code.contains(number.charAt(i))) {
                ++cow;
            }
        }

        for (int i = 0; i < code.size(); ++i) {
            if (code.get(i) == number.charAt(i) ) {
                ++bull;
            }
        }

        cow -= bull;
        if (cow == 0) {
            if (bull == 0) {
                System.out.printf("Grade: None.");
            }
            if (bull > 0) {
                System.out.printf("Grade: %s", graderParser(bull, "bulls"));
            }
        } else if (bull == 0) {
            if (cow > 0) {
                System.out.printf("Grade: %s", graderParser(cow, "cows"));
            }
        } else {
            System.out.printf("Grade: %s and %s", graderParser(bull, "bulls"), graderParser(cow, "cows"));
        }


    }

    static String graderParser (int a, String s) {
        StringBuilder sb = new StringBuilder(s);
        if (a == 1) {
            return "1 " + sb.deleteCharAt(sb.length()-1).toString();
        } else {
            return String.valueOf(a) + " " + s;
        }
    }

    static void prepSecret(int m, int n) {
        StringBuilder asterisks = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            asterisks.append("*");
        }
        String ast = asterisks.toString();

        if (m < 11) {
            System.out.printf("The secret is prepared: %s (0-%d). \n", ast, m - 1);
        } else if (m == 11) {
            System.out.printf("The secret is prepared: %s (0-9, a). \n", ast);
        } else {
            int end = m + 86;
            char c = (char) end;
            System.out.printf("The secret is prepared: %s (0-9, a-%c). \n", ast, c);
        }
    }

    static int isNumeric(String s) {
        try {
            int number = Integer.parseInt(s);
            return number;
        } catch (Exception e) {
            System.out.printf("Error: \"%s\" isn't a valid number. \n", s);
            System.exit(-1);
            return -1;
        }
    }

    static void start() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the length of secret code:");
        int n = isNumeric(scanner.next());

        System.out.println("Input the number of possible symbols in the code:");
        int m = isNumeric(scanner.next());

        String secret = "";
        if (m > 36 ) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
        } else if (n < 1) {
            System.out.println("Error: minimum length of secret code is 1");
        } else if (n > m) {
            System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols. \n", n, m);
        } else if (m < 0) {
            System.out.println("Error: minimum number of possible symbols in the code is 1");
        } else {
            secret = generateRandom(n, m);
            prepSecret(m, n);
            play(secret);
        }
    }

    public static void main(String[] args) {

        start();

        /*System.out.println("The secret code is prepared: ****");
        System.out.printf("Turn 1. Answer: \n%d \nGrade: 1 cow\n", 1578);
        System.out.println();
        System.out.printf("Turn 2. Answer: \n%d \nGrade: 4 bulls \nCongrats! The secret code is 2659", 2659);
    */
    }

}
