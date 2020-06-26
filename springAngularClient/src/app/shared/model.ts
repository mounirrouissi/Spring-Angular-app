export class Student {
   id: number ;
  first_Name: string;

  last_Name: string;
//Set<Course> courses;

}
export class Course {
  courseId: number ;
  StudentId:number;
  courseName: string;
  difficulty:{
    HARD,EASY,MEDIUM
  }

//Set<Course> courses;

}
