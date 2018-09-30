package com.lucasbrunori.fullapprxjava.service;

import com.lucasbrunori.fullapprxjava.model.CoinBaseResponse;
import reactor.core.publisher.Mono;

public interface CoinBaseService {

  Mono<CoinBaseResponse> getCryptoPrice(String priceName);


}
