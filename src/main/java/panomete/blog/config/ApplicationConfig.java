package panomete.blog.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import panomete.blog.blogs.entity.Blog;
import panomete.blog.blogs.repository.BlogRepository;

@Component
@RequiredArgsConstructor
@Slf4j
public class ApplicationConfig implements ApplicationListener<ApplicationReadyEvent> {
    final BlogRepository blogRepository;

    // create 10 unique title with 40 to 50 characters
    private String[] titles = {
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
            "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium.",
            "At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque.",
            "Et harum quidem rerum facilis est et expedita distinctio.",
            "Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat.",
            "Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam.",
            "Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur.",
            "Vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?",
            "At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque.",
            "Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat."
    };

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
//        mockBlog();
        log.info("======application is ready======");
    }

    private void mockBlog() {
        log.info("======mocking blog======");
        for (int i = 0; i < 10; i++) {
            blogRepository.save(
                    Blog.builder()
                            .title(titles[i])
                            .content("content")
                            .build()
            );
        }
        log.info("======mocking blog is done======");
    }
}
