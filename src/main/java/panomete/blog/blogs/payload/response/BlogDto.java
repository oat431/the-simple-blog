package panomete.blog.blogs.payload.response;

import java.util.List;

public record BlogDto (
    String id,
    String title,
    String content,
    String author,
    List<String> tags,
    String createdAt,
    String updatedAt
) {}
