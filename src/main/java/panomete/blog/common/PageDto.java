package panomete.blog.common;

import org.springframework.data.domain.Page;

import java.util.List;

public record PageDto<T>(
        int page,
        int size,
        int totalPage,
        long totalElements,
        boolean hasNext,
        boolean hasPrevious,
        boolean isFirst,
        boolean isLast,
        List<T> contents
) {
    PageDto<T> convertToPageDto(Page page, List<T> contents) {
        return new PageDto<>(
                page.getNumber() + 1,
                page.getSize(),
                page.getTotalPages(),
                page.getTotalElements(),
                page.hasNext(),
                page.hasPrevious(),
                page.isFirst(),
                page.isLast(),
                contents
        );
    }
}
