package ex.i18nbbs.infrastructure.datasource.thread;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import ex.i18nbbs.domain.model.response.Response;
import ex.i18nbbs.domain.model.response.original.Original;
import ex.i18nbbs.domain.model.thread.Thread;
import ex.i18nbbs.domain.model.thread.ThreadNumber;
import ex.i18nbbs.domain.model.thread.headline.Headline;
import ex.i18nbbs.domain.model.thread.title.ThreadTheme;

@Mapper
public interface ThreadMapper {
    Thread findOne(@Param("threadNumber") ThreadNumber threadNumber);

    Thread findThread(@Param("threadNumber") ThreadNumber threadNumber);

    ThreadTheme findThreadTheme(@Param("threadNumber") ThreadNumber threadNumber);

    List<Headline> findHeadlines();

    Response firstPostForEachThread(@Param("threadNumber") ThreadNumber threadNumber);

    int nextThreadNumber();

    void insertThread(@Param("nextThreadNumber") int nextThreadNumber,
                      @Param("thread") Thread thread);

    int nextThreadThemeNumber();

    void insertThreadTheme(@Param("nextThreadThemeNumber") int nextThreadThemeNumber,
                           @Param("nextThreadNumber") int nextThreadNumber,
                           @Param("threadTheme") ThreadTheme threadTheme);

    int nextResponseNumber();

    int nextResponseOrder(@Param("threadNumber") int threadNumber);

    void insertResponse(@Param("nextResponseNumber") int nextResponseNumber,
                        @Param("threadNumber") int threadNumber,
                        @Param("response") Response response);

    void insertOriginalMessage(@Param("responseNumber") int responseNumber,
                               @Param("original") Original original);

}
