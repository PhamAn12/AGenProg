package Buggy2;
public class MidFuction2 {
    public int findMid(int a, int b) {
        int r;
        if (a == 0) {
            java.lang.System.out.print(b);
            r = b;
            r = r + 1;
            return r;
            return r;
        }
        while (b != 0) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        } 
        java.lang.System.out.print(b);
        r = a;
        return r;
    }
}