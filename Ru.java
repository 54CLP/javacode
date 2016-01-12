class Mythread extends Thread{
	private int count=5;
	@Override
	synchronized public void run(){
		super.run();
		count--;
		System.out.println("you "+this.currentThread().getName()+"jisuan,count="+count);
	}
}
public class Ru{
	public static void main(String[]args){
		Mythread mythread=new Mythread();
		Thread a=new Thread(mythread,"A");
		Thread b=new Thread(mythread,"B");
		Thread c=new  Thread(mythread,"C");
		a.start();
		b.start();
		c.start();
	}
}