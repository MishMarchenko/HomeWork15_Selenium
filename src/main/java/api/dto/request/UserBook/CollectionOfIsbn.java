package api.dto.request.UserBook;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CollectionOfIsbn {
    public String isbn;
}