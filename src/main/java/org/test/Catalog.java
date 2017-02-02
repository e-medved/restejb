package org.test;

import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 2/3/17.
 */
@Stateful
public class Catalog {

  List<Book> privateCatalog = new ArrayList<Book>();
  List<Book> publicCatalog = new ArrayList<Book>();

  public List<Book> getPrivateCatalog() {
    return privateCatalog;
  }

  public List<Book> getPublicCatalog() {
    return publicCatalog;
  }

  public void removeByTitle(String title){


  }

}
