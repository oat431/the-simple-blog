package panomete.blog.blogs.payload.response;

public record BlogDto (
    String id,
    String title,
    String content,
    String author,
    String createdAt,
    String updatedAt
) {}
