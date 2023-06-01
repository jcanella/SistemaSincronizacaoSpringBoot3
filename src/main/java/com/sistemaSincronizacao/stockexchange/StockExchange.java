package com.sistemaSincronizacao.stockexchange;



import java.time.Duration;
import java.time.LocalTime;
import java.util.*;



public class StockExchange {
    private static final Map<Long, Stock> availableStocks = new HashMap<>();
    private LocalTime horaSistemaBV = LocalTime.now();


    /* CHUMBA AS AÇÕES */
    public StockExchange() {
        Long proximoId = availableStocks.keySet().size() + 1L;
        availableStocks.put(proximoId, new Stock(proximoId,"AAPL", 100, 150.0));
        proximoId = availableStocks.keySet().size() + 1L;
        availableStocks.put(proximoId, new Stock(proximoId,"GOOGL", 50, 2500.0));
    }

    /* CONSULTA TODAS AS AÇÕES */
    public List<Stock> getAll(){
        return new ArrayList<>(availableStocks.values());
    }
    /*CHUMBA AS AÇÕES */
    public List<Stock>  getById (Long id){
        return new ArrayList<>(Collections.singleton(availableStocks.get(id)));
    }

    /* COMPRA DE AÇÕES */
    public String buyStock(Long stockName, int quantity, LocalTime horaSistemaHB) {
        if (!horaSistemaHB.equals(horaSistemaBV)) {
            // Iniciar processo de sincronização usando algoritmo de Berkeley
            sincronizarRelogios(horaSistemaHB);
        }

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

    /* VENDA DE AÇÕES */
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
    private void sincronizarRelogios(LocalTime horaSistemaHB) {

        Duration diferenca = Duration.between(horaSistemaHB, horaSistemaBV);


//        enviarMensagemSincronizacao(diferenca);


        LocalTime horaAjustadaHB = receberRespostaSincronizacao();


        horaSistemaHB = horaAjustadaHB;
    }
//    private void enviarMensagemSincronizacao(Duration diferenca) {
//
//        SyncMessage syncMessage = new SyncMessage(diferenca);
//
//
//        String mensagemJson = convertToJson(syncMessage);
//
//
//        //RestClient.sendPostRequest("http://hb-url/sync", mensagemJson);
//    }
    private LocalTime receberRespostaSincronizacao() {

        // ...
        return null;
    }

//    private String convertToJson(Object object) {
//        Gson gson = new Gson();
//        return gson.toJson(object);
//    }

}
