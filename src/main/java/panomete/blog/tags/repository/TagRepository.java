package panomete.blog.tags.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import panomete.blog.tags.entity.Tags;

public interface TagRepository extends JpaRepository<Tags, Long> {
    Tags findByName(String name);
}
