import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

public class ApiTests {
    private static final String PARAM_KEY1 = "foo1";
    private static final String PARAM_KEY2 = "foo2";
    private static final String PARAM_VALUE1 = "bar1";
    private static final String PARAM_VALUE2 = "bar2";
    private static final String PARAM_KEY3 = "bar3";
    private static final String PARAM_VALUE3 = "foo3";
    private static final String PARAM_KEY4 = "bar4";
    private static final String PARAM_VALUE4 = "foo4";
    private static final String PARAM_KEY5 = "";
    private static final String PARAM_VALUE5 = "foo5";
    private static final String PARAM_KEY5_REPLACE = "bar5";

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://postman-echo.com/";
    }

    @Test
    @DisplayName("GET - Проверка существующей записи")
    public void verifyExistingRecord() {
        given().get("/get?" + PARAM_KEY1 + "=" + PARAM_VALUE1 + "&" + PARAM_KEY2 + "=" + PARAM_VALUE2)
                .then().statusCode(200)
                .assertThat().body("args." + PARAM_KEY1, equalTo(PARAM_VALUE1))
                .assertThat().body("args." + PARAM_KEY2, equalTo(PARAM_VALUE2));
    }

    @Test
    @DisplayName("POST - Создание новой записи")
    public void createNewRecord() {
        String json = "{ \"" + PARAM_KEY1 + "\": \"" + PARAM_VALUE1 + "\", \"" + PARAM_KEY2 + "\": \"" + PARAM_VALUE2 + "\"}";

        given().header("Content-type", "application/json")
                .body(json)
                .post("/post")
                .then().statusCode(200)
                .and()
                .assertThat().body("json." + PARAM_KEY1, equalTo(PARAM_VALUE1))
                .assertThat().body("json." + PARAM_KEY2, equalTo(PARAM_VALUE2));
    }

    @Test
    @DisplayName("POST - Ошибка из-за отсутствия заголовка")
    public void postWithoutHeaderShouldFail() {
        String json = "{ \"" + PARAM_KEY1 + "\": \"" + PARAM_VALUE1 + "\", \"" + PARAM_KEY2 + "\": \"" + PARAM_VALUE2 + "\"}";

        given()
                .body(json)
                .post("/post")
                .then().statusCode(200)
                .and()
                .assertThat().body("json", nullValue());
    }

    @Test
    @DisplayName("PUT - Обновление записи")
    public void updateRecord() {
        String json = "{ \"" + PARAM_KEY3 + "\": \"" + PARAM_VALUE3 + "\", \"" + PARAM_KEY4 + "\": \"" + PARAM_VALUE4 + "\"}";

        given().header("Content-type", "application/json")
                .body(json)
                .put("/put")
                .then().statusCode(200)
                .assertThat().body("data." + PARAM_KEY3, equalTo(PARAM_VALUE3))
                .assertThat().body("data." + PARAM_KEY4, equalTo(PARAM_VALUE4));
    }

    @Test
    @DisplayName("PATCH - Частичное обновление записи")
    public void partiallyUpdateRecord() {
        String json1 = "{ \"" + PARAM_KEY5 + "\": \"" + PARAM_VALUE5 + "\"}";

        given().header("Content-type", "application/json")
                .body(json1)
                .put("/put")
                .then().statusCode(200);

        String json2 = "{ \"" + PARAM_KEY5 + "\": \"" + PARAM_KEY5_REPLACE + "\"}";
        given().header("Content-type", "application/json")
                .body(json2)
                .patch("/patch")
                .then().statusCode(200);
    }

    @Test
    @DisplayName("DELETE - Удаление записи")
    public void deleteRecord() {
        String json = "{ \"" + PARAM_KEY5 + "\": \"" + PARAM_KEY5_REPLACE + "\"}";

        given().header("Content-type", "application/json")
                .body(json)
                .delete("/delete")
                .then().statusCode(200);
    }
}
