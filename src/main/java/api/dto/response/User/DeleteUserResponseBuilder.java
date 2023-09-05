package api.dto.response.User;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeleteUserResponseBuilder {
    Integer code;
    String type;
    String message;
}
