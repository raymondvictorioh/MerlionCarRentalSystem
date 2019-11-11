/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author raymond
 */
@Entity
public class CarModel implements Serializable {

   

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long modelId;
     @Column(nullable=false)
    private String modelName;
    
     @ManyToOne(optional=false)
     @JoinColumn(nullable=false)
    private CarCategory carCategory;
    @OneToMany(mappedBy = "carModel")
     private List<Car> cars;
    @OneToMany(mappedBy = "carModel")
    private List<RentalReservation> reservations;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    
    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modelId != null ? modelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the modelId fields are not set
        if (!(object instanceof CarModel)) {
            return false;
        }
        CarModel other = (CarModel) object;
        if ((this.modelId == null && other.modelId != null) || (this.modelId != null && !this.modelId.equals(other.modelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CarModel[ id=" + modelId + " ]";
    }
    
}
