package api;

import api.dto.request.UserBuilder;
import api.steps.UserSteps;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserTest {
    UserSteps userSteps = new UserSteps();
    private final String userName = "Mikho";
    private final String changeUserName = "Mishanko";
    private final String lastName = "BigBro";

    @Test
    void operationCRUDWithUser(){
        userSteps.createUser(UserBuilder.builder()
                .id(0)
                .username(userName)
                .build());
        userSteps.changeUserWithSchema(UserBuilder.builder()
                .id(0)
                .username(changeUserName)
                .lastname(lastName)
                .build());
        userSteps.deleteUser(changeUserName);
        var changedUserName = userSteps.getNotFoundUser(changeUserName);
        assertThat(changedUserName.getMessage()).as("User was found").isEqualTo("User not found");
    }
}
