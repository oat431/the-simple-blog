package panomete.blog.blogs.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import panomete.blog.blogs.entity.Blog;
import panomete.blog.blogs.payload.response.BlogDto;

import java.util.UUID;

public interface BlogDao {
    Blog saveBlog(Blog blog);
    Blog getBlogById(UUID id);
    void deleteBlogById(UUID id);
    Page<Blog> getBlogs(PageRequest pageRequest);

    Page<BlogDto> fetchOnlyHorror(PageRequest pageRequest);
}
