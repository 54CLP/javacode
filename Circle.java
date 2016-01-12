public class Circle{
	private int r;
	//构造函数
	public Circle(int r){
		this.r=r;
	}
	//方法函数
	public void Paint(){
		int y=2*r;
		int gap=0;
		int x=0;
		int z=1;//增量
		for(int i=y;i>=0;i-=2){
			x=getX(r,y);
			System.out.print(getSpace(x)+"*");
			gap=(r-x)*2;
			System.out.println(getSpace(gap)+"*");
			y-=z;
		}
		//计算x坐标
	private int getX(int r,int y){
		double temp=Math.sqrt(r*r-(r-y)*(r-y));
		int x=(int)Math.round(r-temp);
		return x;
	}
	private String getSpace(int c){
		String space=" ";
		for(int i=0;i<c;i++){
			space+=" ";
		}
		return space;
	}
	public static void main(String[]args){
		new Circle(5
).Paint();
	}
}