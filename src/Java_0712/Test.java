package Java_0712;

public class Test {
    private static final long count= 100_0000_0000L;
    private static void serial() {
        long beg = System.currentTimeMillis();
        int a = 0, b = 0;
        for(long i = 0; i < count; i++) {
            a++;
        }
        for(long i = 0; i < count; i++) {
            b++;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - beg);
    }
    private static void currency(){
        long beg = System.currentTimeMillis();
        Thread t = new Thread() {
            @Override
            public void run() {
                int a = 0;
                for(long i = 0; i < count; i++) {
                    a++;
                }
            }
        };
        Thread t1 = new Thread() {
            @Override
            public void run() {
                int b = 0;
                for(long i = 0; i < count; i++) {
                    b++;
                }
            }
        };
        t.start();
        t1.start();
        try{
            t.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - beg);
    }

    public static void main(String[] args) {
        serial();
        currency();
    }
}
