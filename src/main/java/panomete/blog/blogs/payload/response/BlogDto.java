package panomete.blog.blogs.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {
    String id;
    String title;
    String content;
    String author;
    String createdAt;
    String updatedAt;
}
