package panomete.blog.blogs.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import panomete.blog.blogs.entity.Blog;
import panomete.blog.blogs.payload.request.BlogRequest;
import panomete.blog.blogs.payload.response.BlogDto;

public interface BlogService {
    Page<Blog> getAllBlogs(PageRequest pageRequest);
    Page<BlogDto> getOnlyHorrorBlogs(PageRequest pageRequest);
    Blog getBlogById(String id);
    Blog createBlog(BlogRequest blog);
    Blog updateBlog(String id, BlogRequest blog);
    void deleteBlog(String id);
}
