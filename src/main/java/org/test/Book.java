package org.test;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Book {
  private String name;
  private String author;
  private String date;
  boolean isPrivate;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public boolean getIsPrivate() {
    return isPrivate;
  }

  public void setIsPrivate(boolean aPrivate) {
    isPrivate = aPrivate;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof Book))return false;

    Book a = (Book) obj;
    return this.name.equals(a.name);
  }
}
