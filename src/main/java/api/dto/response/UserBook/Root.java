package api.dto.response.UserBook;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Root{
    public ArrayList<BookIsbnResponseBuilder> books;
}


