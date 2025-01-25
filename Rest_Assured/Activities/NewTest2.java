package Activity2;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class NewTest2 {

    @Test(priority = 1)
    public void addNewUserFromFile() throws IOException {

        
        FileInputStream inputJSON = new FileInputStream("src/test/resources/userInfo.json");

        Response response = given()
            .baseUri("https://petstore.swagger.io/v2/user")
            .header("Content-Type", "application/json")
            .body(inputJSON) // 
            .when().post();
        inputJSON.close();

       
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("9996")); 
    }

    @Test(priority = 2)
    public void getUserInfo() {

        
        File outputJSON = new File("src/test/resources/usergetresponse.json");

        Response response = given()
            .baseUri("https://petstore.swagger.io/v2/user")
            .header("Content-Type", "application/json")
            .pathParam("username", "Tyson") 
            .when().get("/{username}");

        String resBody = response.getBody().asPrettyString();

        try {
            outputJSON.createNewFile();

            FileWriter writer = new FileWriter(outputJSON.getPath());
            writer.write(resBody);
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }

       
        response.then().body("id", equalTo(9996)); 
        response.then().body("username", equalTo("Tyson"));
        response.then().body("firstName", equalTo("TYS"));
        response.then().body("lastName", equalTo("Case"));
        response.then().body("email", equalTo("Tysoncase@mail.com"));
        response.then().body("password", equalTo("password123"));
        response.then().body("phone", equalTo("9812763451"));
    }

    @Test(priority = 3)
    public void deleteUser() throws IOException {
        Response response = given()
            .baseUri("https://petstore.swagger.io/v2/user")
            .header("Content-Type", "application/json")
            .pathParam("username", "Tyson") 
            .when().delete("/{username}");

        
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("Tyson")); 
    }
}
