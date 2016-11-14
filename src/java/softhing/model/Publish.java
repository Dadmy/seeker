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
 * Publish generated by hbm2java
 */
@Entity
@Table(name="publish"
    ,catalog="seeker"
)
public class Publish  implements java.io.Serializable {


     private Long pubId;
     private ObjectLossed objectLossed;
     private Place place;
     private User user;
     private Integer rating;
     private Date createdAt;
     private Date updatedAt;
     private Date deletedAt;
     private Set<Form> forms = new HashSet<Form>(0);
     private Set<Detail> details = new HashSet<Detail>(0);

    public Publish() {
    }

	
    public Publish(Date createdAt, Date updatedAt) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public Publish(ObjectLossed objectLossed, Place place, User user, Integer rating, Date createdAt, Date updatedAt, Date deletedAt, Set<Form> forms, Set<Detail> details) {
       this.objectLossed = objectLossed;
       this.place = place;
       this.user = user;
       this.rating = rating;
       this.createdAt = createdAt;
       this.updatedAt = updatedAt;
       this.deletedAt = deletedAt;
       this.forms = forms;
       this.details = details;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Pub_Id", unique=true, nullable=false)
    public Long getPubId() {
        return this.pubId;
    }
    
    public void setPubId(Long pubId) {
        this.pubId = pubId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="OL_Id")
    public ObjectLossed getObjectLossed() {
        return this.objectLossed;
    }
    
    public void setObjectLossed(ObjectLossed objectLossed) {
        this.objectLossed = objectLossed;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Pl_Id")
    public Place getPlace() {
        return this.place;
    }
    
    public void setPlace(Place place) {
        this.place = place;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Us_Id")
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    
    @Column(name="rating")
    public Integer getRating() {
        return this.rating;
    }
    
    public void setRating(Integer rating) {
        this.rating = rating;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="publish")
    public Set<Form> getForms() {
        return this.forms;
    }
    
    public void setForms(Set<Form> forms) {
        this.forms = forms;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="publish")
    public Set<Detail> getDetails() {
        return this.details;
    }
    
    public void setDetails(Set<Detail> details) {
        this.details = details;
    }




}


