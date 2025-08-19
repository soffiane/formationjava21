package advancedthreadtopics;

public class ExceptionHandlerWithUncaughtExceptionHandler {
    public static void main(String[] args) {
        Thread.UncaughtExceptionHandler handler = (t, e) -> System.out.println("Thread "+t.getName()+" terminated with exception "+e.getMessage());

        Runnable task = () -> {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName() + " task started");
                    double value = Math.random();
                    System.out.println("Generated number by " + Thread.currentThread().getName() + " is " + value);
                    if (value > 0.5) {
                        throw new RuntimeException("Simulation error");
                    }
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " task completed");
                } catch (Exception e) {
                    System.out.println(Thread.currentThread().getName() + " Exception : " + e.getMessage());
                    break;
                }
            }
        };

        Thread t1 = new Thread(task,"T1");
        t1.setUncaughtExceptionHandler(handler);//setter a mettre pour faire gerer l'exception par le handler
        Thread t2 = new Thread(task,"T2");
        t2.setUncaughtExceptionHandler(handler);

        t1.start();
        t2.start();
    }
}
