package api;

import api.dto.request.UserBuilder;
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
        var username = userSteps.getUser(user.getUsername());
        assertThat(username.getUsername()).as("Wrong user name").isEqualTo(user.getUsername());
//        assertThat(response.getCode()).as("Wrong status code").isEqualTo(200);
//        assertThat(response.getType()).as("The type is not unknown").isEqualTo("unknown");
//        var response = userSteps.getUser(user, user.getUsername()).path("username");
//        assertThat(response)
//                .as("The status code is not equal 200")
//                .isEqualTo(user.getUsername());
    }
}
