package Monte;

public class Site {
	private int x;
	private int y;
	private boolean status = false;
	public Site(int x,int y){
		this.x = x;
		this.y = y;
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
