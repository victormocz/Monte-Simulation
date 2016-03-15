package Monte;

public class Union {
	private int[] data;
	private int[] size;
	
	public Union(int N){
		data = new int[N];
		size = new int[N];
		for(int i=0;i<data.length;i++){
			data[i] = i;
			size[i] = 1;
		}
	}
	
	public boolean connected(int node1,int node2){
		return root(node1)==root(node2);
	} 
	public int root(int num){
		while(num!=data[num]){
			data[num] = data[data[num]];
			num = data[num];
		}
		return num;
	}
	public void union(int node1,int node2){
		int root1 = root(node1);
		int root2 = root(node2);
		if(size[root1]>=size[root2]){
			data[root2] = data[root1];
			size[root1]+=size[root2];
		}else{
			data[root1] = data[root2];
			size[root2]+= size[root1];
		}
	}
	public void info(){
		for(int i:data){
			System.out.print(i+" ");
		}
	}
}
