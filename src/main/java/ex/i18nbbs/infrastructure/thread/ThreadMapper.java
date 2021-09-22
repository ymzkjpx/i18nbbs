package ex.i18nbbs.infrastructure.thread;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

import ex.i18nbbs.domain.model.response.Response;
import ex.i18nbbs.domain.model.thread.ThreadNumber;
import ex.i18nbbs.domain.model.thread.title.ThreTi;

@Mapper
public interface ThreadMapper {
    List<Response> findResponseList(ThreadNumber threadNumber);
    ThreTi findThreTi(ThreadNumber threadNumber);
}
