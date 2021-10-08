package ex.i18nbbs.domain.model.challenge.dog;

import java.time.LocalDate;
import java.time.Period;

public class Dog {
    BreedOfDog breedOfDog;
    Birthday birthday;
    DogName dogName;

    Dog(){}

    public Dog(BreedOfDog breedOfDog, Birthday birthday, DogName dogName) {
        this.breedOfDog = breedOfDog;
        this.birthday = birthday;
        this.dogName = dogName;
    }

    public BreedOfDog breedOfDog() {
        return breedOfDog;
    }

    public Birthday birthday() {
        return birthday;
    }

    public DogName dogName() {
        return dogName;
    }

    public String bark(){
        return breedOfDog.shout;
    }

    public int age(){
        return birthday.age();
    }

    public int averageLifeYear(){
        return Math.toIntExact(breedOfDog.averageLifeExpectancyDays);
    }

    public String estimatedLife(){
        Period remaining = Period.between(LocalDate.now(), LocalDate.now().plusDays(estimatedLifeDays()));
        return String.format("推定余命日数: %s年 %s月 %s日", remaining.getYears(), remaining.getMonths(), remaining.getDays());
    }

    private long estimatedLifeDays(){
       return breedOfDog.averageLifeExpectancyDays - birthday.elapsedDays();
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breedOfDog=" + breedOfDog +
                ", birthday=" + birthday +
                ", dogName=" + dogName +
                '}';
    }

}
