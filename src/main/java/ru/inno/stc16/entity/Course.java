package ru.inno.stc16.entity;

import org.bson.types.ObjectId;

import java.util.Objects;
import java.util.StringJoiner;

public class Course {

  private ObjectId id;
  private String title;
  transient private Instructor instructor;

  public Course() {

  }

  public Course(String title) {
    this();
    this.title = title;
  }

  public ObjectId getId() {
    return id;
  }

  public void setId(ObjectId id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Instructor getInstructor() {
    return instructor;
  }

  public void setInstructor(Instructor instructor) {
    this.instructor = instructor;
  }

  @Override public String toString() {
    return new StringJoiner(", ", Course.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("title='" + title + "'")
        .toString();
  }

  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Course course = (Course) o;
    return id == course.id &&
        Objects.equals(title, course.title);
  }

  @Override public int hashCode() {
    return Objects.hash(id, title);
  }
}
