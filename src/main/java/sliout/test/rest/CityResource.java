package sliout.test.rest;

import com.google.gson.Gson;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sliout.test.service.CityService;
import sliout.test.vo.City;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Serguei on 5/15/2016.
 */
@Path("city")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CityResource {
    @GET
    public String getAll() {
        ApplicationContext cxt = new ClassPathXmlApplicationContext("spring-config.xml");
        CityService service = (CityService) cxt.getBean("service");
        Gson gson = new Gson();
        return gson.toJson(service.getAllCities());
    }

    @GET
    @Path("{id: \\d+}")
    public String get(@PathParam("id") final int id) {
        ApplicationContext cxt = new ClassPathXmlApplicationContext("spring-config.xml");
        CityService service = (CityService) cxt.getBean("service");
        Gson gson = new Gson();
        return gson.toJson(service.getCity(id));
    }

    @POST
    public String store(final String document) {
        ApplicationContext cxt = new ClassPathXmlApplicationContext("spring-config.xml");
        CityService service = (CityService) cxt.getBean("service");
        Gson gson = new Gson();
        City city = gson.fromJson(document,City.class);
        return gson.toJson(service.addCity(city));
    }

}
