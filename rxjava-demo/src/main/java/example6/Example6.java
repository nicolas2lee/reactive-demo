package example6;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * hot vs cold observable
 *
 */
public class Example6 {
    public static void main(String[] args) throws InterruptedException {

        final Observable<Integer> feed = StockServer.getData()
                .subscribeOn(Schedulers.io())
                // TODO: 2019-04-13 for hot observable
                //.share()
                ;

        feed.subscribe(System.out::println);
        Thread.sleep(5000);
        feed.subscribe(System.out::println);
        Thread.sleep(30000);
    }
}
