import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HolyGrailWar {
    static Node[] seg;
    static int[] a;
    public static void main(String[] args) throws IOException {
        //dp maximum sum in a range, segment tree to handle changes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int q = Integer.parseInt(input[1]);
        a = new int[n+1];
        seg = new Node[4*(n+5)+1];

        input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(input[i-1]);
            seg[i] = new Node();
        }
        for (int i = n+1; i < seg.length; i++) {
            seg[i] = new Node();
        }

        build (1, n, 1);

        for (int i = 0; i < q; i++) {
            input = br.readLine().split(" ");
            if (input[0].equals("S")) {
                update(Integer.parseInt(input[1]), Integer.parseInt(input[2]), 1);
                a[Integer.parseInt(input[1])] = Integer.parseInt(input[2]);
            } else {
                Node returnedNode = query(Integer.parseInt(input[1]), Integer.parseInt(input[2]), 1);
                System.out.println(returnedNode.ans);
            }
        }
    }
    public static void build (int l, int r, int num) {
        seg[num].left = l;
        seg[num].right = r;
        if (l == r) {
            seg[num].prefix = a[l];
            seg[num].suffix = a[l];
            seg[num].ans = a[l];
            seg[num].sum = a[l]; 
            return;
        } else {
            int mid = (l + r)/2;
            build (l, mid, num*2);
            build (mid+1, r, num*2+1);
            
            seg[num].prefix = Math.max(seg[num*2].prefix, seg[num*2].sum + seg[num*2+1].prefix);
            seg[num].suffix = Math.max(seg[num*2+1].suffix, seg[num*2+1].sum + seg[num*2].suffix);
            seg[num].ans = Math.max(seg[num*2].suffix + seg[num*2+1].prefix, Math.max(seg[num*2].ans, seg[num*2+1].ans));
            seg[num].sum = seg[num*2].sum + seg[num*2+1].sum;
        }
    }
    public static void update (int pos, int value, int num) {
        if (seg[num].left == pos && seg[num].right == pos) {
            seg[num].prefix = value;
            seg[num].suffix = value;
            seg[num].ans = value;
            seg[num].sum = value;
            return;
        } else {
            int mid = (seg[num].left + seg[num].right)/2;
            if (pos <= mid) {
                update(pos, value, 2*num);
            } else {
                update(pos, value, 2*num+1);
            }

            seg[num].prefix = Math.max(seg[num*2].prefix, seg[num*2].sum + seg[num*2+1].prefix);
            seg[num].suffix = Math.max(seg[num*2+1].suffix, seg[num*2+1].sum + seg[num*2].suffix);
            seg[num].ans = Math.max(seg[num*2].suffix + seg[num*2+1].prefix, Math.max(seg[num*2].ans, seg[num*2+1].ans));
            seg[num].sum = seg[num*2].sum + seg[num*2+1].sum;
        }
    }
    public static Node query(int l, int r, int num) {
        if (seg[num].left == l && seg[num].right == r) {
            return seg[num];
        } else {
            int mid = (seg[num].left + seg[num].right)/2;
            if (r <= mid) {
                return query(l, r, num*2);
            } else if (l > mid) {
                return query(l, r, num*2+1);
            } else { //query both
                Node leftQuery = query(l, mid, num*2);
                Node rightQuery = query(mid+1, r, num*2+1);
                Node ret = new Node(); //ret = return

                ret.prefix = Math.max(leftQuery.prefix, leftQuery.sum + rightQuery.prefix);
                ret.suffix = Math.max(rightQuery.suffix, rightQuery.sum + leftQuery.suffix);
                ret.ans = Math.max(leftQuery.suffix + rightQuery.prefix, Math.max(leftQuery.ans, rightQuery.ans));
                ret.sum = leftQuery.sum + rightQuery.sum;

                return ret;
            }
        }
    }
    static class Node {
        int left;
        int right;
        long prefix;
        long suffix;
        long ans;
        long sum;
    
        Node() {
            left = 0;
            right = 0;
            prefix = 0;
            suffix = 0;
            ans = 0;
            sum = 0;
        }
    }
}