package lectures;

import org.junit.Test;

import java.util.function.Function;

public class FunctionInterface {

  @Test
  public void functionInterface() {
    Function<String, Integer> map = str -> str.length();
    long length = map.apply("test");

    System.out.println(length);
  }
}
