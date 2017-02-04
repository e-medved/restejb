package org.test;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Singleton
@Path("/book")
public class LibraryService {

  @EJB
  private Catalog catalog;

  @GET @Path("/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  public Book getByName(@PathParam("name") String name) {
    return catalog.findByName(name);
  }

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
    catalog.addOrUpdate(book);
    return book;
  }

  @DELETE @Path("/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  public void remove(@PathParam("name") String name) {
    catalog.removeByName(name);
  }

}
