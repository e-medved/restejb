package org.test;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 2/2/17.
 */
@Singleton
@Path("/book")
public class LibraryService {

  @EJB
  Catalog catalog;

  @GET @Path("/public")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Book> getPublic() {
    return catalog.getPublicCatalog();
  }

  @GET @Path("/private")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Book> getPrivate() {
    return catalog.getPrivateCatalog();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Book create(Book book) {
    catalog.getPublicCatalog().add(book);
    return book;
  }

  @DELETE @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public void remove(@QueryParam("title") String title) {

    catalog.removeByTitle(title);
  }



}
