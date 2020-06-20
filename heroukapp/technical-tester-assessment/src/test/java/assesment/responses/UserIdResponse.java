package assesment.responses;

import cucumber.deps.com.thoughtworks.xstream.mapper.Mapper;
import io.restassured.path.json.JsonPath;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import assesment.base.BaseAPI;

import static org.hamcrest.core.Is.is;

public class UserIdResponse extends BaseAPI {

    private static Logger logger = LoggerFactory.getLogger(UserIdResponse.class);

    public static void assertSuccesfullUserResponsebyId(int id) {
        assertJsonIntegerAttributeGetResponse("id",id);
    }

    public static void assertSuccesfullListUsers() {
        JsonPath jsonPathEvaluator = responseGet.jsonPath();
        Integer userArraySize = jsonPathEvaluator.getList("$").size();
        logger.info("\n The user list Array is of size " + userArraySize);
        for(int i= 0;i <userArraySize; i++) {
            if(jsonPathEvaluator.getString("id["+i+"]") == ""){
                logger.info("The Array element for ID null is "+ i);
            }
        }
    }

    public static void assertSuccesfullListUsersbyCity(String city) {
        JsonPath jsonPathEvaluator = responseGet.jsonPath();
        if (jsonPathEvaluator.getList("$").size() == 0) {
            logger.info("\n******There is no user data for CITY " + city);
        }
    }
}//end of array
