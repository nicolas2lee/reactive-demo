package example7;

import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;

class StockFetcher {
    public static StockInfo fetch(String symbole) {
        if (Math.random() > 0.5){
            throw new RuntimeException("ohoh");
        }
        try {
            return new StockInfo(symbole, YahooFinance.get(symbole).getQuote().getPrice());
        } catch (IOException e) {
            return new StockInfo(symbole, BigDecimal.ZERO);
        }
    }
}
