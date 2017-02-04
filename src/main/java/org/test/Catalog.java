package org.test;

import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;


@Stateful
public class Catalog {

  private List<Book> container = new ArrayList<Book>();


  public List<Book> getPrivateCatalog() {
    List<Book> privateCatalog = new ArrayList<Book>();
    for(Book book : container){
      if (book.isPrivate)
        privateCatalog.add(book);
    }

    return privateCatalog;
  }

  public List<Book> getPublicCatalog() {
    List<Book> publicCatalog = new ArrayList<Book>();
    for(Book book : container){
      if (!book.isPrivate)
        publicCatalog.add(book);
    }

    return publicCatalog;
  }

  public void removeByName(String name){
    Book currentBook = new Book();
    currentBook.setName(name);

    container.remove(currentBook);
  }

  public Book findByName(String name){
    Book currentBook = new Book();
    currentBook.setName(name);

    int index = container.indexOf(currentBook);
    return index >= 0 ? container.get(index) : null;
  }

  public void addOrUpdate(Book book){
    if (container.contains(book))
      container.remove(book);
    container.add(book);
  }

}
