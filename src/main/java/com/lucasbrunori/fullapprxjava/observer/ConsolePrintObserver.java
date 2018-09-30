package com.lucasbrunori.fullapprxjava.observer;

import com.lucasbrunori.fullapprxjava.model.CoinBaseResponse;
import io.reactivex.observers.DefaultObserver;
import java.time.LocalDateTime;
import reactor.core.publisher.Mono;

public class ConsolePrintObserver extends DefaultObserver {

  @Override
  public void onNext(Object o) {
    Mono<CoinBaseResponse> responseMono =
        (Mono<CoinBaseResponse>) o;

    responseMono.subscribe(coinBaseResponse -> {
      System.out.println("[ " + LocalDateTime.now() + " | " + coinBaseResponse.getData().getBase() +
          " Buy Price $" + coinBaseResponse.getData().getAmount() +
          " " + coinBaseResponse.getData().getCurrency() + "]");
    });
  }

  @Override
  public void onError(Throwable e) {
    System.out.println("e = " + e);
  }

  @Override
  public void onComplete() {
    System.out.println("Complete");
  }
}
