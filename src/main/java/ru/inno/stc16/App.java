package ru.inno.stc16;

import ru.inno.stc16.entity.Course;
import ru.inno.stc16.entity.Instructor;
import ru.inno.stc16.entity.InstructorDetail;

import java.util.ArrayList;
import java.util.List;

public class App {

  public static void main(String[] args) {

    MongoDbProducer producer = new MongoDbProducer();
    producer.init();

    //create some instructor
    Instructor instructor = new Instructor("Ernesto", "Guevara", "ergu@javaguides.com");
    InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "Guitar");
    instructorDetail.setInstructor(instructor);
    instructor.setInstructorDetail(instructorDetail);

    // create some courses
    List<Course> courses = new ArrayList<>();
    Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
    tempCourse1.setInstructor(instructor);
    courses.add(tempCourse1);
    Course tempCourse2 = new Course("The Pinball Masterclass");
    tempCourse2.setInstructor(instructor);
    courses.add(tempCourse2);
    producer.addCourse(tempCourse1);
    producer.addCourse(tempCourse2);

    instructor.setCourses(courses);
    producer.addObject(instructor, "Instructor");


    System.out.println("==========================================");
    producer.getCourses().forEach(System.out::println);
    System.out.println("==========================================");
    producer.getObjectList("Instructor", Instructor.class).forEach(System.out::println);
    System.out.println("==========================================");
    System.out.println("==========================================");
    System.out.println("==========================================");
    System.out.println("==========================================");
    producer.close();
  }
}
