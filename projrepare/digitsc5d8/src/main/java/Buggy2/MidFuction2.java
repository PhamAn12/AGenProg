package Buggy2;

public class MidFuction2 {
    public java.util.Scanner scanner;
    public String output = "";

    public static void main (String[]args) throws Exception {
        MidFuction2 mainClass = new MidFuction2();
        String output;
        if (args.length > 0) {
            mainClass.scanner = new java.util.Scanner (args[0]);
        } else {
            mainClass.scanner = new java.util.Scanner (System.in);
        }
        mainClass.exec ();
        System.out.println (mainClass.output);
    }

    public void exec () throws Exception {
//        IntObj number = new IntObj (0), i = new IntObj (0), store =
//                new IntObj (0), state = new IntObj (1);
        int number = 0;
        int i = 0;
        int store = 0;
        int state = 1;
        output += (String.format ("\nEnter an integer > "));
        number = scanner.nextInt ();
        output += (String.format ("\n"));
        while (i < 9) {
            if (number < 0) {
                number = number * -1;
                state = -1;
            }
            store = number % 10;
            if (number <= 9) {
                store = number * state;
            }
            output += (String.format ("%d\n", store));
            number = number / 10;
            i++;
            if (number == 0) {
                output += (String.format ("That's all, have a nice day!\n"));
                break;
            }
        }
        if (true)
            return;;
    }
}
