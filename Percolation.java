package Monte;

public class Percolation {
	private Site[][] sites;
	public Union union;
	private int N;
	public Percolation(int N){
		sites = new Site[N][N];
		for(int row=0;row<N;row++){
			for(int col=0;col<N;col++){
				sites[row][col] = new Site(row,col);
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
		sites[i][j].open();
		if(j-1>=0&&sites[i][j-1].isOpen()){
			union.union(N*i+j-1, N*i+j);
		}
		if(j+1<N&&sites[i][j+1].isOpen()){
			union.union(N*i+j+1, N*i+j);
		}
		if(i+1<N&&sites[i+1][j].isOpen()){
			union.union(N*(i+1)+j, N*i+j);
		}
		if(i-1>=0&&sites[i-1][j].isOpen()){
			union.union(N*(i-1)+j, N*i+j);
		}
	}
	public boolean isOpen(int i, int j){
		return sites[i][j].isOpen();
	}
	public boolean isFull(int i, int j){
		return union.connected(i*N+j, N*N);
	}
	public boolean percolates(){
		return union.connected(N*N, N*N+1);
	}
}
