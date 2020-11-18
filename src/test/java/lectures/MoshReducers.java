package lectures;

import beans.PersonDTO;
import org.junit.Test;

import java.io.IOException;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/*
count
anyMatch
allMatch
noneMatch
findFirst
findAny
max
min
 */
public class MoshReducers {

  @Test
  public void imperativeApproach() throws IOException {
    List<PersonDTO> personList =
        List.of(new PersonDTO(3, "B", 10), new PersonDTO(1, "A", 30), new PersonDTO(2, "C", 20));

    // count
    long count = personList.stream().count();
    System.out.println(count);

    // return boolean
    boolean anyMatch = personList.stream().anyMatch(m -> m.getAge() > 20);
    System.out.println(anyMatch);

    // proverava da li su svi
    boolean allMatch = personList.stream().allMatch(m -> m.getAge() > 20);
    System.out.println(allMatch);

    // proverava da li su svi !none
    boolean noneMatch = personList.stream().noneMatch(m -> m.getAge() > 20);
    System.out.println(noneMatch);
  }

  @Test
  public void sumarizing(){
    List<PersonDTO> personList =
            List.of(new PersonDTO(3, "B", 10), new PersonDTO(1, "A", 30), new PersonDTO(2, "C", 20));

    IntSummaryStatistics collect = personList.stream()
            .collect(Collectors.summarizingInt(PersonDTO::getAge));

    System.out.println(collect);
  }
}
