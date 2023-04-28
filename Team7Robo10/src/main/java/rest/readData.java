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

import data.MotorData;

@Path("/tadaa")
public class readData {
	@GET
	@Path("/tuduu")
	@Produces(MediaType.APPLICATION_JSON)
	public String getSpeed() {
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("speed");
	    EntityManager em = emf.createEntityManager();
	    TypedQuery<MotorData> query = em.createQuery("SELECT m FROM MotorData m", MotorData.class);
	    List<MotorData> motorDataList = query.getResultList();
	    MotorData motorData = motorDataList.get(0);
	    int speedA = motorData.getSpeedA();
	    return ""+speedA; //convert return to integer
	}
}
