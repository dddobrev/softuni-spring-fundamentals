package bg.softuni;

import java.util.List;

public class StudentServiceImpl implements StudentServiceIfc{


  @Override
  @Cacheable("students")
  public List<Student> getAllStudents() {
    System.out.println("DOING SOME HARD WORK TO RETRIEVE THE STUDENTS!");

    Student pesho = new Student("Pesho", 22);
    Student anna = new Student("Anna", 21);

    return List.of(pesho, anna);
  }
}
