package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="mileage")
public class MileageData {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private float mileage;
    private long duration;

    public MileageData() {}

    public MileageData(float mileage, long duration) {
        this.mileage = mileage;
        this.duration = duration;
    }

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}