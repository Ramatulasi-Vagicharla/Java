public class ThreadingConcepts {

    private boolean flag = true; // Simple flag to demonstrate synchronization

    // Custom runnable to simulate some work
    class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " is running step " + i);
                try {
                    Thread.sleep(500); // Simulate work by sleeping
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " was interrupted");
                }
            }
        }
    }

    // Custom thread class that uses synchronization to modify a shared variable
    class WorkerThread extends Thread {
        public void run() {
            synchronized (ThreadingConcepts.this) {
                flag = !flag; // Toggle the flag to show that this method affects the shared state
                System.out.println(Thread.currentThread().getName() + " has changed the flag to: " + flag);
            }
        }
    }

    // Lambda implementation for thread creation
    public void createLambdaThread() {
        Thread lambdaThread = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println(Thread.currentThread().getName() + " is executing lambda task " + i);
            }
        });
        lambdaThread.setName("LambdaThread");
        lambdaThread.start();
    }

    public void demonstrateThreading() {
        // Starting a thread using Runnable
        Thread thread1 = new Thread(new MyRunnable(), "RunnableThread");
        thread1.start();

        // Starting a thread by extending Thread class
        WorkerThread workerThread = new WorkerThread();
        workerThread.setName("WorkerThread");
        workerThread.start();

        // Create and start a lambda thread
        createLambdaThread();

        // Demonstrating thread states and joining
        try {
            System.out.println("Thread1 state before join: " + thread1.getState());
            thread1.join(); // Waits for thread1 to finish
            System.out.println("Thread1 state after join: " + thread1.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Demonstrating wait and notify without deadlock
        final Object lock = new Object();
        Thread waiter = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Waiter is waiting for a notification...");
                    lock.wait(); // Wait for notification
                    System.out.println("Waiter received the notification!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "WaiterThread");

        Thread notifier = new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(2000); // Simulate some work before notifying
                    System.out.println("Notifier is sending notification...");
                    lock.notify(); // Notify the waiting thread
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "NotifierThread");

        waiter.start();
        notifier.start();

        // Using ThreadLocal to store individual thread-specific data
        ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> (int) (Math.random() * 100));
        Thread threadLocalThread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " has ThreadLocal value: " + threadLocal.get());
        }, "ThreadLocalThread");
        threadLocalThread.start();
    }

    public static void main(String[] args) {
        new ThreadingConcepts().demonstrateThreading();
    }
}
