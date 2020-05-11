package Buggy2;

public class MidFuction2 {
    public int findMid(int a, int b) {
        int r;
        if(a == 0) {
            System.out.print(b);
            r = b;
            r = r + 1;
            r = r + 3;
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
