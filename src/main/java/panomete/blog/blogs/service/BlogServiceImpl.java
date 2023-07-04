package panomete.blog.blogs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import panomete.blog.blogs.dao.BlogDao;
import panomete.blog.blogs.entity.Blog;
import panomete.blog.blogs.payload.request.BlogRequest;
import panomete.blog.tags.dao.TagDao;
import panomete.blog.tags.entity.Tags;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {
    final BlogDao blogDao;
    final TagDao tagDao;

    @Override
    public Page<Blog> getAllBlogs(PageRequest pageRequest) {
        return blogDao.getBlogs(pageRequest);
    }

    @Override
    public Blog getBlogById(String id) {
        return blogDao.getBlogById(UUID.fromString(id));
    }

    @Override
    public Blog createBlog(BlogRequest blog) {
        return blogDao.saveBlog(
                Blog.builder()
                        .title(blog.title())
                        .content(blog.content())
                        .author(blog.author())
                        .tags(getTags(blog.tags()))
                        .build()
        );
    }

    private List<Tags> getTags(List<String> tags) {
        List<Tags> result = new ArrayList<>();
        for (String tag : tags) {
            Tags t = tagDao.getTag(tag);
            if (t == null) {
                t = tagDao.createTag(tag);
            }
            result.add(t);
        }
        return result;
    }

    @Override
    public Blog updateBlog(String id, BlogRequest blog) {
        Blog oldBlog = blogDao.getBlogById(UUID.fromString(id));
        oldBlog.setTitle(blog.title());
        oldBlog.setContent(blog.content());
        oldBlog.setAuthor(blog.author());
        oldBlog.setTags(getTags(blog.tags()));
        return blogDao.saveBlog(oldBlog);
    }

    @Override
    public void deleteBlog(String id) {
        blogDao.deleteBlogById(UUID.fromString(id));
    }
}
