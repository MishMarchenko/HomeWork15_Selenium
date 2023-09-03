package api.dto.request;

import java.util.ArrayList;

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
    public ArrayList<AddBookIsbnBuilder> AddBookIsbnBuilder;
}
