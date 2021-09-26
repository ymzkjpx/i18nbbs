package ex.i18nbbs.infrastructure.datasource.thread;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
}
