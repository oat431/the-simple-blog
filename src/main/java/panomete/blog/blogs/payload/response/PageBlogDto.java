package panomete.blog.blogs.payload.response;

import java.util.List;

public record PageBlogDto (
    Integer page,
    Integer size,
    Integer totalPages,
    Long totalElements,
    List<BlogDto> blogs
) {}
