package lectures;

import beans.PersonDTO;
import org.junit.Test;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerAndThen {

  @Test
  public void consumerAndThen() {
    List<PersonDTO> personList =
        List.of(new PersonDTO(3, "B", 10), new PersonDTO(1, "A", 30), new PersonDTO(2, "C", 20));
    Consumer<PersonDTO> print = item -> System.out.println(item.getName());

    Consumer<PersonDTO> printLowerCase = item -> System.out.println(item.getName().toLowerCase());

    personList.forEach(print.andThen(printLowerCase));
  }
}
