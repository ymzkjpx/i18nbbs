package ex.i18nbbs.domain.model.thread.title;

public class NumberOfThreadTitles {
    int value = 0;

    @Deprecated
    NumberOfThreadTitles(){}

    public NumberOfThreadTitles(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public boolean exists(){
        return value > 0;
    }

    @Override
    public String toString() {
        return "NumberOfThreadTitles{" +
                "value=" + value +
                '}';
    }
}
