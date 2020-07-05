package Buggy2;
public class MidFuntion2 {
    public java.util.Scanner scanner;

    public java.lang.String output = "";

    public static void main(java.lang.String[] args) throws java.lang.Exception {
        Buggy2.MidFuntion2 mainClass = new Buggy2.MidFuntion2();
        java.lang.String output;
        if (args.length > 0) {
            mainClass.scanner = new java.util.Scanner(args[0]);
        } else {
            mainClass.scanner = new java.util.Scanner(java.lang.System.in);
        }
        mainClass.exec();
        java.lang.System.out.println(mainClass.output);
    }

    public void exec() throws java.lang.Exception {
        // IntObj number = new IntObj (0), i = new IntObj (0), store =
        // new IntObj (0), state = new IntObj (1);
        int number = 0;
        int i = 0;
        int store = 0;
        int state = 1;
        output += java.lang.String.format("\nEnter an integer > ");
        number = scanner.nextInt();
        output += java.lang.String.format("\n");
        while (i < 9) {
            if (number < 0) {
                number = number * (-1);
                state = -1;
            }
            store = number % 10;
            if (number <= 9) {
                store = number * state;
            }
            output += java.lang.String.format("%d\n", store);
            number = number / 10;
            i++;
            if (number == 0) {
                output += java.lang.String.format("That\'s all, have a nice day!\n");
                break;
            }
        } 
        if (true)
            return;

    }
}