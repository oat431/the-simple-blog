package panomete.blog.blogs.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import panomete.blog.blogs.payload.response.BlogDto;

import java.util.Collections;
import java.util.List;

@SpringBootTest
public class BlogRepositoryQueryTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void fetchOnlyHorrorBlogs() {
        StringBuilder sql = new StringBuilder();
        sql.append("select");
        sql.append(" blog.id,");
        sql.append(" title,");
        sql.append(" content,");
        sql.append(" author,");
        sql.append(" STRING_AGG(tags.name, ', ') AS tags,");
        sql.append(" blog.created_at,");
        sql.append(" blog.updated_at");
        sql.append(" from blog");
        sql.append(" join blog_tags on blog_id = id");
        sql.append(" join tags on tags_id = tags.id");
        sql.append(" where");
        sql.append(" exists (");
        sql.append(" select 1 from blog_tags");
        sql.append(" join tags on tags_id = tags.id");
        sql.append(" where blog_id = blog.id and tags.name = 'horror')");
        sql.append(" group by blog.id;");
        List<BlogDto> result = jdbcTemplate.query(sql.toString(), (rs, rowNum) -> {
            BlogDto blog = new BlogDto(
                    rs.getString("id"),
                    rs.getString("title"),
                    rs.getString("content"),
                    rs.getString("author"),
                    Collections.singletonList(rs.getString("tags")),
                    rs.getString("created_at"),
                    rs.getString("updated_at")
            );
            return blog;
        });
        for(BlogDto blogDto : result) {
            System.out.println(blogDto);
        }
    }
}