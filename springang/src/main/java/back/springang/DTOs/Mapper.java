package back.springang.DTOs;

import back.springang.models.Course;
import back.springang.models.Student;
import back.springang.repository.studentRepo;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

/**
 * Component that handles all mappings in this project
 * - entity to view model
 * - view model to entity
 * <p>
 * All mappings are handled here, but in production code this is not the
 * best approach. You can take a look at ModelMapper project or at least split mapping classes
 * across many files.
 */

@Component
public class Mapper {
    private studentRepo studentRepository;

    public Mapper(studentRepo studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentDto convertToNoteViewModel(Student entity) {
        var viewModel = new StudentDto();
        viewModel.setId(entity.getId());
        viewModel.setFirst_Name(entity.getFirst_Name());
        viewModel.setLast_Name(entity.getLast_Name());

        return viewModel;
    }

    public Student convertToStudentEntity(StudentDto viewModel) {
     //   var Id = this.studentRepository.findById((viewModel.getId()));
        var entity = new Student(viewModel.getId(), viewModel.getFirst_Name(), viewModel.getLast_Name()/*Id*/);
        return entity;
    }

 /*   public NotebookViewModel convertToNotebookViewModel(Notebook entity) {
        var viewModel = new NotebookViewModel();
        viewModel.setId(entity.getId().toString());
        viewModel.setName(entity.getName());
        viewModel.setNbNotes(entity.getNotes().size());

        return viewModel;
    }*/

    public Course convertToCourseEntity(CourseDto courseDto) {
        Student st=this.studentRepository.findById(courseDto.getStudent_id()).get();

         Course entity = new Course(courseDto.getId(), st,courseDto.getCourseName(),courseDto.getDifficulty());

return entity;
    }
}
