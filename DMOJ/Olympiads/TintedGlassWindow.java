import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TintedGlassWindow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int q = Integer.parseInt(br.readLine());

        ArrayList<Pos> all = new ArrayList<Pos>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            int d = Integer.parseInt(input[3]);
            int e = Integer.parseInt(input[4]);


        }

        
    }
    static class Pos {
        int row, col;
        int tint;
        boolean start;

        Pos (int a, int b, int c, boolean d) {
            row = a;
            col = b;
            tint = c;
            start = d;
        }
    }
}