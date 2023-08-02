package panomete.blog.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import panomete.blog.blogs.entity.Blog;
import panomete.blog.blogs.repository.BlogRepository;
import panomete.blog.tags.entity.Tags;
import panomete.blog.tags.repository.TagRepository;

import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
@Slf4j
public class ApplicationConfig implements ApplicationListener<ApplicationReadyEvent> {
    final BlogRepository blogRepository;
    final TagRepository tagRepository;

    // create 10 unique title with 40 to 50 characters
    private String[] contents = {
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
//        mockTag();
//        mockBlog();
//        mockFinishBlog();
        log.info("======application is ready======");
    }

    private void mockBlog() {
        log.info("======mocking blog======");
        List<Tags> tags = tagRepository.findAll();
        for (int i = 0; i < 10; i++) {
            blogRepository.save(
                    Blog.builder()
                            .title("title" + (i + 1))
                            .content(contents[i])
                            .build()
            );
        }
        log.info("======mocking blog is done======");
    }

    private void mockTag() {
        log.info("======mocking tags======");
        tagRepository.save(
                Tags.builder()
                        .name("fantasy")
                        .description("just fantasy")
                        .build()
        );
        tagRepository.save(
                Tags.builder()
                        .name("horror")
                        .description("horror tag")
                        .build()
        );
        tagRepository.save(
                Tags.builder()
                        .name("romance")
                        .description("romance story")
                        .build()
        );
        log.info("======mocking tags is done======");
    }

    private void mockFinishBlog() {
        log.info("======mocking finish blog======");
        List<Tags> tags = tagRepository.findAll();
        List<Blog> blogs = blogRepository.findAll();
        Random random = new Random();
        for (Blog value : blogs) {
            List<Tags> randomTags = tags.subList(0, random.nextInt(tags.size()));
            value.setTags(randomTags);
            blogRepository.save(value);
        }
        log.info("======mocking finish blog is done======");
    }
}
