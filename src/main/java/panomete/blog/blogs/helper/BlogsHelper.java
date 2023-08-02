package panomete.blog.blogs.helper;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import panomete.blog.blogs.entity.Blog;
import panomete.blog.blogs.payload.response.BlogDto;
import panomete.blog.common.PageDto;
import panomete.blog.utils.DtoMapper;

@Component
public class BlogsHelper {
    public PageDto<BlogDto> convertToPageDto(Page<Blog> result) {
        return new PageDto<>(
                result.getNumber() + 1,
                result.getSize(),
                result.getTotalPages(),
                result.getTotalElements(),
                result.hasNext(),
                result.hasPrevious(),
                result.isFirst(),
                result.isLast(),
                DtoMapper.INSTANCE.toBlogDto(result.getContent())
        );
    }

    public ResponseEntity<BlogDto> showResponse(Blog blog) {
        if(blog == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(DtoMapper.INSTANCE.toBlogDto(blog));
    }
}
