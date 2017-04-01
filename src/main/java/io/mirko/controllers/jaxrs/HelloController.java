package io.mirko.controllers.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

@Component
@Path("/hello")
public class HelloController {
    @GET
    public String message() {
        return "Hello World";
    }

}
