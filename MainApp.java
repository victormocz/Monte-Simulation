package Monte;

import java.util.Random;
import edu.princeton.cs.algs4.StdDraw;

public class MainApp {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int T = Integer.parseInt(args[1]);
		PercolationStats test = new PercolationStats(N,T);
		System.out.println("mean\t\t\t\t= "+test.mean());
		System.out.println("stddev\t\t\t\t= "+test.stddev());
		System.out.println("95% confidence interval\t\t= "+test.confidenceLo()+", "+test.confidenceHi());
	}
}
