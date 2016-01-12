class LoginServerlet{
	private static String usernameRef;
	private static String passwordRef;
	public static void doPost(String username,String password){
		try{
			usernameRef=username;
			if(username.equals("a")){
				Thread.sleep(5000);
			}
			passwordRef=password;
			System.out.println("username="+usernameRef+"password="+password);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
class MythreadA extends Thread{
	public void run(){
		LoginServerlet.doPost("a","aa");
	}
}
class MythreadB extends Thread{
	public void run(){
		LoginServerlet.doPost("b","bb");
	}
}
public class Run{
	public static void main(String[]args){
		MythreadA a=new MythreadA();
		a.start();
		MythreadB b=new MythreadB();
		b.start();
	}
}