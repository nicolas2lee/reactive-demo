package example3;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.Schedulers;

import java.math.BigDecimal;
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
public class Example3 {
    public static void main(String[] args) throws InterruptedException {
        final List<String> symboles = Arrays.asList("GOOG", "AAPL", "MSFT", "INTC");

        final Observable<StockInfo> feed = StockServer.getFeed(symboles);
        System.out.println("get observable");

        feed.subscribeOn(Schedulers.io())
                .subscribe(Example3::printStockInfo);

        Thread.sleep(10000);

    }

    private static void printStockInfo(StockInfo stockInfo) {
        System.out.println("Thread: " + Thread.currentThread());
        System.out.println(stockInfo);
    }
}
