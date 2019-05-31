package example2;

import rx.Observable;
import rx.Subscriber;

import java.util.List;

public class StockServer {
    public static Observable<StockInfo> getFeed(final List<String> symboles){
        return Observable.create(subscriber -> processRequest(subscriber, symboles));
    }

    private static void processRequest(Subscriber<? super StockInfo> subscriber, List<String> symboles) {
        System.out.println("processing...");
        // TODO: 2019-04-11 step 1, if s subsriber unsubscribe, then should not send data
        while (!subscriber.isUnsubscribed()){
        //while(true){
            symboles.stream()
                    .map(StockFetcher::fetch)
                    // TODO: 2019-04-11  step 2, filter useless data, in java 9 + we can use takewhile, take until
                    .filter(data -> !subscriber.isUnsubscribed())
                    .forEach(subscriber::onNext)
            ;
        }
    }
}
