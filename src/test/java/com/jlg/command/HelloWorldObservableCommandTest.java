package com.jlg.command;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import rx.Observable;
import rx.functions.Action1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static java.util.Collections.emptyList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class HelloWorldObservableCommandTest {

  @Test
  public void should_return_observable() {
    //given
    List<String> result = new ArrayList<>();
    HelloWorldObservableCommand helloWorldCommand = new HelloWorldObservableCommand("Jeremy");
    //when
    Observable<String> observable = helloWorldCommand.observe();
    observable.subscribe(s -> {
      result.add(s);
    });
    //then
    assertThat(result.get(0), equalTo("Hello"));
    assertThat(result.get(1), equalTo("Jeremy!"));
  }
}