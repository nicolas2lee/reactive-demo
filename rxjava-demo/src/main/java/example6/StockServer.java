package example6;

import rx.Observable;
import rx.Subscriber;

import java.util.List;

public class StockServer {
    public static Observable<Integer> getData(){
        return Observable.create((Observable.OnSubscribe<Integer>) StockServer::processRequest);
    }

    private static void processRequest(Subscriber<? super Integer> subscriber) {
        System.out.println("processing...");
        // TODO: 2019-04-11 step 1, if s subsriber unsubscribe, then should not send data
        int count =0;
        while(true){
            subscriber.onNext(count++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
