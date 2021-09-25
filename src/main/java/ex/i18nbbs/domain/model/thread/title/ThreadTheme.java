package ex.i18nbbs.domain.model.thread.title;

import ex.i18nbbs.domain.model.response.ResponseNumber;

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
