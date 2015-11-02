package com.jlg.command;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.Subscriber;

public class HelloWorldObservableCommand extends HystrixObservableCommand<String> {

  private final String name;

  public HelloWorldObservableCommand(String name) {
    super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
    this.name = name;
  }

  @Override
  protected Observable<String> construct() {
    return Observable.create(new Observable.OnSubscribe<String>() {
      @Override
      public void call(Subscriber<? super String> observer) {
        try {
          if (!observer.isUnsubscribed()) {
            // a real example would do work like a network call here
            observer.onNext("Hello");
            observer.onNext(name + "!");
            observer.onCompleted();
          }
        } catch (Exception e) {
          observer.onError(e);
        }
      }
    });
  }
}

