package com.jlg.command;

import org.hamcrest.Matchers;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.runner.RunWith;
import org.junit.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class HelloWorldCommandTest {

  @Test
  public void should_execute_synchronously() {
    //given
    HelloWorldCommand helloWorldCommand = new HelloWorldCommand("Jeremy");
    //when
    String result = helloWorldCommand.execute();
    //then
    assertThat(result, equalTo("Hello Jeremy!"));
  }

  @Test
  public void should_execute_asynchronously() throws ExecutionException, InterruptedException {
    //given
    HelloWorldCommand helloWorldCommand = new HelloWorldCommand("Jeremy");
    //when
    Future<String> future = helloWorldCommand.queue();
    //then
    assertThat(future.get(), equalTo("Hello Jeremy!"));
  }

}