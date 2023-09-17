import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreads {
    public static void main(String[] args) {
        int times = 5;
        long virtualTime = 0L;
        long platformTime = 0L;
        for (var x =0; x < times; x++) {
            virtualTime +=virtual();
            platformTime +=platform();
        }
        System.out.printf("Virtual Thread average %.2f%n", ((double) virtualTime/times));
        System.out.printf("Platform Thread average %.2f%n", ((double) platformTime/times));
    }

    public static long virtual() {
        long startTime = System.currentTimeMillis();

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 10_000).forEach(i -> {
                executor.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(1));
                    return i;
                });
            });
        }
        return System.currentTimeMillis()-startTime;
    }

    public static long platform(){
        long startTime = System.currentTimeMillis();
        try (var executor = Executors.newCachedThreadPool()) {
            IntStream.range(0, 10_000).forEach(i -> {
                executor.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(1));
                    return i;
                });
            });
        }
        return System.currentTimeMillis()-startTime;
    }
}
