package thread;

public class MyThread extends Thread {

	public void run()
	{
		System.out.println("child thread");
		for(int i=0;i<10;i++)
		{
			System.out.println(i);
		}
		
	}
	
}
