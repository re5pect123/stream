package lectures;

import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import mockdata.MockData;
import org.junit.Test;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoshBasic {


    // Slice: limit, skip, takewhile, dropwhile
    @Test
    public void moshTutorial() throws Exception {
        ImmutableList<Person> people = MockData.getPeople();
        // 1
        List<String> collectFirstName =
                people.stream().map(Person::getFirstName).limit(5).collect(Collectors.toList());
        collectFirstName.forEach(System.out::println);
        // 1a
        people.stream().map(Person::getEmail).skip(990).forEach(System.out::println);
    }

    // Flatmap -> spaja vise lista u jednu
    @Test
    public void moshFlatMap() {

        List<Integer> lista1 = List.of(1, 2, 3);
        List<Integer> lista2 = List.of(4, 5, 6);

        List<Integer> collectWithFlatMap =
                Stream.of(lista1, lista2).flatMap(Collection::stream).collect(Collectors.toList());

        collectWithFlatMap.forEach(System.out::println);
    }

    // Razlika filter i takeWhile
    /*
     * Filter ce izbaciti sve rezulatet kada je age < 30 u konkretnom primeru 2 rezultata
     * takeWhile ce izbaciti sve rezulte dok ne dodje do prvog FALSE, tu staje u konkretnom primeru 1 rezultat
     * dropWhile ce izbaciti sve rezultate kad dodje do prvog FALSE u konkretnom primeru izbacice 30 i 20 */
    @Test
    public void moshTakeWhile() {
        List<PersonDTO> personList =
                List.of(
                        new PersonDTO(1, "Marko", 10),
                        new PersonDTO(2, "Milan", 30),
                        new PersonDTO(3, "Nikola", 20));

        personList.stream().takeWhile(age -> age.getAge() < 30).forEach(System.out::println);
    }

    // Sorted 2 - za desc reversed()
    @Test
    public void moshSorting() {
        List<PersonDTO> personList =
                List.of(new PersonDTO(3, "B", 10), new PersonDTO(1, "A", 30), new PersonDTO(2, "C", 20));

        personList.stream().map(PersonDTO::getId).sorted().forEach(System.out::println);

        personList.stream()
                .sorted((a, b) -> a.getName().compareTo(b.getName()))
                .sorted(Comparator.comparing(m -> m.getName()))
                .sorted(Comparator.comparing(PersonDTO::getName))
                .forEach(m -> System.out.println(m.getName()));
    }

    // ispis nakon svake iteracije
    @Test
    public void moshPeek() {
        List<PersonDTO> personList =
                List.of(new PersonDTO(3, "B", 10), new PersonDTO(1, "A", 30), new PersonDTO(2, "C", 20));

        personList.stream()
                .filter(person -> person.getAge() > 10)
                .peek(personDto -> System.out.println("this person have more then 10 years " + personDto))
                .forEach(System.out::println);
    }
}
