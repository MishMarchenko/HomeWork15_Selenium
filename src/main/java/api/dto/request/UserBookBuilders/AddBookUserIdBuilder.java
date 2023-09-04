package api.dto.request.UserBookBuilders;

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
    public List<CollectionOfIsbn>collectionOfIsbns;
}
