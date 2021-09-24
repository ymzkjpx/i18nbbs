package ex.i18nbbs.infrastructure.datasource.thread;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import ex.i18nbbs.domain.model.thread.Thread;
import ex.i18nbbs.domain.model.thread.ThreadNumber;
import ex.i18nbbs.domain.model.thread.title.ThreadTitle;

@Mapper
public interface ThreadMapper {
    Thread findOne(@Param("threadNumber") ThreadNumber threadNumber);
    Thread findThread(@Param("threadNumber") ThreadNumber threadNumber);
    ThreadTitle findThreadTitle(@Param("threadNumber") ThreadNumber threadNumber);
}
