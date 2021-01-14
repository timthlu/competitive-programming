import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class BobsShoppingSpree {
	
	static int m;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		int k = Integer.parseInt(input[2]);
		
		Product[] prod = new Product[n+1];
		for (int i = 1; i <= n; i++) {
			input = br.readLine().split(" ");
			prod[i] = new Product(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}
		
		Deal[] deals = new Deal[m+1];
		for (int i = 1; i <= m; i++) {
			input = br.readLine().split(" ");
			deals[i] = new Deal(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3]));
		}
		
		State[][] dp = new State[n+m+1][k+1];
		for (int i = 0; i <= n+m; i++) {
			for (int j = 0; j <= k; j++) {
				dp[i][j] = new State();
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = k; j >= 0; j--) {
				//buy it if you have enough money
				if (j + prod[i].price <= k) {
					dp[i][j].sat = Math.max(dp[i][j].sat, dp[i][j + prod[i].price].sat + prod[i].sat);
				}
				
				//don't buy it
				dp[i][j].sat = Math.max(dp[i][j].sat, dp[i-1][j].sat);
			}
		}
		
		for (int i = 1; i <= m; i++) {
			for (int j = k; j >= 0; j--) {
				//buy it if you have enough money and limit not reached
				if (j + deals[i].price <= k && dp[i+n][j+deals[i].price].dealsUseCount[i] < deals[i].limit) {
					if (dp[i+n][j].sat < dp[i+n][j + deals[i].price].sat + prod[deals[i].typeItem].sat*deals[i].numItems) {
						dp[i+n][j].dealsUseCount = Arrays.copyOf(dp[i+n][j + deals[i].price].dealsUseCount, m+1);
						dp[i+n][j].sat = dp[i+n][j + deals[i].price].sat;
					}
				}
				
				//don't buy it
				if (dp[i+n][j].sat < dp[i+n-1][j].sat) {
					dp[i+n][j].dealsUseCount = Arrays.copyOf(dp[i+n-1][j].dealsUseCount, m+1);
					dp[i+n][j].sat = dp[i+n-1][j].sat;
				}
			}
		}
		
		for (int i = 1; i <= n+m; i++) {
			for (int j = 0; j <= k; j++) {
				System.out.print(dp[i][j].sat + " ");
			}
			System.out.println();
		}
		
	}
	static class Product {
		int price;
		int sat;
		
		public Product(int price, int sat) {
			this.price = price;
			this.sat = sat;
		}
	}
	
	static class Deal {
		int numItems;
		int typeItem;
		int price;
		int limit;
		
		public Deal(int numItems, int typeItem, int price, int limit) {
			this.numItems = numItems;
			this.typeItem = typeItem;
			this.price = price;
			this.limit = limit;
		}
	}
	
	static class State {
		int[] dealsUseCount = new int[m+1];
		int sat = 0;
	}
}