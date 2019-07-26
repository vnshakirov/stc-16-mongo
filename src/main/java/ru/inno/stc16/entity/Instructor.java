package ru.inno.stc16.entity;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Instructor {

  private static int LAST_ID = 0;

  private int id;
  private String firstName;
  private String lastName;
  private String email;
  private InstructorDetail instructorDetail;
  private List<Course> courses;

  public Instructor() {
    this.id = LAST_ID++;
  }

  public Instructor(String firstName, String lastName, String email) {
    this();
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public InstructorDetail getInstructorDetail() {
    return instructorDetail;
  }

  public void setInstructorDetail(InstructorDetail instructorDetail) {
    this.instructorDetail = instructorDetail;
  }

  @Override public String toString() {
    return new StringJoiner(", ", Instructor.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("firstName='" + firstName + "'")
        .add("lastName='" + lastName + "'")
        .add("email='" + email + "'")
        .add("instructorDetail=" + instructorDetail)
        .toString();
  }

  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }

  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Instructor that = (Instructor) o;
    return id == that.id &&
        Objects.equals(email, that.email);
  }

  @Override public int hashCode() {
    return Objects.hash(id, email);
  }
}











