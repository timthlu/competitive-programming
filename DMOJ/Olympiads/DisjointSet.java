import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class DisjointSet {
    static int[] ds;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Queue<Edge> q = new LinkedList();
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            q.add(new Edge(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        ds = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ds[i] = i;
        }

        while (!q.isEmpty()) {
            Edge curEdge = q.remove();
            int x = curEdge.u;
            int y = curEdge.v;

            union(x, y);
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(ds[i] + " ");
        }
    }

    static class Edge {
        int u;
        int v;

        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    public static int findLeader(int a) { //find with path compression
        while (ds[a] != a) {
            ds[a] = ds[ds[a]];
            a = ds[a];
        }
        return a;
    }

    public static void union(int a, int b) { //no path compression, since it's done in find method
        int leaderA = findLeader(a);
        int leaderB = findLeader(b);
        if (leaderA != leaderB) {
            ds[leaderA] = leaderB;
        }
    }
}