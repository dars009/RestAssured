package com.jbk.RestAssuredTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class APITest {

	@Test
	public void test_Md5CheckSumForTest() {

		String originalText = "JBK";
		String expectedMd5CheckSum = "e9b6bc032a1d30230494cf3abc98cfce";

		given().param("text", originalText).when().get("http://md5.jsontest.com").then().assertThat().body("md5",
				equalTo(expectedMd5CheckSum));
	}

	@Test
	public void test_NumberOfCircuitsFor2017Season_ShouldBe20() {

		given().when().get("http://ergast.com/api/f1/2017/circuits.json").then().assertThat()
				.body("MRData.CircuitTable.Circuits.circuitId", hasSize(20));
	}

	@Test
	public void test_ResponseHeaderData_ShouldBeCorrect() {

		given().when().get("http://ergast.com/api/f1/2017/circuits.json").then().assertThat().statusCode(200).and()
				.contentType(ContentType.JSON).and().header("Content-Length", equalTo("4567"));
	}

	@Test
	public void exampleRestDataTest() {
	    given().
	    when().
        get("http://ergast.com/api/f1/2017/circuits.json").
        	then()
	        .statusCode(200)
	        .body("MRData.series", equalTo("f1"))
	        .body("MRData.total", equalTo("20"));
	}
	
	@Test
	public void exampleRestDataTest1() {
	    given().
	    when().
        get("http://restapi.demoqa.com/utilities/weather/city/Pune").
        	then()
	        .statusCode(200)
	        .body("City", equalTo("Pune"))
	        .body("Humidity", equalTo("74 Percent"));
	}
}
