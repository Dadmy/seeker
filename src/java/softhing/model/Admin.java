package softhing.model;
// Generated 13/11/2016 09:04:01 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Admin generated by hbm2java
 */
@Entity
@Table(name="admin"
    ,catalog="seeker"
)
public class Admin  implements java.io.Serializable {


     private Long admId;
     private Person person;
     private Boolean placeManager;
     private Date createdAt;
     private Date updatedAt;
     private Date deletedAt;
     private Set<Place> places = new HashSet<Place>(0);

    public Admin() {
    }

	
    public Admin(Date createdAt, Date updatedAt) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public Admin(Person person, Boolean placeManager, Date createdAt, Date updatedAt, Date deletedAt, Set<Place> places) {
       this.person = person;
       this.placeManager = placeManager;
       this.createdAt = createdAt;
       this.updatedAt = updatedAt;
       this.deletedAt = deletedAt;
       this.places = places;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Adm_Id", unique=true, nullable=false)
    public Long getAdmId() {
        return this.admId;
    }
    
    public void setAdmId(Long admId) {
        this.admId = admId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Psn_Id")
    public Person getPerson() {
        return this.person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }

    
    @Column(name="placeManager")
    public Boolean getPlaceManager() {
        return this.placeManager;
    }
    
    public void setPlaceManager(Boolean placeManager) {
        this.placeManager = placeManager;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at", nullable=false, length=19)
    public Date getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at", nullable=false, length=19)
    public Date getUpdatedAt() {
        return this.updatedAt;
    }
    
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="deleted_at", length=19)
    public Date getDeletedAt() {
        return this.deletedAt;
    }
    
    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="admin")
    public Set<Place> getPlaces() {
        return this.places;
    }
    
    public void setPlaces(Set<Place> places) {
        this.places = places;
    }




}


