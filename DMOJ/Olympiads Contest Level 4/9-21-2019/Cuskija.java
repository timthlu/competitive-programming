import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Cuskija {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        ArrayList<Integer> m0 = new ArrayList<Integer>();
        ArrayList<Integer> m1 = new ArrayList<Integer>();
        ArrayList<Integer> m2 = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int mod = Integer.parseInt(input[i]) % 3;
            if (mod == 0) {
                m0.add(Integer.parseInt(input[i]));
            } else if (mod == 1) {
                m1.add(Integer.parseInt(input[i]));
            } else {
                m2.add(Integer.parseInt(input[i]));
            }
        }

        int mod0 = m0.size();
        int mod1 = m1.size();
        int mod2 = m2.size();
        if (mod0 > mod1 + mod2 + 1) System.out.println("impossible");
        else if (mod0 == 0 && mod1 > 0 && mod2 > 0) System.out.println("impossible");
        else {
            if (mod0 > mod1 + mod2) {
                String ans = "";
                for (int i = 0; i < mod1; i++) {
                    ans += m0.get(i) + " " + m1.get(i) + " ";
                }
                for (int i = 0; i < mod2; i++) {
                    ans += m0.get(i) + " " + m2.get(i) + " ";
                }
                ans += m0.get(m0.size()-1);
                System.out.println(ans);
            } else {
                String ans = "";
                for (int i = 0; i < mod1; i++) {
                    ans += m1.get(i) + " ";
                    if (mod0 > 1) {
                        ans += m0.get(m0.size()-mod0) + " ";
                        mod0--;
                    }
                }
                
                if (mod0 != 0) {
                    ans += m0.get(m0.size()-mod0) + " ";
                    mod0--;
                }

                for (int i = 0; i < mod2; i++) {
                    ans += m2.get(i) + " ";
                    if (mod0 > 0) {
                        ans += m0.get(m0.size()-mod0) + " ";
                        mod0--;
                    }
                }
                System.out.println(ans.trim());
            }
        }
    }
}