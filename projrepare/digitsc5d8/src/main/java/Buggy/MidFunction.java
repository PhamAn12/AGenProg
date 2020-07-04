package Buggy;

public class MidFunction {
    public int findMid(int a, int b) {
        int r;
        if(a == 0) {
            System.out.print(b);
            r = b;
            return r;
        }
        while(b != 0) {
            if (a > b) {
                a = a - b;
            }
            else {
                b = b - a;
            }
        }
        System.out.print(b);
        r = a;
        return r;
    }
}
