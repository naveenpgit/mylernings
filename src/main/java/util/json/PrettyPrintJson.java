package util.json;

import org.apache.commons.lang.StringUtils;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.*;

public class PrettyPrintJson {

    boolean isDone = StringUtils.equalsIgnoreCase(JSONUtils
            .JsonToMap(JSONUtils.fromFile("resources/Satus_Samle.json")).get("status").toString(), "done");

    public static void main(String[] args) {

        Map<String, Object> responseMap = JSONUtils
                .JsonToMap(JSONUtils.fromFile("resources/Error_LPA_Down.json"));


        System.out.println(JSONUtils.toJson(responseMap));
        System.out.println("------------------------------------------------------");
        System.out.println(JSONUtils.toJsonWithIndent(responseMap));
    }

    public Future<Object> download() {
        String jobId = UUID.randomUUID().toString();
        CompletableFuture<String> job = pollForCompletion(jobId);
        return job.thenApply(this::downloadResult);
    }

    private <U> String downloadResult(String s) {
        System.out.println(" +++ Downloaded ++++");
        return s;
    }


    private CompletableFuture<String> pollForCompletion(String jobId) {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        CompletableFuture<String> completionFuture = new CompletableFuture<>();

        ScheduledFuture<?> checkFuture = executor.scheduleAtFixedRate(() -> {
            if (isDone) {
                completionFuture.complete(jobId);
            }
        }, 0, 10, TimeUnit.SECONDS);
        completionFuture
                .whenComplete((result, thrown) -> {
                    System.out.println("XXXXXXXXXXX"); //Never happens unless thenApply is removed
                    checkFuture.cancel(true);
                    executor.shutdown();
                });
        return completionFuture;
    }
}
