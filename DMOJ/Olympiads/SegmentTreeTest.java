import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SegmentTreeTest {
    static Node[] seg;
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        seg = new Node[4*n+1];
        array = new int[4*n+1];
        input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            seg[i] = new Node();
            array[i] = Integer.parseInt(input[i-1]);
        }
        for (int i = n+1; i < seg.length; i++) {
            seg[i] = new Node();
        }

        build(1, n, 1);
        
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            if (input[0].equals("C")) {
                int pos = Integer.parseInt(input[1]);
                int value = Integer.parseInt(input[2]);
                array[pos] = value;
                update(pos, value, 1);
            } else if (input[0].equals("M")) {
                Node ansNode = query(Integer.parseInt(input[1]), Integer.parseInt(input[2]), 1);
                System.out.println(ansNode.min);
            } else {
                Node ansNode = query(Integer.parseInt(input[1]), Integer.parseInt(input[2]), 1);
                if (input[0].equals("G")) {
                    System.out.println(ansNode.gcd);
                } else {
                    System.out.println(ansNode.numSameGcd);
                }
            }
        }
    }

    public static void build (int left, int right, int num) {
        seg[num].l = left;
        seg[num].r = right;
        if (left == right) {
            seg[num].min = array[left];
            seg[num].gcd = array[left];
            seg[num].numSameGcd = 1;
            return;
        } else {
            int mid = (left + right)/2;
            build (left, mid, num*2);
            build (mid+1, right, num*2+1);
            
            seg[num].min = Math.min(seg[num*2].min, seg[num*2+1].min);
            seg[num].gcd = findGCD(seg[num*2].gcd, seg[num*2+1].gcd);
            seg[num].numSameGcd = 0;
            if (seg[num].gcd == seg[num*2].gcd) {
                seg[num].numSameGcd += seg[num*2].numSameGcd;
            }
            if (seg[num].gcd == seg[num*2+1].gcd) {
                seg[num].numSameGcd += seg[num*2+1].numSameGcd;
            }
            
        }
    }
    public static int findGCD (int x, int y) {
        while (x != 0 && y != 0) {
            if (x > y) {
                x = x % y;
            } else {
                y = y % x;
            }
        }
        
        if (x == 0) return y;
        else return x;
    }
    public static void update (int pos, int value, int num) { //change position pos to value value
        if (seg[num].l == pos && seg[num].r == pos) {
            seg[num].min = value;
            seg[num].gcd = value;
            seg[num].numSameGcd = 1;
            return;
        } else {
            int mid = (seg[num].l + seg[num].r)/2;
            if (pos <= mid) {
                update(pos, value, 2*num);
            } else {
                update(pos, value, 2*num+1);
            }

            seg[num].min = Math.min(seg[num*2].min, seg[num*2+1].min);
            seg[num].gcd = findGCD(seg[num*2].gcd, seg[num*2+1].gcd);
            seg[num].numSameGcd = 0;
            if (seg[num].gcd == seg[num*2].gcd) {
                seg[num].numSameGcd += seg[num*2].numSameGcd;
            }
            if (seg[num].gcd == seg[num*2+1].gcd) {
                seg[num].numSameGcd += seg[num*2+1].numSameGcd;
            }
        }
    }
    public static Node query(int left, int right, int num) {
        if (seg[num].l == left && seg[num].r == right) {
            return seg[num];
        } else {
            int mid = (seg[num].l + seg[num].r)/2;
            if (right <= mid) {
                return query(left, right, num*2);
            } else if (left > mid) {
                return query(left, right, num*2+1);
            } else { //query both
                Node leftQuery = query(left, mid, num*2);
                Node rightQuery = query(mid+1, right, num*2+1);
                Node ret = new Node(); //ret = return

                ret.min = Math.min(leftQuery.min, rightQuery.min);
                ret.gcd = findGCD(leftQuery.gcd, rightQuery.gcd);
                ret.numSameGcd = 0;
                if (ret.gcd == leftQuery.gcd) {
                    ret.numSameGcd += leftQuery.numSameGcd;
                }
                if (ret.gcd == rightQuery.gcd) {
                    ret.numSameGcd += rightQuery.numSameGcd;
                }
                return ret;
            }
        }
    }
}
class Node {
    int l, r, min, gcd;
    int numSameGcd;

    Node() {
        l = 0;
        r = 0;
        min = 0;
        gcd = 0; 
        numSameGcd = 1;
    }
}