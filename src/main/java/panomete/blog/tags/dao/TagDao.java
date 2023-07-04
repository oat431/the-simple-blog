package panomete.blog.tags.dao;

import panomete.blog.tags.entity.Tags;

import java.util.List;

public interface TagDao {
    Tags getTag(String name);
    Tags createTag(Tags tags);
    Tags createTag(String name);
    List<Tags> getTags();
}
