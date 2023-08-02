package panomete.blog.common;

import java.util.List;

public record PageDto<T>(
        int page,
        int size,
        int totalPage,
        long totalElements,
        List<T> contents
) {

}
