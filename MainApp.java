package Monte;

public class MainApp {
	public static void main(String[] args){
		Percolation test = new Percolation(4);
		test.open(0, 0);
		test.open(1, 0);
		test.open(2, 0);
		test.open(3, 0);
		test.union.info();
	}
}
