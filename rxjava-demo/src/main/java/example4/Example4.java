package example4;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.Arrays;
import java.util.List;

/**
 * make it asynchronous
 *
 * if your task is computation intensive, then give no more thread than number of cores
 *
 * if your task is io intensive, then have more threads than the number of cores
 * nb of cores / (1 - blocking factor)
 *
 * blocking factor = % of blocking time
 */
public class Example4 {
    public static void main(String[] args) throws InterruptedException {
        final List<String> symboles = Arrays.asList("GOOG", "AAPL", "MSFT", "INTC");

        final Observable<StockInfo> feed = StockServer.getFeed(symboles);
        System.out.println("get observable");

        // TODO: 2019-04-12 transformation like takewhile, skipwhile, map, filter
        feed.onErrorResumeNext(throwable -> callABack(throwable, symboles))
                .subscribe(System.out::println, Example4::handleError);

        //Thread.sleep(10000);

    }

    private static Observable<? extends StockInfo> callABack(Throwable throwable, List<String> symboles) {
        System.out.println(throwable);
        return StockServer.getFeed(symboles);
    }

    private static void handleError(Throwable throwable) {
        System.out.println(throwable);
    }

}
