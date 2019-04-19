package example7;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * back pressure
 *
 */
public class Example7 {
    public static void main(String[] args) throws InterruptedException {

        final Observable<Integer> feed = StockServer.getData()
                //.onBackpressureDrop()   //1. delete data unable to handle
                //.onBackpressureBuffer() //2. put into cache
                                          //3. make client async ou add more clients
                                          //4. batch processing
                ;
        Thread.sleep(30000);
        feed.subscribe(System.out::println, System.out::println);
    }
}
