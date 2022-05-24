package com.acme;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@RequestScoped
@Path("/")
public class RestResource {

  @Inject
  @RestClient
  RESTClient restClient;

  @GET
  @Path("application-json")
  @Consumes("application/json")
  public Response clientWithApplicationJson() {

    SomePojo somePojo = new SomePojo();
    somePojo.setSome("foo");
    somePojo.setPojo("bar");

    restClient.sendPostWithApplicationJson(somePojo);

    return Response.noContent().build();

  }

  @GET
  @Path("application-custom-json")
  @Consumes("application/json")
  public Response clientWithApplicationCustomJson() {

    SomePojo somePojo = new SomePojo();
    somePojo.setSome("foo");
    somePojo.setPojo("bar");

    restClient.sendPostWithCustomJsonContentType(somePojo);

    return Response.noContent().build();

  }

}
