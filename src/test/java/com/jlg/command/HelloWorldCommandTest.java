package com.jlg.command;

import org.hamcrest.Matchers;
import org.mockito.runners.MockitoJUnitRunner;
import org.junit.runner.RunWith;
import org.junit.*;

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

}