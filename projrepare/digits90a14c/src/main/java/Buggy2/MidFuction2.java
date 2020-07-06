package Buggy2;
public class MidFuction2 {
    public java.util.Scanner scanner;

    public java.lang.String output = "";

    public static void main(java.lang.String[] args) throws java.lang.Exception {
        Buggy2.MidFuction2 mainClass = new Buggy2.MidFuction2();
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
        // IntObj value = new IntObj(), digit = new IntObj();
        int value;
        int digit;
        output += java.lang.String.format("\nEnter an integer > ");
        value = scanner.nextInt();
        output += java.lang.String.format("\n");
        if (value > 0) {
            while (value != 0) {
                digit = value % 10;
                value = value / 10;
                output += java.lang.String.format("%d\n", digit);
            }
        } else
        if (value < 0) {
            while (value < (-10)) {
                digit = java.lang.Math.abs(value % 10);
                value = value / 10;
                output += java.lang.String.format("%d\n", digit);
            }
            while (value != 0) {
                digit = value % 10;
                value = value / 10;
                output += java.lang.String.format("%d\n", digit);
            }
        } else
        if (value == 0) {
            digit = 0;
            output += java.lang.String.format("%d\n", digit);
        }


        output += java.lang.String.format("That\'s all, have a nice day!\n");
        if (true)
            return;

    }
}