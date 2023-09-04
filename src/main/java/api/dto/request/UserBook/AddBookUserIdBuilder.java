package api.dto.request.UserBook;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddBookUserIdBuilder {
    public String userId;
    public List<CollectionOfIsbn> CollectionOfIsbn;
}
