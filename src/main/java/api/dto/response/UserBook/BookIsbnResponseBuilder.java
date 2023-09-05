package api.dto.response.UserBook;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookIsbnResponseBuilder {
    public String isbn;
}
