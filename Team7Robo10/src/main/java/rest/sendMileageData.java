package rest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.MileageData;

@Path("/motor")
public class sendMileageData {
  
  @GET
  @Path("/mileage/{mileage}/{duration}")
  @Produces(MediaType.APPLICATION_JSON)
  //@Consumes(MediaType.APPLICATION_JSON)
  public MileageData getMileage(@PathParam("mileage") float miles, @PathParam("duration") long time) {
    MileageData mileage=new MileageData(miles,time);
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("speed");
      EntityManager em = emf.createEntityManager();   
      em.getTransaction().begin();
      em.persist(mileage);
      em.getTransaction().commit();
      return mileage;
  }
//  @POST
//  @Path("/mileage")
//  @Produces(MediaType.APPLICATION_JSON)
//  @Consumes(MediaType.APPLICATION_JSON)
//  public MileageData postMileage(MileageData mileage) {
//      EntityManagerFactory emf = Persistence.createEntityManagerFactory("speed");
//      EntityManager em = emf.createEntityManager();
//      em.getTransaction().begin();
//      em.persist(mileage);
//      em.getTransaction().commit();
//      return mileage;
//  }


}