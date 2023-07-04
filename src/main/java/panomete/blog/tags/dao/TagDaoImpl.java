package panomete.blog.tags.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import panomete.blog.tags.entity.Tags;
import panomete.blog.tags.repository.TagRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TagDaoImpl implements TagDao {
    final TagRepository tagRepository;
    @Override
    public Tags getTag(String name) {
        return tagRepository.findByName(name);
    }

    @Override
    public Tags createTag(Tags tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tags createTag(String name) {
        return tagRepository.save(Tags.builder().name(name).build());
    }

    @Override
    public List<Tags> getTags() {
        return tagRepository.findAll();
    }
}
