import java.util.Random;

public class PercolationStats {
	private Percolation percolation;
	private double[] result;
	private double mean=-1.0;
	private double stddev=-1.0;
	public PercolationStats(int N, int T){
		if(N<=0||T<=0){
			throw new IllegalArgumentException();
		}
		Random rd = new Random();
		result = new double[T];
		for(int i=0;i<result.length;i++){
			int count=0;
			percolation = new Percolation(N);
			while(!percolation.percolates()){
				int col = rd.nextInt(N);
				int row = rd.nextInt(N);
				if(!percolation.isOpen(row, col)){
					percolation.open(row, col);
					count++;
				}
			}
			result[i] = (double)count/((double)N*N);
		}
		double all=0;
		for(int i=0;i<result.length;i++){
			all+=result[i];
		}
		this.mean = result.length!=0?all/result.length:0.0;

		double stdev = 0.0;
		for(int i=0;i<result.length;i++){
			stdev+= (result[i]-mean)*(result[i]-mean);
		}
		stdev/=(result.length-1);
		this.stddev = Math.sqrt(stdev);
	}
	public double mean(){
		return this.mean;
	}
	public double stddev(){
		return this.stddev;
	}
	public double confidenceLo(){
		return this.mean-1.96*this.stddev/Math.sqrt(result.length);
	}
	public double confidenceHi(){
		return this.mean+1.96*this.stddev/Math.sqrt(result.length);
	}

	public static void main(String[] args){
		int N = Integer.parseInt(args[0]);
		int T = Integer.parseInt(args[1]);
		PercolationStats test = new PercolationStats(N,T);
		System.out.println("mean\t\t\t\t= "+test.mean());
		System.out.println("stddev\t\t\t\t= "+test.stddev());
		System.out.println("95% confidence interval\t\t= "+test.confidenceLo()+", "+test.confidenceHi());
	}
}
