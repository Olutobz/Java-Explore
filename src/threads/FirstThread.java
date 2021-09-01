package threads;

public class FirstThread {
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.start();
        System.out.println("Inside main ...");
    }

    static class Task implements Runnable {

        @Override
        public void run() {

        }
    }
}
