package panomete.blog.blogs.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import panomete.blog.blogs.entity.Blog;
import panomete.blog.blogs.repository.BlogRepository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class BlogDaoImpl implements BlogDao {
    final BlogRepository blogRepository;
    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog getBlogById(UUID id) {
        return blogRepository.findById(id);
    }

    @Override
    public void deleteBlogById(UUID id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> getBlogs(PageRequest pageRequest) {
        return blogRepository.findAll(pageRequest);
    }
}
