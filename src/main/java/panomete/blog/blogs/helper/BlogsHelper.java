package panomete.blog.blogs.helper;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import panomete.blog.blogs.entity.Blog;
import panomete.blog.blogs.payload.response.BlogDto;
import panomete.blog.common.PageDto;
import panomete.blog.utils.BaseHelper;
import panomete.blog.utils.DtoMapper;

@Component
public class BlogsHelper implements BaseHelper<BlogDto,Blog> {
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

    @Override
    public PageDto<BlogDto> convertDtoToPageDto(Page<BlogDto> result) {
        return new PageDto<>(
                result.getNumber() + 1,
                result.getSize(),
                result.getTotalPages(),
                result.getTotalElements(),
                result.hasNext(),
                result.hasPrevious(),
                result.isFirst(),
                result.isLast(),
                result.getContent()
        );
    }

    public ResponseEntity<BlogDto> showResponse(Blog result) {
        if(result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(DtoMapper.INSTANCE.toBlogDto(result));
    }

}
