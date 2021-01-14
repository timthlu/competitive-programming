import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class ChristmasGifts {
    public static void main(String[] args) throws IOException {
        
    }
    static class Pair implements Comparable<Pair> {
        long x, y, s;
        public Pair(int a, int b) {
            x = a;
            y = b;
            s = a + b;
        }
        public int compareTo(Pair o) {
            if (this.s > o.s) {
                return 1;
            } else if (this.s == o.s) {
                return 0;
            } else {
                return -1;
            }
        }
    }
}