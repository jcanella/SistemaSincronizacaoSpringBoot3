package com.sistemaSincronizacao.acoes.api;



import com.sistemaSincronizacao.stockexchange.Stock;
import com.sistemaSincronizacao.stockexchange.StockExchange;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// CLASE RESPONSAVEL PELO ENDPOINT
@Controller
@RequestMapping(value = "/bolsa", produces = MediaType.APPLICATION_JSON_VALUE)
public class AcoesAPI {

    StockExchange stockExchange = new StockExchange();


    //retornar a lista de ações disponíveis
    @GetMapping("/stocks")
    @ResponseBody
    public List<Stock> getAll(){
        return stockExchange.getAll();
    }

    //retornar informações detalhadas de uma ação específica
    @GetMapping("/stocks/{stockId}")
    @ResponseBody
    public List<Stock> getById(@PathVariable("stockId") Long stockId){
        return stockExchange.getById(stockId);
    }

    //criar um novo pedido de compra de ações
    @PostMapping("/orders/buy/{stockId}")
    @ResponseBody
    public String createOrderBuy(@PathVariable("stockId") Long stockId){
        return stockExchange.buyStock(stockId,1);
    }

    //criar um novo pedido de enda de ações
    @PostMapping("/orders/sell/{stockId}")
    @ResponseBody
    public String createOrderSell(@PathVariable("stockId") Long stockId){
        return stockExchange.sellStock(stockId, 1);
    }

}
