package panomete.blog.utils;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import panomete.blog.blogs.entity.Blog;
import panomete.blog.blogs.payload.response.BlogDto;

import java.util.List;

@Mapper
public interface DtoMapper {
    DtoMapper INSTANCE = Mappers.getMapper(DtoMapper.class);

    @Mapping(target = "tags", expression = "java(blog.getTags().stream().map(t -> t.getName()).toList())")
    BlogDto toBlogDto(Blog blog);
    List<BlogDto> toBlogDto(List<Blog> blogs);
}
