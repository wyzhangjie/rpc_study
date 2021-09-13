package selftest;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactorTest {


    public static void test() {
        Flux.range(1, 25).buffer(10).subscribe(System.out::println);

        Flux.range(1, 5).window(2).toIterable().forEach(w -> {

            w.subscribe(System.out::println);

            System.out.println("-------");

        });

        Flux.just(1, 2).map(i -> "number-" + i).subscribe(System.out::println);

        Flux.just(1, 5)

                .flatMap(x -> Mono.just(x * x))

                .subscribe(System.out::println);

        Flux.range(1, 100).take(10).subscribe(System.out::println);


        Flux.range(1, 100).takeLast(10).subscribe(System.out::println);


    }

    public static void test2() {
        Flux.just(1, 2, 3).subscribe(System.out::println);
        Flux.just(1, 2, 3).then().subscribe(System.out::println);

        Flux.just(1, 2, 3)

                .thenMany(Flux.just(4, 5))

                .subscribe(System.out::println);
    }

    public static void test3() {
        Flux flux1 = Flux.just(1, 2);

        Flux flux2 = Flux.just(3, 4, 5);

        Flux.zip(flux1, flux2).subscribe(System.out::println);
        Flux.just(1, 2).zipWith(Flux.just(3, 4))

                .subscribe(System.out::println);


    }

    public static void test4() {
        Flux.just(1, 2).zipWith(Flux.just(3, 4), (s1, s2) ->

                String.format("%s+%s=%s", s1, s2, s1 + s2))

                .subscribe(System.out::println);

    }

    public static void test5() {
        Flux.range(1, 100).takeUntil(i -> i == 10)

                .subscribe(System.out::println);

    }

    public static void test6() {
        Flux.range(1, 100).takeWhile(i -> i <= 10)

                .subscribe(System.out::println);

    }

    public static void test7() {
        Flux.range(1, 10).bufferUntil(i -> i % 3 == 0)

                .subscribe(System.out::println);

    }

    public static void test8() {
        Flux.range(1, 10).bufferWhile(i -> i % 3 == 0)

                .subscribe(System.out::println);

    }

    public static void test9() {
        Flux.just(3, 5, 7, 9, 11, 15, 16, 17)

                .any(e -> e % 2 == 0)

                .subscribe(isExisted -> System.out.println(isExisted));


    }

    public static void test10() {
        Flux.just("abc", "ela", "ade", "pqa", "kang")

                .all(a -> a.contains("a"))

                .subscribe(isAllContained -> System.out.println(isAllContained));

    }

    public static void test11() {
        Flux.concat(

                Flux.range(1, 3),

                Flux.range(3, 2),

                Flux.range(10, 5)

        ).subscribe(System.out::println);

    }


    public static void test12() {
        Flux.range(1, 10).reduce((x, y) -> x + y)

                .subscribe(System.out::println);

    }

    public static void test13() {
        Flux.range(1, 10).reduceWith(() -> 15, (x, y) -> x + y)

                .subscribe(System.out::println);

    }

    public static void test14() {
        Subscriber<String> subscriber = new Subscriber<String>() {

            volatile Subscription subscription;


            public void onSubscribe(Subscription s) {

                subscription = s;

                System.out.println("initialization");

                //行 subscription.request(1) 方法，也就是说使用简单的拉模型来管理背压
                subscription.request(1);

            }


            public void onNext(String s) {

                System.out.println("onNext:" + s);

                subscription.request(1);

            }


            public void onComplete() {

                System.out.println("onComplete");

            }


            public void onError(Throwable t) {

                System.out.println("onError:" + t.getMessage());

            }

        };
        Flux<String> flux = Flux.just("12", "23", "34");

        flux.subscribe(subscriber);

    }

    public static void test20(){
        Flux.just(1, 2).log().subscribe(System.out::println);

    }

    public static void test21(){
        Mono.just(0).map(x -> 1 / x)

                .checkpoint("info").subscribe(System.out::println);

    }

    static class MySubscriber<T> extends BaseSubscriber<T> {

        public void hookOnSubscribe(Subscription subscription) {

            System.out.println("initialization");

            request(1);

        }


        public void hookOnNext(T value) {

            System.out.println("onNext:" + value);

            request(1);

        }

    }

    public static void test16() {
        MySubscriber subscriber = new MySubscriber();

        Flux<String> flux = Flux.just("12", "23", "34");

        flux.subscribe(subscriber);
    }

    public static void main(String[] args) {
        test21();
    }
}
