import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreadExample {
    public static void main(String[] args) {
        try(var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.rangeClosed(1, 10_000).forEach(i -> {
                executor.submit(() -> {
                    System.out.println(i);
                    try {
                        Thread.sleep(Duration.ofSeconds(1));
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            });
        }


        Runnable runnable = () -> System.out.println("Inside Runnable");
        //1
        Thread.startVirtualThread(runnable);
        //2
        Thread virtualThread = Thread.ofVirtual().start(runnable);
        //3
        var executor = Executors.newVirtualThreadPerTaskExecutor();
        executor.submit(runnable);
    }
}
