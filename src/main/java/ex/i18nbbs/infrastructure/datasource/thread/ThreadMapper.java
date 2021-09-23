package ex.i18nbbs.infrastructure.datasource.thread;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import ex.i18nbbs.domain.model.response.Response;
import ex.i18nbbs.domain.model.thread.ThreadNumber;
import ex.i18nbbs.domain.model.thread.title.ThreadTitle;

@Mapper
public interface ThreadMapper {
    List<Response> findResponseList(ThreadNumber threadNumber);
    ThreadTitle findThreTi(ThreadNumber threadNumber);
}
