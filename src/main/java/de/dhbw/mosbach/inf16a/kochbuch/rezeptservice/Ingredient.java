package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Patrick Eichert
 * @author Theresa Reus
 * @author André Berberich
 *
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    @Column(length = 48)
    private String name;

    @NonNull
    private int unit;

    @NonNull
    private double kCalPerUnit;

    @NonNull
    private double costPerUnit;

	@NonNull
	@OneToOne
	@JoinColumn(name = "picId")
	private Picture pic;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public double getKcalPerUnit() {
        return kCalPerUnit;
    }

    public void setKcalPerUnit(double kcalPerUnit) {
        this.kCalPerUnit = kcalPerUnit;
    }

    public double getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(double costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    public Picture getPic() {
        return pic;
    }

    public void setPic(Picture pic) {
        this.pic = pic;
    }
}
