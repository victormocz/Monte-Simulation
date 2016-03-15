package Monte;

public class Site {
	private int row;
	private int col;
	private boolean status = false;
	public Site(int row,int col){
		this.row = row;
		this.col = col;
	}
	public void open(){
		status = true;
	}
	public void close(){
		status = false;
	}
	public boolean isOpen(){
		return status;
	}
}
