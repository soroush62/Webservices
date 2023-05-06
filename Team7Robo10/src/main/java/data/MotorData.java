package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="speed")
public class MotorData {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  private int speedA;
  
  public MotorData() {
    
  }
  
  public MotorData(int speedA) {
    this.speedA = speedA;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public int getSpeedA() {
    return speedA;
  }
  
  public void setSpeedA(int speedA) {
    this.speedA = speedA;
  }
}