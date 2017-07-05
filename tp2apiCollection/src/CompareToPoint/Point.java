package CompareToPoint;

public class Point implements Comparable<Point>{

	public int x,y;
	public Point(int x,int y){
	this.x=x;
	this.y=y;
	}
	@Override
	public int compareTo(Point p){
		if (this.x>p.x)	return 1;
		if (this.x<p.x) return -1;
		return 0;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}
