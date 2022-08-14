import api.GetOrderData;

import api.PostOrderData;
import api.Specification;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;


public class RestAssuredTest {
    public final static String URL = "https://petstore.swagger.io/v2";

    @Test
    public void checkGetOrder() {
        Specification.getSpecification(Specification.requestSpec(URL), Specification.responseSpec200());
        List<GetOrderData> orders = given()
                .when()
                .contentType(ContentType.JSON)
                .get("/store/order/4")
                .then()
                .log().all()
                .extract().body().jsonPath().getList("data", GetOrderData.class);
        Assert.assertNotNull(orders);
    }

    @Test
    public void postOrder() {
        Specification.getSpecification(Specification.requestSpec(URL), Specification.responseSpec200());
        PostOrderData order = new PostOrderData(1, 0, 0, "2022-08-14T05:24:16.517Z", "placed", true);
        int orderData = given()
                .body(order)
                .when()
                .post("/store/order")
                .then().log().all()
                .extract().statusCode();
        Assert.assertTrue("complete", true);
    }
    @Test
    public void deleteOrder() {
        Specification.getSpecification(Specification.requestSpec(URL), Specification.responseSpec200());
        given()
                .when()
                .delete("v2/store/order/2")
                .then().log().all();

    }


}