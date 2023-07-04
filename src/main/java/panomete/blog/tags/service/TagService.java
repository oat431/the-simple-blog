package panomete.blog.tags.service;

import panomete.blog.tags.entity.Tags;

import java.util.List;

public interface TagService {
    List<String> getAllTags();
    Tags getTag(String name);
}
