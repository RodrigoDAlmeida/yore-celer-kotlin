import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent
import com.yore.celes.dto.UserInput
import com.yore.celes.lambda.CreateUser
import com.yore.celes.model.User
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class UserTest {
    @Test
    fun testUserCreate(){
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
}