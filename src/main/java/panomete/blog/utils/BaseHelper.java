package panomete.blog.utils;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import panomete.blog.common.PageDto;

public interface BaseHelper<T,G> {
    PageDto<T> convertToPageDto(Page<G> result);
    ResponseEntity<T> showResponse(G result);
}
