package ex.i18nbbs.domain.model.thread.title;

/**
 * スレッドの1コメ
 */
public class ThreadTitle {
    ThreadFirstComment threadFirstComment = new ThreadFirstComment("");
    ThreadTitleOwner threadTitleOwner = new ThreadTitleOwner("");

    public ThreadTitle(){}

    public ThreadTitle(ThreadFirstComment threadFirstComment, ThreadTitleOwner threadTitleOwner) {
        this.threadFirstComment = threadFirstComment;
        this.threadTitleOwner = threadTitleOwner;
    }

    public boolean hasValue(){
        return (threadFirstComment.exists() && threadTitleOwner.exists());
    }

    public boolean exists(){
        return this != null;
    }

}
