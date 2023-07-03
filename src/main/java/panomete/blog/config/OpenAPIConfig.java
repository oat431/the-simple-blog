package panomete.blog.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Blogs Basic System",
                version = "1.0.0",
                description = "Blogs Basic System API documentation"
        )
)
public class OpenAPIConfig {
}
