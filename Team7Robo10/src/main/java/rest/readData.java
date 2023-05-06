package rest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

import data.MileageData;
import data.MotorData;

@Path("/tadaa")
public class readData {
  @GET
  @Path("/tuduu")
  @Produces(MediaType.APPLICATION_JSON)
  public String getSpeed() {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("speed"); //to execute a query to retrieve MotorData objects from the database
      EntityManager em = emf.createEntityManager();
      TypedQuery<MotorData> query = em.createQuery("SELECT m FROM MotorData m", MotorData.class);
      List<MotorData> motorDataList = query.getResultList();
      MotorData motorData = motorDataList.get(motorDataList.size() - 1);
      int speedA = motorData.getSpeedA();
      return ""+speedA; //convert return to integer
  }
  
  
  //Reading all the rows from table Book.
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MileageData> readAllMileage() {
    //Create an EntityManagerFactory with the settings from persistence.xml file
      EntityManagerFactory emf=Persistence.createEntityManagerFactory("speed");
      //And then EntityManager, which can manage the entities.
      EntityManager em=emf.createEntityManager();
      
      //Read all the rows from table Book. Here the Book must start with capital, 
      //because class's name starts. This returns a List of Book objects.
      List<MileageData> list=em.createQuery("select a from MileageData a").getResultList();
      return list;
    }
}