package threads;

public class ThreadsDemo {

    public static void main(String[] args) {
        System.out.println("Inside main thread ...");
        Thread longTask = new Thread(new LongTask());
        longTask.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("numbers: " + i);
        }

        ShortTask shortTask = new ShortTask();
        shortTask.start();

    }

    static class ShortTask extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                System.out.println("running a short task... " + i);
            }
        }
    }
}

class LongTask implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Long task is running ... " + i);
        }
    }

}