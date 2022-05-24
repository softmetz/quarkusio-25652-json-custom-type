package com.acme;

import static io.restassured.RestAssured.given;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
@TestHTTPEndpoint(RestResource.class)
@QuarkusTestResource(WireMockExtensions.class)
class ReproducerTest {

  @Test
  void callGetApplicationJson() {
    given().get("application-json").then().statusCode(204);
  }

  @Test
  void callGetApplicationCustomJson() {
    given().get("application-custom-json").then().statusCode(204);
  }

}
