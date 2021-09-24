package ex.i18nbbs.domain.model.thread.title;

public class ThreadTheme {
    ThreadTitle threadTitle;
    ThreadOwner threadOwner;

    @Deprecated
    ThreadTheme(){}

    public ThreadTheme(ThreadTitle threadTitle, ThreadOwner threadOwner) {
        this.threadTitle = threadTitle;
        this.threadOwner = threadOwner;
    }
}
