package panomete.blog.blogs.payload.request;

import java.util.List;

public record BlogRequest(String title, String content, String author, List<String> tags) { }
