package amigoscode.tutorial.amigoscodetutorial.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/*Mapping yapmaya yarar*/
@RestController
@RequestMapping(path = "api/v1/student")
public class studentController
{
    @Autowired
    public studentController(studentService service) {
        this.service =service;
    }

    private final studentService service;
    @GetMapping
    public List<student>hello()
    {
     return service.getStudents();
    }

    @PostMapping
    public  void registerNewStudent(@RequestBody student Student)
    {
        service.addNewStudent(Student);
    }
    @DeleteMapping(path = {"studentId"})
    public void deleteStudent(@PathVariable("studentId")Long studentId)
    {
        service.deleteStudent(studentId);
    }
    @PutMapping(path = "{studentId")
    public void updateStudent
        (
         @PathVariable("studentId")Long studentId,
         @RequestParam(required = false)String name,
         @RequestParam(required = false)String email
        )
    {
    }

}
