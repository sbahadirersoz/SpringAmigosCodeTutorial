package amigoscode.tutorial.amigoscodetutorial.Student;

import jakarta.persistence.*;

import java.time.LocalDate;

/*MODELLEME BURASI*/
@Entity
@Table
public class student
{
    @Id
    @SequenceGenerator
            (
                    name = "student_sequence",
                    sequenceName = "student_sequence",
                    allocationSize = 1
            )
    @GeneratedValue
            (
                    strategy = GenerationType.SEQUENCE,
                    generator = "student_sequence"
            )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    /*Geçici bir tutulan veri */
    private  Integer age;

    public student() {
    }

    public student(Long id,
                   String name,
                   String email,
                   LocalDate dob,
                   Integer age)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }

    public student(String name,
                   String email,
                   LocalDate dob,
                   Integer age)
    {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
