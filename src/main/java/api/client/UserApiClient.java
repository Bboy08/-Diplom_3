package api.client;

import api.model.CreateUserRequest;
import io.qameta.allure.Step;
import io.restassured.response.Response;



public class UserApiClient extends BaseApiClient{
    @Step("Создать пользователя")
    public Response createUser(CreateUserRequest createUserRequest) {
        return getPostSpec()
                .body(createUserRequest)
                .when()
                .post(BASE_URL + "/api/auth/register");
    }
    @Step("Удалить пользователя")
    public Response deleteUser(String accessToken) {
        return getPostSpec()
                .when()
                .auth().oauth2(accessToken)
                .delete(BASE_URL + "/api/auth/user");
    }
    @Step("Залогиниться")
    public Response loginUser(CreateUserRequest createUserRequest) {
        return getPostSpec()
                .body(createUserRequest)
                .when()
                .post(BASE_URL + "/api/auth/login");
    }

}
