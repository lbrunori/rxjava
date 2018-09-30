package com.lucasbrunori.fullapprxjava.cmd;

import com.lucasbrunori.fullapprxjava.observer.ConsolePrintObserver;
import com.lucasbrunori.fullapprxjava.service.CoinBaseService;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CmdLineUI implements CommandLineRunner {

  @Autowired
  private CoinBaseService coinBaseService;

  @Override
  public void run(String... args) throws Exception {

    System.out.printf("%nReactive programming with Java 8%n");

    Observable.interval(10000, TimeUnit.MILLISECONDS, Schedulers.io())
        .map(tick -> coinBaseService.getCryptoPrice("BTC-USD"))
        .subscribe(new ConsolePrintObserver());
  }
}
