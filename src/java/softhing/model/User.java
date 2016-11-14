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
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name="user"
    ,catalog="seeker"
    , uniqueConstraints = @UniqueConstraint(columnNames="accountNumber") 
)
public class User  implements java.io.Serializable {


     private Long usId;
     private Person person;
     private String faculty;
     private Integer accountNumber;
     private Date createdAt;
     private Date updatedAt;
     private Date deletedAt;
     private Set<ObjectLossed> objectLosseds = new HashSet<ObjectLossed>(0);
     private Set<Twitter> twitters = new HashSet<Twitter>(0);
     private Set<Facebook> facebooks = new HashSet<Facebook>(0);
     private Set<Answer> answers = new HashSet<Answer>(0);
     private Set<Publish> publishes = new HashSet<Publish>(0);

    public User() {
    }

	
    public User(String faculty, Date createdAt, Date updatedAt) {
        this.faculty = faculty;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public User(Person person, String faculty, Integer accountNumber, Date createdAt, Date updatedAt, Date deletedAt, Set<ObjectLossed> objectLosseds, Set<Twitter> twitters, Set<Facebook> facebooks, Set<Answer> answers, Set<Publish> publishes) {
       this.person = person;
       this.faculty = faculty;
       this.accountNumber = accountNumber;
       this.createdAt = createdAt;
       this.updatedAt = updatedAt;
       this.deletedAt = deletedAt;
       this.objectLosseds = objectLosseds;
       this.twitters = twitters;
       this.facebooks = facebooks;
       this.answers = answers;
       this.publishes = publishes;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="Us_Id", unique=true, nullable=false)
    public Long getUsId() {
        return this.usId;
    }
    
    public void setUsId(Long usId) {
        this.usId = usId;
    }

    	@GenericGenerator(name = "generator", strategy = "foreign",
	parameters = @Parameter(name = "property", value = "Psn_id"))
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Psn_Id")
    public Person getPerson() {
        return this.person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }

    
    @Column(name="faculty", nullable=false)
    public String getFaculty() {
        return this.faculty;
    }
    
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    
    @Column(name="accountNumber", unique=true)
    public Integer getAccountNumber() {
        return this.accountNumber;
    }
    
    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    public Set<ObjectLossed> getObjectLosseds() {
        return this.objectLosseds;
    }
    
    public void setObjectLosseds(Set<ObjectLossed> objectLosseds) {
        this.objectLosseds = objectLosseds;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    public Set<Twitter> getTwitters() {
        return this.twitters;
    }
    
    public void setTwitters(Set<Twitter> twitters) {
        this.twitters = twitters;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    public Set<Facebook> getFacebooks() {
        return this.facebooks;
    }
    
    public void setFacebooks(Set<Facebook> facebooks) {
        this.facebooks = facebooks;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    public Set<Answer> getAnswers() {
        return this.answers;
    }
    
    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    public Set<Publish> getPublishes() {
        return this.publishes;
    }
    
    public void setPublishes(Set<Publish> publishes) {
        this.publishes = publishes;
    }




}


