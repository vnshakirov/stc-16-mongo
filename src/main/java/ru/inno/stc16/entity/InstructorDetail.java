package ru.inno.stc16.entity;

import java.util.Objects;
import java.util.StringJoiner;


public class InstructorDetail {

  private static int LAST_ID = 0;

  private int id;
  private String youtubeChannel;
  private String hobby;
  transient private Instructor instructor;

  public InstructorDetail() {
    this.id = LAST_ID++;
  }

  public InstructorDetail(String youtubeChannel, String hobby) {
    this();
    this.youtubeChannel = youtubeChannel;
    this.hobby = hobby;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getYoutubeChannel() {
    return youtubeChannel;
  }

  public void setYoutubeChannel(String youtubeChannel) {
    this.youtubeChannel = youtubeChannel;
  }

  public String getHobby() {
    return hobby;
  }

  public void setHobby(String hobby) {
    this.hobby = hobby;
  }

  public Instructor getInstructor() {
    return instructor;
  }

  public void setInstructor(Instructor instructor) {
    this.instructor = instructor;
  }

  @Override public String toString() {
    return new StringJoiner(", ", InstructorDetail.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("youtubeChannel='" + youtubeChannel + "'")
        .add("hobby='" + hobby + "'")
        .toString();
  }

  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InstructorDetail that = (InstructorDetail) o;
    return id == that.id &&
        Objects.equals(instructor, that.instructor);
  }

  @Override public int hashCode() {
    return Objects.hash(id, instructor);
  }
}







