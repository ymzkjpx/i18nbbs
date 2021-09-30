package ex.i18nbbs.domain.model.challenge.dog;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DogsTest {

    @Test
    public void 若い犬を検出する() {
        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog(BreefOfDog.SHIBA_KEN, new Birthday(LocalDate.now().minusYears(1).minusDays(10)), new DogName("SHIBA")));
        dogList.add(new Dog(BreefOfDog.SHIBA_KEN, new Birthday(LocalDate.now().minusYears(4)), new DogName("TARO")));
        dogList.add(new Dog(BreefOfDog.SHIBA_KEN, new Birthday(LocalDate.now().minusYears(3)), new DogName("HUBUKI")));
        dogList.add(new Dog(BreefOfDog.SHIBA_KEN, new Birthday(LocalDate.now().minusYears(0).minusDays(9)), new DogName("GOU")));
        dogList.add(new Dog(BreefOfDog.SHIBA_KEN, new Birthday(LocalDate.now().minusYears(0).minusDays(10)), new DogName("GOU")));
        Dogs dogs = Dogs.from(dogList);
        Dog result = dogs.youngestDog();
        assertAll(() -> assertEquals(dogList.get(3).age(), result.age())
                , () -> assertEquals(dogList.get(3).dogName, result.dogName)
                , () -> assertEquals(dogList.get(3).estimatedLife(), result.estimatedLife()));
    }
}