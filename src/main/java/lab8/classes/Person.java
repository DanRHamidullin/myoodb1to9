package lab8.classes;


import lab8.annotation.Column;

public abstract class Person {
  @Column
  String name;
  @Column
  String otchestvo;
  @Column
  String lastname;


  public Person() {
  }

  Person(String name, String otchestvo, String lastName) {
    this.name = name;
    this.otchestvo = otchestvo;
    this.lastname = lastName;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOtchestvo() {
    return otchestvo;
  }

  public void setotchestvo(String otchestvo) {
    this.otchestvo = otchestvo;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }
}
