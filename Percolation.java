package Monte;

public class Percolation {
	private boolean[][] sites;
	private Union union;
	private int N;
	public Percolation(int N){
		if(N<=0){
			throw new IllegalArgumentException();
		}
		sites = new boolean[N][N];
		for(int row=0;row<N;row++){
			for(int col=0;col<N;col++){
				sites[row][col] = false;
			}
		}
		this.N = N;
		union = new Union(N*N+2);
		for(int i=0;i<N;i++){
			union.union( N*N,i);
			union.union(N*N+1,(N-1)*N+i);
		}
	}
	public void open(int i, int j){
		i--;
		j--;
		check(i,j);
		sites[i][j]= true;
		if(j-1>=0&&sites[i][j-1]){
			union.union(N*i+j-1, N*i+j);
		}
		if(j+1<N&&sites[i][j+1]){
			union.union(N*i+j+1, N*i+j);
		}
		if(i+1<N&&sites[i+1][j]){
			union.union(N*(i+1)+j, N*i+j);
		}
		if(i-1>=0&&sites[i-1][j]){
			union.union(N*(i-1)+j, N*i+j);
		}
	}
	public boolean isOpen(int i, int j){
		i--;
		j--;
		check(i,j);
		return sites[i][j];
	}
	public boolean isFull(int i, int j){
		i--;
		j--;
		check(i,j);
		return union.connected(i*N+j, N*N)&&isOpen(i,j);
	}
	public boolean percolates(){
		return union.connected(N*N, N*N+1);
	}
	private void check(int i,int j){
		if(i<0||i>=N){
			throw new IndexOutOfBoundsException("outofbound");
		}
	}
}
