package example2;

import rx.Observable;
import rx.Subscriber;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * controlling the iteration and unsubscription
 */
public class Example2 {
    public static void main(String[] args) {
        final List<String> symboles = Arrays.asList("GOOG", "AAPL", "MSFT", "INTC");

        final Observable<StockInfo> feed = StockServer.getFeed(symboles);
        System.out.println("get observable");

        feed.subscribe(new Subscriber<StockInfo>() {
            @Override
            public void onCompleted() {
                System.out.println("On completed");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("On error");
            }

            @Override
            public void onNext(StockInfo stockInfo) {
                System.out.println(stockInfo);
                if (stockInfo.ticker.equals("AAPL") && stockInfo.price.compareTo(new BigDecimal(199))>0){
                    System.out.println("I want to trade, no more data");
                    unsubscribe();
                }

            }
        });

    }
}
