package panomete.blog.blogs.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import panomete.blog.tags.entity.Tags;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @Column(nullable = false, unique = true)
    String title;

    @Column(nullable = false, length = 1024)
    String content;

    @Builder.Default
    String author = "Anonymous";

    @CreatedDate
    Date createdAt;

    @LastModifiedDate
    Date updatedAt;

    @ManyToMany(cascade = CascadeType.ALL)
    @Builder.Default
    List<Tags> tags = new ArrayList<>();
}
