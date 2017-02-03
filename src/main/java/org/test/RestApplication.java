package org.test;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: e.medvedev
 * Date: 03.02.2017
 */
@ApplicationPath("")
public class RestApplication extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    HashSet<Class<?>> classes = new HashSet<Class<?>>();
    classes.add(LibraryService.class);
    return classes;
  }
}
