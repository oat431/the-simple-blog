package panomete.blog.blogs.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import panomete.blog.blogs.payload.response.BlogDto;

import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BlogDBHelper {
    final JdbcTemplate jdbcTemplate;

    public List<BlogDto> fetchOnlyHorrorBlogs() {
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
        return jdbcTemplate.query(sql.toString(), (rs, rowNum) -> {
            return new BlogDto(
                    rs.getString("id"),
                    rs.getString("title"),
                    rs.getString("content"),
                    rs.getString("author"),
                    Collections.singletonList(rs.getString("tags")),
                    rs.getString("created_at"),
                    rs.getString("updated_at")
            );
        });
    }
}
//select
//        blog.id,
//        title,
//        content,
//        author,
//        STRING_AGG(tags.name, ', ') AS tags,
//        blog.created_at,
//        blog.updated_at
//        from blog
//        join blog_tags on blog_id = id
//        join tags on tags_id = tags.id
//        where
//        exists (
//        select 1 from blog_tags
//        join tags on tags_id = tags.id
//        where blog_id = blog.id and tags.name = 'horror'
//        )
//        group by
//        blog.id
//        ;
