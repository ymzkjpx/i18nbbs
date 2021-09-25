package ex.i18nbbs.domain.model.challenge.dog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Dogs {
    List<Dog> list;

    @Deprecated
    Dogs(){}

    private Dogs(List<Dog> list) {
        this.list = list;
    }

    public static Dogs from(List<Dog> source) {
        return new Dogs(source);
    }

    public Dog youngestDog(){
        List<Dog> copyList = unmodifiableCopy();
        Collections.sort(copyList, new DogAgeComparator());
        return copyList.get(0);
    }

    public Dog oldestDog(){
        List<Dog> copyList = unmodifiableCopy();
        Collections.sort(copyList, new DogAgeReverseComparator());
        return copyList.get(0);
    }

    private List<Dog> unmodifiableCopy(){
        return new ArrayList<>(Collections.unmodifiableList(list));
    }

    public List<Dog> asList(){
        return list;
    }

    public static class DogAgeComparator implements Comparator<Dog> {
        @Override
        public int compare(Dog o1, Dog o2) {
            if(o1.age() < o2.age()) return -1;
            if(o1.age() > o2.age()) return 1;
            return 0;
        }
    }

    public static class DogAgeReverseComparator implements Comparator<Dog> {
        @Override
        public int compare(Dog o1, Dog o2) {
            if(o1.age() < o2.age()) return 1;
            if(o1.age() > o2.age()) return -1;
            return 0;
        }
    }
}
