package panomete.blog.blogs.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import panomete.blog.blogs.entity.Blog;
import panomete.blog.blogs.payload.request.BlogRequest;
import panomete.blog.blogs.payload.response.BlogDto;
import panomete.blog.blogs.payload.response.PageBlogDto;
import panomete.blog.blogs.service.BlogService;
import panomete.blog.utils.DtoMapper;

@Controller
@RequestMapping("/api/v1/blogs")
@Tag(name = "Blog API", description = "Blog Main API")
@RequiredArgsConstructor
public class BlogController {
    final BlogService blogService;

    @GetMapping("/")
    @Operation(summary = "get all the blogs as pagination")
    public ResponseEntity<PageBlogDto> getBlogsAsPagination(
            @RequestParam(value = "page", defaultValue = "1", required = false) int page,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size
    ) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<Blog> result = blogService.getAllBlogs(pageRequest);
        PageBlogDto response = PageBlogDto.builder()
                .page(page)
                .size(size)
                .totalElements(result.getTotalElements())
                .totalPages(result.getTotalPages())
                .blogs(DtoMapper.INSTANCE.toBlogDto(result.getContent()))
                .build();
        return new ResponseEntity<>(
                response,
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    @Operation(summary = "get a blog by id")
    public ResponseEntity<BlogDto> getBlogByUUID(
            @PathVariable("id") String id
    ) {
        return new ResponseEntity<>(
                DtoMapper.INSTANCE.toBlogDto(blogService.getBlogById(id)),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    @Operation(summary = "create a blog")
    public ResponseEntity<BlogDto> createBlog(
            @RequestBody BlogRequest request
    ) {
        return new ResponseEntity<>(
                DtoMapper.INSTANCE.toBlogDto(blogService.createBlog(request)),
                HttpStatus.CREATED
        );
    }
}
