package java21;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;

public class StructuredConcurrency {

    public static void main(String... args) throws ExecutionException, InterruptedException {
        for (var i = 0; i < 10; i++){
            try {
                System.out.println("Performing handle");
                System.out.println(handle());
            } catch (RuntimeException e) {
                System.out.println("caught handle");
            }
        }
        for (var i = 0; i < 10; i++){
            try {
                System.out.println("Performing handleOnSuccess");
                handleOnSuccess();
            } catch (RuntimeException e) {
                System.out.println("Caught handleOnSuccess");
            }
        }
    }

    static Response handle() throws ExecutionException, InterruptedException {
        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            StructuredTaskScope.Subtask<String> user  = scope.fork(StructuredConcurrency::findUser);
            StructuredTaskScope.Subtask<Integer> order = scope.fork(StructuredConcurrency::fetchOrder);

            scope.join()            // Join both subtasks
                    .throwIfFailed(RuntimeException::new);  // ... and propagate errors

            return new Response(user.get(), order.get());
        }
    }

    static void handleOnSuccess() throws ExecutionException, InterruptedException {
        try (var scope = new StructuredTaskScope.ShutdownOnSuccess<>()) {
            scope.fork(() -> findUser());
            scope.fork(() -> fetchOrder());

            Object result = scope.join().result();

            if (result instanceof String s) {
                System.out.printf("Fetching user(%s) was a success!%n", s);
            } else if (result instanceof Integer i) {
                System.out.printf("Fetching order(%s) was a success!%n", i);
            }
        }
    }


    private static Integer fetchOrder() throws InterruptedException {
        Thread.sleep((int) (Math.random()*2000));
        if (Math.random() > 0.85) {
            System.out.println("failing fetchOrder");
            throw new RuntimeException();
        }
        return 1;
    }

    private static String findUser() throws InterruptedException {
        Thread.sleep((int) (Math.random()*2000));
        if (Math.random() > 0.85) {
            System.out.println("failing fetchOrder");
            throw new RuntimeException();
        }
        return "Tim";
    }

    private static class Response {
        private final String s;
        private final Integer integer;

        public Response(String s, Integer integer) {

            this.s = s;
            this.integer = integer;
        }

        @Override
        public String toString() {
            return "Response{" +
                    "s='" + s + '\'' +
                    ", integer=" + integer +
                    '}';
        }
    }
}
