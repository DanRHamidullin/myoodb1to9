package lab8;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;

public class EntityManagerFactory {
  private Properties props;
  private List classes;

  public EntityManagerFactory(Properties properties, String classPath) {
    try {
      this.props = properties;
      LinkedHashMap<String, LinkedHashMap<String, String>> tablesPackage = ScanClasses.getInfoAboutClasses();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public EntityManager create() {
    return new EntityManagerImpl(props, classes);

  }

  public void close() {
     new EntityManagerImpl(props, classes).close();
  }


}