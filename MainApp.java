package Monte;

import java.util.Random;
import edu.princeton.cs.algs4.StdDraw;

public class MainApp {
	public static void main(String[] args) {
		int N = 20;
		double p = 20.0;
		int M = 20;

		// repeatedly created N-by-N matrices and display them using standard
		// draw
		for (int i = 0; i < M; i++) {
			//boolean[][] open = Percolation.random(N, p);
			StdDraw.clear();
			StdDraw.setPenColor(StdDraw.BLACK);
			
			StdDraw.setPenColor(StdDraw.GRAY);
			//boolean[][] full = Percolation.flow(open);
			
			StdDraw.show(1000);
		}
	}
}
