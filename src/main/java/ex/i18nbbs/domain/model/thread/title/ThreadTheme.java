package ex.i18nbbs.domain.model.thread.title;

/**
 * スレッドテーマ
 */
public class ThreadTheme {
    ThreadTitle threadTitle;
    ThreadOwner threadOwner;

    @Deprecated
    ThreadTheme(){}

    public ThreadTitle threadTitle() {
        return threadTitle;
    }

    public ThreadOwner threadOwner() {
        return threadOwner;
    }

    public ThreadTheme(ThreadTitle threadTitle, ThreadOwner threadOwner) {
        this.threadTitle = threadTitle;
        this.threadOwner = threadOwner;
    }
}
