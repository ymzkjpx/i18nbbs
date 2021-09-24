package ex.i18nbbs.application.thread;

import org.springframework.stereotype.Repository;

import ex.i18nbbs.domain.model.thread.Thread;
import ex.i18nbbs.domain.model.thread.ThreadNumber;

@Repository
public interface ThreadRepository {
    Boolean existsThread(ThreadNumber threadNumber);
    Thread findByThreadNumber(ThreadNumber threadNumber);
}
