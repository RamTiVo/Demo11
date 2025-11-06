package demo;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

public class FirstLambdaHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent>{
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context){
        LambdaLogger logger = context.getLogger();
        logger.log("INPUT: "+event.getBody());
        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
        responseEvent.setBody("Modified Response "+event.getBody());
        logger.log("OUTPUT: "+responseEvent.getBody());
        return responseEvent;


    }
}
