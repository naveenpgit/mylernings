package threads;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class ExampleExecutorService {

    public static final int SIZE = 20000;

    public static void main(String[] args) throws InterruptedException {
        sequential();
        System.out.println("----------------------------------------------------------");
        parallel(3);
        System.out.println("----------------------------------------------------------");
        parallel(10);
    }

    private static void parallel(int poolSize) throws InterruptedException {
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(poolSize);
        Set<Callable<Integer>> callables = new HashSet<>();

        IntStream.rangeClosed(1, SIZE).forEach(i -> {
            callables.add(new Callable<Integer>() {
                public Integer call() throws Exception {
                    sayHello.accept(i, Paths.get("E:\\naveen_git\\mylernings\\resources\\parallel.txt"));
                    return i;
                }
            });
        });
        executorService.invokeAll(callables);
        executorService.shutdown();
        printTimeTaken.accept(start);
    }

    private static void sequential() {
        long start = System.currentTimeMillis();
        IntStream.rangeClosed(1, SIZE).forEach(i -> {
            sayHello.accept(i, Paths.get("E:\\naveen_git\\mylernings\\resources\\sequential.txt"));
        });

        printTimeTaken.accept(start);
    }

    static Consumer<Long> printTimeTaken = (start) -> {
        long timeTaken = (System.currentTimeMillis() - start) / 1000;
        System.out.println(MessageFormat.format("Time taken ::: {0}", timeTaken));
    };
    static BiConsumer<Integer, Path> sayHello = (index, file) -> {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Files.write(file, MessageFormat.format("Hello -- {0}\n", index).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(message);
    };

}
