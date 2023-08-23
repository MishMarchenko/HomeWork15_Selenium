package api;

import api.dto.UserBuilder;
import api.steps.UserSteps;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserTest {
    UserSteps userSteps = new UserSteps();
    private UserBuilder user = UserBuilder.builder()
            .id(0)
            .username("Mikho")
            .build();
    @Test
    void shouldBeCreateUser(){
        userSteps.createUser(user);
        var response = userSteps.getUser(user).path("username");
        assertThat(response)
                .as("The status code is not equal 200")
                .isEqualTo(user.getUsername());
    }
}
