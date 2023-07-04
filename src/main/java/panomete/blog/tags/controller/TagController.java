package panomete.blog.tags.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import panomete.blog.tags.service.TagService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Tag(name = "Tag API", description = "Tag API")
@RequestMapping("/api/v1/tags")
public class TagController {
    final TagService tagService;

    @GetMapping("/")
    @Operation(summary = "get all the tags in the platform")
    public ResponseEntity<List<String>> getAllTags() {
        return new ResponseEntity<>(
                tagService.getAllTags(),
                HttpStatus.OK
        );
    }
}
