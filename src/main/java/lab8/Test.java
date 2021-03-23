package lab8;

import lab7.CustomJPAAnnotationProcessor;
import lab7.MetaClass.EntityMeta;
import lab8.classes.Category;
import lab8.classes.Orders;
import lab8.classes.Person;
import lab8.classes.Users;
import lab7.DAO.DBScanner;
import lab7.MetaClass.EntityMeta;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Properties;


public class Test {


  public static void main(String[] args) {
    Properties props = new Properties();
    props.setProperty("url", "jdbc:postgresql://localhost:5432/lab8");
    props.setProperty("username", "admin");
    props.setProperty("password", "123");
    props.setProperty("driverName", "org.postgresql.Driver");
    String classPath = "lab8.classes";

    CustomJPAAnnotationProcessor annotationProcessor=new CustomJPAAnnotationProcessor("lab7.Entities");
    List<EntityMeta> metaClasses=annotationProcessor.builtMetaClasses();
    DBScanner scanner=new DBScanner("org.postgresql.Driver","jdbc:postgresql://localhost:5432/lab8", "admin", "123");
    HashMap<String, HashSet<String>> tables=scanner.getTablesInfo();
    HashMap<String,HashSet<String>> fields=scanner.getTablesInfo();
    for (EntityMeta entityMeta:metaClasses)
      if (entityMeta.checkDB(tables))
        System.out.println(entityMeta.getName()+" failed validation");
      else
        System.out.println(entityMeta.getName()+" was succesfully checked");

    for(EntityMeta entityMeta:metaClasses)
      if (entityMeta.checkDB(fields))
        System.out.println(entityMeta.getAttributes()+" failed validation");
      else
        System.out.println(entityMeta.getAttributes()+" was succesfully checked");

//    EntityManagerImpl entityManager = new EntityManagerImpl();
    EntityManagerFactory entityManagerFactory = new EntityManagerFactory(props, classPath);
    EntityManager entityManager = entityManagerFactory.create();

    Person users = new Users();
    users.setName("Николай");
    users.setotchestvo("Николаевич");
    users.setLastname("Погорелец");
    ((Users) users).setInfo("покупатель");

    Person users2 = new Users();
    users2.setName("Тест");
    users2.setotchestvo("Это");
    users2.setLastname("Просто");
    ((Users) users2).setInfo("покупатель2");

    entityManager.persist(users);
    entityManager.persist(users2);





    Category category = new Category();
    category.setCategory("Телефоны");
    entityManager.persist(category);


    Orders orders = new Orders();
    orders.setTitle("Самсунг");
    orders.setUsers((Users) users);
    orders.setCategory(category);
    orders.setDateofpublishing("24.05.2028");
    orders.setPrice(23000.0);
    entityManager.persist(orders);


    System.out.println("\n");
    System.out.println("Объект класса Users до обновления - " + users);
    ((Users) users).setInfo("Покупатель");
    entityManager.merge(users);
    System.out.println("Объект класса Users после обновления - " + users);

    System.out.println("\n");
    System.out.println("Объект класса Order до обновления - " + orders);
    orders.setDateofpublishing("30.05.2225");
    orders.setUsers((Users) users2);
    entityManager.merge(orders);
    System.out.println("Объект класса Order после обновления - " + orders);
    System.out.println("\n");

    entityManager.remove(orders);
    entityManager.remove(category);


    System.out.println("\n");
    System.out.println("Объект класса Order до обновления - " + orders);
    orders.setDateofpublishing("20.03.2020");
    entityManager.merge(orders);
    System.out.println("Объект класса Order после обновления - " + orders);
    System.out.println("\n");

    System.out.println("\n");
    Object object = entityManager.find(Orders.class, 1);
    System.out.println("Найденный объект класса Order с id=1 - " + object);

    entityManagerFactory.close();


  }
}

