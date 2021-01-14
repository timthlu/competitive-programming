import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class RangeXorQuery {
    static Node[] seg;
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int q = Integer.parseInt(input[1]);

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
        
        for (int i = 0; i < q; i++) {
            input = br.readLine().split(" ");
            if (input[0].equals("1")) {
                int pos = Integer.parseInt(input[1]);
                int value = array[pos] ^ Integer.parseInt(input[2]);
                array[pos] = value;
                update(pos, value, 1);
            } else {
                Node ansNode = query(Integer.parseInt(input[1]), Integer.parseInt(input[2]), 1);
                System.out.println(ansNode.val);
            }
        }
    }

    public static void build (int left, int right, int num) {
        seg[num].l = left;
        seg[num].r = right;
        if (left == right) {
            seg[num].val = array[left];
            return;
        } else {
            int mid = (left + right)/2;
            build (left, mid, num*2);
            build (mid+1, right, num*2+1);
            
            seg[num].val = (seg[2*num].val) ^ (seg[2*num+1].val);
            
        }
    }
    public static void update (int pos, int value, int num) { //change position pos to value value
        if (seg[num].l == pos && seg[num].r == pos) {
            seg[num].val = value;
            return;
        } else {
            int mid = (seg[num].l + seg[num].r)/2;
            if (pos <= mid) {
                update(pos, value, 2*num);
            } else {
                update(pos, value, 2*num+1);
            }
			
			seg[num].val = (seg[2*num].val) ^ (seg[2*num+1].val);
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
                Node ret = new Node();
				
				ret.val = (leftQuery.val) ^ (rightQuery.val);
				
                return ret;
            }
        }
    }
}
class Node {
    int l, r, val;

    Node() {
        l = 0;
        r = 0;
        val = 0;
    }
}