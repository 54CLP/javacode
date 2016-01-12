import java.util.concurrent.locks.ReentrantLock;

public class Thread1 {
public static void main(String[] args) {
	final Service service=new Service(false);
	Runnable runnable=new Runnable(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("&Thread"+Thread.currentThread().getName()+"get run");
			service.serviceMethod();
		}
		
	};
	Thread[] threadArray=new Thread[10];
	for(int i=0;i<10;i++){
		threadArray[i]=new Thread(runnable);
	}
	for(int i=0;i<10;i++){
		threadArray[i].start();
	}
}
}
class Service{
	private ReentrantLock lock;
	public Service(boolean isFair){
		super();
		lock=new ReentrantLock(isFair);
	}
	public void serviceMethod(){
		try{
			lock.lock();
			System.out.println("ThreadName="+Thread.currentThread().getName()+"get lock");
			
		}finally{
			lock.unlock();
		}
	}
}

