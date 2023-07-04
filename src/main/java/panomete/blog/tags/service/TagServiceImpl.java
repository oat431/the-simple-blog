package panomete.blog.tags.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import panomete.blog.tags.dao.TagDao;
import panomete.blog.tags.entity.Tags;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    final TagDao tagDao;

    @Override
    public List<String> getAllTags() {
        return tagDao.getTags().stream().map(Tags::getName).toList();
    }

    @Override
    public Tags getTag(String name) {
        return tagDao.getTag(name);
    }
}
