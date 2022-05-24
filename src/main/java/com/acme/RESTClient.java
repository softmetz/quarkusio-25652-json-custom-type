package com.acme;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "custom-json-rest-client")
public interface RESTClient {

  @POST
  @Consumes("application/json")
  @Path("hello")
  Response sendPostWithApplicationJson(SomePojo somePojo);

  @POST
  @Consumes("application/custom+json")
  @Path("hello")
  Response sendPostWithCustomJsonContentType(SomePojo somePojo);
}
