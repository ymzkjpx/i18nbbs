package ex.i18nbbs.domain.model.challenge.dog.comparator;

import java.util.Comparator;

import ex.i18nbbs.domain.model.challenge.dog.Dog;

public class DogAgeComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog o1, Dog o2) {
        if(o1.age() < o2.age()) return -1;
        if(o1.age() > o2.age()) return 1;
        return 0;
    }
}