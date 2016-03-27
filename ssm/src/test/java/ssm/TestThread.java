package ssm;

public class TestThread {
	public static  void main(String[] args){
		for(int i=0;i<100000;i++){
			new Thread(new Runnable() {
				public void run() {
					for(int i=0;i<100;i++){
						System.out.println(i);
					}
				}
			}).start();
		}
	}
}
