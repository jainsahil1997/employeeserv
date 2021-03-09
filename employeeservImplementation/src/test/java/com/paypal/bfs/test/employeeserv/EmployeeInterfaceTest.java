package com.paypal.bfs.test.employeeserv;

import static org.junit.Assert.assertThat;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import io.restassured.RestAssured;
@RunWith(SpringRunner.class)
@SpringBootTest(classes={com.paypal.bfs.test.employeeserv.EmployeeservApplication.class})
public class EmployeeInterfaceTest {

    @MockBean
    private EmployeeService employeeService;
    @Test
    public void post_test1() throws Exception {
        String param="{\"id\":\"1\",\"first_name\":\"Sahil\",\"last_name\":\"Jain\",\"date_of_birth\":\"1997-06-19\",\"address_line1\":\"KingsRoad\",\"address_line2\":\"9/7\",\"city\":\"Howrah\",\"state\":\"WB\",\"country\":\"India\",\"zip_code\":\"711101\"}";
        RestAssured.baseURI ="http://localhost:8080/v1/bfs/";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(param);
        Response response = request.post("/employee");
        System.out.println(response.getStatusCode());
        response.getStatusCode();
        Assert.assertNotEquals(String.valueOf(response.getStatusCode()),200, response.getStatusCode());
    }
    @Test
    public void get_test1() throws Exception {
        RestAssured.baseURI ="http://localhost:8080/v1/bfs/";
        RequestSpecification request = RestAssured.given();
        Response response=request.get("/employees/1");
        System.out.println(response.getStatusCode());
        response.getStatusCode();
        Assert.assertEquals(String.valueOf(response.getStatusCode()),200, response.getStatusCode());
    }
    @Test
    public void get_test2() throws Exception {
        RestAssured.baseURI ="http://localhost:8080/v1/bfs/";
        RequestSpecification request = RestAssured.given();
        Response response=request.get("/employees/10");
        System.out.println(response.getStatusCode());
        response.getStatusCode();
        Assert.assertEquals(String.valueOf(response.getStatusCode()),404, response.getStatusCode());
    }
    @Test
    public void post_test2() throws Exception {
        String param="{\"first_name\":\"Sahil\",\"last_name\":\"Jain\",\"date_of_birth\":\"1997-06-19\",\"address_line1\":\"KingsRoad\",\"address_line2\":\"9/7\",\"city\":\"Howrah\",\"state\":\"WB\",\"country\":\"India\",\"zip_code\":\"711101\"}";
        RestAssured.baseURI ="http://localhost:8080/v1/bfs/";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(param);
        Response response = request.post("/employee");
        System.out.println(response.getStatusCode());

        Assert.assertEquals(String.valueOf(response.getStatusCode()),400, response.getStatusCode());
    }
}

