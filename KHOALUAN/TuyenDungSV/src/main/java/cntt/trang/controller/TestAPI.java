package cntt.trang.controller;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestAPI {
	JSONObject json = new JSONObject("{ 'UserName':'18T1021326' , 'Password':'b027a4ee25b6cfde014f2083563929fa' }");
	
//	@CrossOrigin(maxAge = 8080)
	@RequestMapping(value = "http://ums-dev.husc.edu.vn/apigateway/account/v1/authorize/student",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE, 
			headers ={
					"content-type=application/json",
					"ums-application=TestApp",
					"ums-time=20220401230000",
					"ums-signature=1adcbf88065227d7c8cdbaf25be7aa00"
					}
			)
    @ResponseBody
    public JSONObject test(@RequestBody JSONObject json, HttpServletResponse res) {
		System.out.println(res);
        return (JSONObject) res;
     }
}
