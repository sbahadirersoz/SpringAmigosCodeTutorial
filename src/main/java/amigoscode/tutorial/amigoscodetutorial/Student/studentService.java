package amigoscode.tutorial.amigoscodetutorial.Student;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/*BUSINESS LOGIC*/
@Service
public class studentService
{
 private final studentRepos studentRepos;

    public studentService(amigoscode.tutorial.amigoscodetutorial.Student.studentRepos studentRepos)
    {
        this.studentRepos = studentRepos;
    }


    public List<student> getStudents()
{
       return studentRepos.findAll();
}
    public void addNewStudent(student student)
    {
        Optional<amigoscode.tutorial.amigoscodetutorial.Student.student> studentByEmail =
                studentRepos.findstudentByEmail(student.getEmail());
        if (studentByEmail.isPresent())
        {
            throw  new IllegalStateException("mail taken");
        }
        studentRepos.save(student);
    }
    public void deleteStudent(Long studentId)
    {
        boolean exists =studentRepos.existsById(studentId);
        if (!exists)
        {
            throw new IllegalStateException
                    ("student with +"+studentId + " not found1");
        }
        studentRepos.deleteById(studentId);
    }
    @Transactional
    public void updateStudent
            (
                Long studentId,
                String name,
                String email
            )
    {
        student student =studentRepos.findById(studentId)
                .orElseThrow(()-> new IllegalStateException
            ("Student with id "+studentId+" does not exist"));
       if (name ==null &&name.length()>0 && !Objects.equals(student.getName(),name))
       {
           student.setName(name);
       }
       if (email ==null && email.length()>0 && !Objects.equals((student.getEmail()),email))
       {
           Optional<student> studentOptional = studentRepos.findstudentByEmail(email);
           if (studentOptional.isPresent())
           {
               throw new IllegalStateException("email Taken");
           }
           student.setEmail(email);
       }

    }
}
