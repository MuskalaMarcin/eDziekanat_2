package edziekanat.databasemodel.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import edziekanat.databasemodel.TableNames;

/**
 *  Data transfer object representing classroom entity.
 *
 */
@Entity
@Table(name = TableNames.CLASSROOM)
public class ClassroomDTO implements Serializable,Comparable
{
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "CLASSROOMSEQ", sequenceName = "classroom_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CLASSROOMSEQ")
    @Column(name = "id")
    private Integer id;
    @Column(name = "nr")
    private Integer number;
    @Column(name = "capacity")
    private Integer capacity;
    @Column(name = "type")
    private String type;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id")
    private FacultyDTO faculty;
    @OneToMany(mappedBy = "classroom", fetch = FetchType.LAZY)
    private List<ScheduledClassesDTO> scheduled_classes;
    @OneToMany(mappedBy = "classroom", fetch = FetchType.LAZY)
    private List<ReservationRequestDTO> reservation_request;
    @Column(name = "available")
    private boolean available;

    public Integer getId()
    {
	return id;
    }

    public void setId(Integer id)
    {
	this.id = id;
    }

    public Integer getCapacity()
    {
	return capacity;
    }

    public void setCapacity(Integer capacity)
    {
	this.capacity = capacity;
    }

    public String getType()
    {
	return type;
    }

    public void setType(String type)
    {
	this.type = type;
    }

    public FacultyDTO getFaculty()
    {
	return faculty;
    }

    public void setFaculty(FacultyDTO faculty)
    {
	this.faculty = faculty;
    }

    public List<ScheduledClassesDTO> getScheduledClasses()
    {
	return scheduled_classes;
    }

    public void setScheduledClasses(List<ScheduledClassesDTO> scheduledClasses)
    {
	this.scheduled_classes = scheduledClasses;
    }

    public Integer getNumber()
    {
	return number;
    }

    public void setNumber(Integer number)
    {
	this.number = number;
    }

    public List<ReservationRequestDTO> getReservation_request()
    {
        return reservation_request;
    }

    public void setReservation_request(List<ReservationRequestDTO> reservation_request)
    {
        this.reservation_request = reservation_request;
    }

    public boolean getAvailable(){return available;}

    public void setAvailable(boolean available)
    {
        this.available = available;
    }

    @Override
    public int compareTo(Object o) {
        ClassroomDTO other = (ClassroomDTO)o;
        if(this.number < other.number)
        {
            return -1;
        }
        else if(this.number == other.number)
        {
            return 0;
        }
        else
        {
            return 1;
        }

    }
}
