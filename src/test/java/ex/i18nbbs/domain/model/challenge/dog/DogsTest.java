package ex.i18nbbs.domain.model.challenge.dog;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DogsTest {

    @Test
    public void 若い犬を検出する() {
        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog(BreefOfDog.SHIBA_KEN, new Birthday(LocalDate.now()), new DogName("SHIBA")));
        dogList.add(new Dog(BreefOfDog.SHIBA_KEN, new Birthday(LocalDate.now().minusYears(2)), new DogName("TARO")));
        dogList.add(new Dog(BreefOfDog.SHIBA_KEN, new Birthday(LocalDate.now().plusYears(3)), new DogName("HUBUKI")));
        Dogs dogs = Dogs.from(dogList);
        Dog result = dogs.youngestDog();
        assertAll(() -> assertEquals(dogList.get(1).age(), result.age())
                , () -> assertEquals(dogList.get(1).dogName, result.dogName)
                , () -> assertEquals(dogList.get(1).estimatedLife(), result.estimatedLife()));
    }
}