public class Mythread extends Thread{
	@Override
	public void run(){
		super.run();
		System.out.println("MyThread");
	}
}
class Run{
	public static void main(String[]args){
		Mythread mythread=new Mythread();
		mythread.start();
		System.out.println("run over!");
	}
}