package Java_0812;

public class Test4 {
    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread() {
            @Override
            public void run() {
                for(int i = 0; i < 5; i++) {
                    System.out.println(i);
                }
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for(int i = 5; i < 10; i++ ) {
                    System.out.println(i);
                }
            }
        };
        thread.start();
        thread.join();
        thread2.start();
        thread2.join();

    }
}
