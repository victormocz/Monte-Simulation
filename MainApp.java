package Monte;

public class MainApp {
	public static void main(String[] args){
		Union test = new Union(10);
		test.union(0, 1);
		test.union(1, 2);
		System.out.println(test.connected(0, 3));
	}
}
