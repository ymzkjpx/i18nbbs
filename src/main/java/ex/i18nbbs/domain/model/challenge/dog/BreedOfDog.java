package ex.i18nbbs.domain.model.challenge.dog;

public enum BreedOfDog {
    TOSA_KEN(4383, "won!"), SHIBA_KEN(5479, "can!"), SHOURYU_KEN(2514, "shoryu-ken!");

    long averageLifeExpectancyDays;
    String shout;

    BreedOfDog(int averageLifeExpectancyDays, String shout) {
        this.averageLifeExpectancyDays = averageLifeExpectancyDays;
        this.shout = shout;
    }
}
