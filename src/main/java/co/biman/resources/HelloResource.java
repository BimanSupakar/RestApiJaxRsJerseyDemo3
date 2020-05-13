package co.biman.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
public class HelloResource {
	
	
	@GET
	@Produces({"text/plain"})
	public String greet() {
		return "Hello, from Vinod!";
	}
	
	@GET
	@Produces({"application/xml"})
	public String greetAsXml() {
		return "<?xml version=\"1.0\" ?>\n" + 
				"\n" + 
				"<greeting>\n" + 
				"	<message>Hello, World</message>\n" + 
				"	<from>Biman</from>\n" + 
				"</greeting>";
	}
	
	@GET
	@Produces({"application/json"})
	public String greetAsJson() {
		return "{\n" + 
				"	\"message\": \"Hello, World\",\n" + 
				"	\"from\": \"Supakar\"\n" + 
				"}";
	}
}