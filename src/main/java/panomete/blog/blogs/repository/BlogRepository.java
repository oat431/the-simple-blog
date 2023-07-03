package panomete.blog.blogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import panomete.blog.blogs.entity.Blog;

import java.util.UUID;

public interface BlogRepository extends JpaRepository<Blog,Long> {
    Blog findById(UUID id);
    void deleteById(UUID id);
}
