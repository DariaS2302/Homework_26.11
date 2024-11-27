package api;

import io.qameta.allure.Step;
import models.LoginRequestModel;
import models.LoginResponseModel;

import static io.restassured.RestAssured.given;
import static specs.Specification.requestSpec;
import static specs.Specification.responseSpec200;

public class AuthorizationApi {

    @Step("Получить авторизационные данные.")
    public static LoginResponseModel getAuthData(String userName, String userPassword) {

        LoginRequestModel request = new LoginRequestModel();
        request.setUserName(userName);
        request.setPassword(userPassword);

        return given()
                .spec(requestSpec)
                .body(request)

                .when()
                .post("/Account/v1/Login")

                .then()
                .spec(responseSpec200)
                .extract().as(LoginResponseModel.class);
    }
}