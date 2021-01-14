import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Sirtet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        String[][] map = new String[rows+1][cols];
        for (int i = 0; i < rows; i++) {
            String input2 = br.readLine();
            for (int j = 0; j < cols; j++) {
                map[i][j] = input2.substring(j, j+1);
            }
        }

        int count = 1;
        Queue<Pos> q = new LinkedList();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (map[i][j].equals("#")) {
                    q.add(new Pos(i, j));
                    map[i][j] = Integer.toString(count);
                    while (!q.isEmpty()) {
                        Pos curPos = q.remove();
                        int curRow = curPos.row;
                        int curCol = curPos.col;

                        if (curRow != 0 && map[curRow-1][curCol].equals("#")) { //north
                            map[curRow-1][curCol] = Integer.toString(count);
                            q.add(new Pos(curRow-1, curCol));
                        }

                        if (curRow != rows-1 && map[curRow+1][curCol].equals("#")) { //south
                            map[curRow+1][curCol] = Integer.toString(count);
                            q.add(new Pos(curRow+1, curCol));
                        }

                        if (curCol != 0 && map[curRow][curCol-1].equals("#")) { //west
                            map[curRow][curCol-1] = Integer.toString(count);
                            q.add(new Pos(curRow, curCol-1));
                        }

                        if (curCol != cols-1 && map[curRow][curCol+1].equals("#")) { //east
                            map[curRow][curCol+1] = Integer.toString(count);
                            q.add(new Pos(curRow, curCol+1));
                        }
                    }

                    count++;
                }
            }
        }

        for (int i = 0; i < cols; i++) {
            map[rows][i] = Integer.toString(count);
        }

        int[][] adj = new int[count+1][count+1];
        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= count; j++) {
                if (i == j) {
                    adj[i][j] = 0;
                } else {
                    adj[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        for (int i = 0; i < rows+1; i++) {
            for (int j = 0; j < cols; j++) {
                if (!map[i][j].equals(".")) {
                    int num1 = Integer.parseInt(map[i][j]);
                    for (int k = i+1; k <= rows; k++) {
                        if (!map[k][j].equals(".")) {
                            int num2 = Integer.parseInt(map[k][j]);
                            adj[num2][num1] = Math.min(adj[num2][num1], k-i-1);
                        }
                    }
                }
            }
        }

        //djikstra's
        PriorityQueue<Node> pq = new PriorityQueue();
        int[] dis = new int[count+1];
        boolean[] vis = new boolean[count+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[count] = 0;
        pq.add(new Node(count, 0));

        while(!checkIfAllVisited(vis)) {
            Node curNode = pq.remove();
            int curNum = curNode.u;
            int curDis = curNode.d;

            for (int i = 1; i <= count; i++) {
                if (!vis[i] && curNum != i && adj[curNum][i] != Integer.MAX_VALUE && adj[curNum][i] + curDis < dis[i]) {
                    dis[i] = adj[curNum][i] + curDis;
                    pq.add(new Node(i, dis[i]));
                }
            }

            vis[curNum] = true;
        }

        for (int i = rows-1; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                if (!map[i][j].equals(".")) {
                    int num = Integer.parseInt(map[i][j]);
                    map[i+dis[num]][j] = "#";
                    if (dis[num] != 0) {
                        map[i][j] = ".";
                    }
                }
            }
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }
    public static boolean checkIfAllVisited(boolean[] vis) {
        for (int i = 1; i < vis.length; i++) {
            if (!vis[i]) {
                return false;
            }
        }

        return true;
    }
    static class Pos {
        int row, col;

        public Pos (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    static class Node implements Comparable<Node> {
        int u, d;

        public Node (int u, int d) {
            this.u = u;
            this.d = d;
        }

        public int compareTo(Node n) {
            return (d - n.d);
        }
    }
}