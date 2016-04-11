package edziekanat.databasemodel.dto;

import edziekanat.databasemodel.TableNames;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by slivka on 10.04.2016.
 */
@Entity
@Table(name = TableNames.APPLICATION_TYPE)
public class Application_typeDTO implements Serializable {

    @Id
    @SequenceGenerator(name= "APPLICATION_TYPESEQ", sequenceName = "application_type_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "APPLICATION_TYPESEQ")
    @Column(name="type_id")
    private Integer type_id;
    @Column(name="type_name")
    private String type_name;

    public Integer getType_id(){return type_id;}
    public void setType_id(Integer type_id){this.type_id = type_id;}

    public String getType_name(){return type_name;}
    public void setType_name(String type_name){this.type_name = type_name;}
}
