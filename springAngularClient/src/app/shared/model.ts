export class Student {
   id: number ;
  first_Name: string;

  last_Name: string;
//Set<Course> courses;

}
export class Course {
  courseId: number ;
  courseName: string;

  student: Student;
  difficulty:{
    HARD,EASY,MEDIUM
  }
//Set<Course> courses;

}
