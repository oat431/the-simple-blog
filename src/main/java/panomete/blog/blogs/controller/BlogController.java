package panomete.blog.blogs.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import panomete.blog.blogs.helper.BlogsHelper;
import panomete.blog.blogs.payload.request.BlogRequest;
import panomete.blog.blogs.payload.response.BlogDto;
import panomete.blog.blogs.service.BlogService;
import panomete.blog.common.PageDto;
import panomete.blog.utils.DtoMapper;

@Controller
@RequestMapping("/api/v1/blogs")
@Tag(name = "Blog API", description = "Blog Main API")
@RequiredArgsConstructor
public class BlogController {
    final BlogService blogService;
    final BlogsHelper blogsHelper;

    @GetMapping("/")
    @Operation(summary = "get all the blogs as pagination")
    public ResponseEntity<PageDto<BlogDto>> getBlogsAsPagination(
            @RequestParam(value = "page", defaultValue = "1", required = false) int page,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size
    ) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        PageDto<BlogDto> response = blogsHelper.convertToPageDto(blogService.getAllBlogs(pageRequest));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/horror")
    @Operation(summary = "get all the blogs as pagination")
    public ResponseEntity<PageDto<BlogDto>> getHorrorBlogsAsPagination(
            @RequestParam(value = "page", defaultValue = "1", required = false) int page,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size
    ) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        PageDto<BlogDto> response = blogsHelper.convertDtoToPageDto(blogService.getOnlyHorrorBlogs(pageRequest));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    @Operation(summary = "get a blog by id")
    public ResponseEntity<BlogDto> getBlogByUUID(@PathVariable("id") String id) {
        return blogsHelper.showResponse(blogService.getBlogById(id));
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

    @PutMapping("/{id}")
    @Operation(summary = "update a blog")
    public ResponseEntity<BlogDto> updateBlog(
            @PathVariable("id") String id,
            @RequestBody BlogRequest request
    ) {
        return new ResponseEntity<>(
                DtoMapper.INSTANCE.toBlogDto(blogService.updateBlog(id, request)),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete a blog")
    public ResponseEntity<BlogDto> deleteBlog(
            @PathVariable("id") String id
    ) {
        BlogDto result = DtoMapper.INSTANCE.toBlogDto(blogService.getBlogById(id));
        blogService.deleteBlog(id);
        return new ResponseEntity<>(
                result,
                HttpStatus.OK
        );
    }
}
