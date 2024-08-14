package com.observer.pattern;

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("MobileApp");
        Observer webApp = new WebApp("WebApp");

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        System.out.println("Setting stock price to 100.00");
        stockMarket.setStockPrice(100.00);

        System.out.println("Setting stock price to 200.00");
        stockMarket.setStockPrice(200.00);

        stockMarket.deregisterObserver(mobileApp);

        System.out.println("Setting stock price to 300.00");
        stockMarket.setStockPrice(300.00);
    }
}
