package specs;

import io.restassured.specification.RequestSpecification;

import static extensions.AllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;

public class RequestSpec {
    public static final RequestSpecification requestSpec = with()
            .filter(withCustomTemplates())
            .log().all()
            .contentType("application/json");
}