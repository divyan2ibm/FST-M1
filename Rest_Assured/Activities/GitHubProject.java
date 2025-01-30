package Activity1;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.*;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class GitHubProject {
    
    String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIH0xs+uKABKyEyciYC8GbVEMKxSoa2fh+c4i/BfXnLxC";
    int sshKeyId;
   
    RequestSpecification requestSpec = new RequestSpecBuilder().
            setBaseUri("https://api.github.com/user/keys").addHeader("Authorization", "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").
            addHeader("Content-Type", "application/json").
            build();

    
    ResponseSpecification responseSpec = new ResponseSpecBuilder().
            expectResponseTime(lessThan(4000L)).expectBody("key", equalTo(sshKey)).
            expectBody("title", equalTo("TestAPIKey")).
            build();


    @Test(priority = 1)
    public void postRequestTest() {
       
        Map<String,String> reqBody = new HashMap<>();
        reqBody.put("title","TestAPIKey");
        reqBody.put("key",sshKey);

        
        Response response = given().spec(requestSpec).body(reqBody).when().post();

      
        sshKeyId =response.then().extract().path("id");
        if (sshKey!=null){
        response.then().statusCode(201).spec(responseSpec);}
        else{
            throw new RuntimeException("Failed to to get ID");
        }

    }
    @Test(priority = 2)
    public void getRequestTest(){
       
        given().spec(requestSpec).pathParam("keyId", sshKeyId).when().get("/{keyId}").then().statusCode(200)
                .spec(responseSpec);
    }

    @Test(priority = 3)
    public void deleteRequestTest() {
        given().spec(requestSpec).pathParam("keyId", sshKeyId).when().delete("/{keyId}").then().statusCode(204);
    }
}
