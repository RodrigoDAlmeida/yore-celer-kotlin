import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent
import com.yore.celes.dto.UserInput
import com.yore.celes.lambda.CreateUser
import com.yore.celes.lambda.GetUser
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class UserTest {
    @Test
    fun testUserCreate(){
        /*
        Content-Type: application/json
                {
                    "name": "Rodrigo",
                    "email": "rodrigo@test.com",
                    "login": "rod",
                    "password": "123"
                }
*/

        var createUser = CreateUser();
        var input = UserInput();
        input.name = "Test";
        input.login = "test";
        input.password = "test123"
        input.email = "test@test.com";


        var output = createUser.handleRequest(input, null);

        var expected = APIGatewayProxyResponseEvent()
            .withStatusCode(201)
            .withBody("User created!success");

        assertEquals(output, expected);

    }

    @Test
    fun testUserGet() {
        var output = GetUser().handleRequest("b7307e57-19e9-44a0-978e-0b0362f990e9",null);

        assertEquals(output.statusCode, 200);
    }

}