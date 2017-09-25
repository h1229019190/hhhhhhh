import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LIHAO {

	public static void main(String[] args) {
		ExecutorService executor=Executors.newFixedThreadPool(3);
	executor.execute(new MyThread('a',100));
	executor.execute(new MyThread('b',100));
	executor.execute(new MyNum(100));
	
	executor.shutdown();
	
	}

}
 class MyThread implements Runnable{
private char charToPrint;
private int times;
public  MyThread(char c, int t) {
	charToPrint =c;
	times=t;
}
	@Override
	public void run() {
		for (int i = 0; i < times; i++) {
			System.out.print(charToPrint);
		}
		
	}

}
 class MyNum implements Runnable{
private int lastNum;
public MyNum(int n) {
	lastNum=n;
}
	@Override
	public void run() {
		Thread thread4=new Thread(new MyThread('c',40));
		thread4.start();
		
				try {
					for (int i = 0; i <= lastNum; i++) {
			System.out.print(" "+ i);
			if(i==50)  thread4.join();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	

}

