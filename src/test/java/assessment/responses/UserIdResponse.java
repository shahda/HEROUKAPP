package assessment.responses;

import io.restassured.path.json.JsonPath;
import org.json.JSONObject;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import assessment.base.BaseAPI;

import static org.hamcrest.core.Is.is;

public class UserIdResponse extends BaseAPI {

    private static Logger logger = LoggerFactory.getLogger(UserIdResponse.class);

    public static void assertSuccesfullUserResponsebyId(int id) {
        JSONObject response = new JSONObject(responseGet.getBody().asString());

        if (response instanceof JSONObject)
          assertJsonIntegerAttributeGetResponse("id",id);
        else {
            logger.info("\n The return object for user id is more than two elements " + id);
            Assert.assertFalse(true);
        }
    }

    public static void assertSuccesfullListUsers() {
        JsonPath jsonPathEvaluator = responseGet.jsonPath();
        Integer userArraySize = jsonPathEvaluator.getList("$").size();
        int[] nullArray = new int[userArraySize];
        logger.info("\n The user list Array is of size " + userArraySize);
        Boolean flag = false;
        for(int i= 0;i < userArraySize; i++) {
            if(jsonPathEvaluator.getString("id["+i+"]") == null){
                logger.info("\n The Array element for ID null is "+ i);
                flag = true;
            }
        }
        if(flag){
            logger.info("\n The id field for array element is null ");
            Assert.assertFalse(flag);
        }
        else {
            logger.info("\n The id field for all users is not null ");
        }
    }

    public static void assertSuccesfullListUsersbyCity(String city) {
        JsonPath jsonPathEvaluator = responseGet.jsonPath();
        if (jsonPathEvaluator.getList("$").size() == 0) {
            logger.info("\n******There is no user data for CITY " + city);
        }
    }
}//end of array
