package api.dto.response.UserBook;

import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserWithBookResponseBuilder {
    public String userId;
    public String username;
    public List<BookResponseBuilder> books;
}
