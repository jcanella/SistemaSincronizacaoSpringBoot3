package com.sistemaSincronizacao.stockexchange;



import java.util.*;


public class StockExchange {
    private static final Map<Long, Stock> availableStocks = new HashMap<>();
    public StockExchange() {
        Long proximoId = availableStocks.keySet().size() + 1L;
        availableStocks.put(proximoId, new Stock(proximoId,"AAPL", 100, 150.0));
        proximoId = availableStocks.keySet().size() + 1L;
        availableStocks.put(proximoId, new Stock(proximoId,"GOOGL", 50, 2500.0));
    }

    public List<Stock> getAll(){
        return new ArrayList<>(availableStocks.values());
    }

    public List<Stock>  getById (Long id){
        return new ArrayList<>(Collections.singleton(availableStocks.get(id)));
    }

    public String buyStock(Long stockName, int quantity) {
        System.out.println(stockName);
        System.out.println(availableStocks.containsKey(1L));
        if (findStockByName(stockName)) {
            Stock stock = availableStocks.get(stockName);
            if (stock.getQuantity() >= quantity) {
                // Realize as operações de compra, atualizando a quantidade disponível e calculando valores
                stock.setQuantity(stock.getQuantity() - quantity);

                return "Compra bem-sucedida";
            }
        }
        return "Compra falhou";
    }


    public String sellStock(Long stockName, int quantity) {
        if (findStockByName(stockName)) {
            Stock stock = availableStocks.get(stockName);
            if (stock.getQuantity() >= quantity) {
                // Realize as operações de compra, atualizando a quantidade disponível e calculando valores
                stock.setQuantity(stock.getQuantity() + quantity);

                return "Venda bem-sucedida";
            }
        }
        return "Venda falhou";
    }

    public boolean findStockByName(Long stockName) {
        return availableStocks.containsKey(stockName);
    }

}
