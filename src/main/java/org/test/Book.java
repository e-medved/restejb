package org.test;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by root on 2/2/17.
 */
@XmlRootElement
public class Book {
  String title;
  String author;
  String date;

  @Override
  public boolean equals(Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;
    if (!(obj instanceof Book))return false;

    Book a = (Book) obj;
    return this.title.equals(a.title);
  }
}
