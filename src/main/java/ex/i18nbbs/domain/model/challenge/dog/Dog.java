package ex.i18nbbs.domain.model.challenge.dog;

import java.time.LocalDate;
import java.time.Period;

public class Dog {
    BreefOfDog breefOfDog;
    Birthday birthday;
    DogName dogName;

    @Deprecated
    Dog(){}

    public Dog(BreefOfDog breefOfDog, Birthday birthday, DogName dogName) {
        this.breefOfDog = breefOfDog;
        this.birthday = birthday;
        this.dogName = dogName;
    }

    public BreefOfDog breefOfDog() {
        return breefOfDog;
    }

    public Birthday birthday() {
        return birthday;
    }

    public DogName dogName() {
        return dogName;
    }

    public String bark(){
        return breefOfDog.shout;
    }

    public int age(){
        return birthday.age();
    }

    public int averageLifeYear(){
        return Math.toIntExact(breefOfDog.averageLifeExpectancyDays);
    }

    public String estimatedLife(){
        Period remaining = Period.between(LocalDate.now(), LocalDate.now().plusDays(estimatedLifeDays()));
        return String.format("推定余命日数: %s年 %s月 %s日", remaining.getYears(), remaining.getMonths(), remaining.getDays());
    }

    private long estimatedLifeDays(){
       return breefOfDog.averageLifeExpectancyDays - birthday.elapsedDays();
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breefOfDog=" + breefOfDog +
                ", birthday=" + birthday +
                ", dogName=" + dogName +
                '}';
    }

}
