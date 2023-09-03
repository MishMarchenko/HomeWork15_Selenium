package api.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.ArrayList;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersBooksResponseBuilder {
    public ArrayList<BookIsbnResponseBuilder> BookIsbnResponseBuilder;

}
