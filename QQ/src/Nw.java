
public class Nw implements Runnable{
	
	



@Override
public void run() {
	
		try {
	Thread.sleep(5000);
}catch(InterruptedException e) {
	e.printStackTrace();
}
		System.out.println("hi!gilr  How about You!");
}


public static void main(String[] args) {
	Runnable run=new Nw();
	Thread t1=new Thread(run);
	t1.start();

}
}
