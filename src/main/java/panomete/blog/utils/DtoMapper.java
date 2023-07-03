package panomete.blog.utils;

import org.mapstruct.factory.Mappers;
import panomete.blog.blogs.entity.Blog;
import panomete.blog.blogs.payload.response.BlogDto;

public interface DtoMapper {
    DtoMapper INSTANCE = Mappers.getMapper(DtoMapper.class);

    BlogDto toBlogDto(Blog blog);
}
