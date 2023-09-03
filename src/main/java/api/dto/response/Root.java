package api.dto.response;

import java.util.ArrayList;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Root {
    public String userId;
    public String username;
    public ArrayList<Book> books;
}
