package panomete.blog.blogs.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageBlogDto {
    Integer page;
    Integer size;
    Integer totalPages;
    Long totalElements;
    List<BlogDto> blogs;
}
