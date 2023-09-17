package java16;

public class PatternMatchingInstanceof {
    abstract static class Person {
        String name;
        String getName() {
            return name;
        }
    }
    final static class Employee extends Person {
        String name;
        int id;
        Employee(int id, String name){
            this.id = id;
            this.name = name;
        }
        int getEmployeeId() {
            return id;
        }
    }
    static final class Manager extends Person {
        int id;
        Manager(int id, String name){
            this.id = id;
            this.name = name;
        }
        int getManagerId() {
            return id;
        }
    }

    public static int getId(Person person) {
        if (person instanceof Employee) {
            Employee e = (Employee) person;
            return e.getEmployeeId();
        }
        else if (person instanceof Manager) {
            Manager m = (Manager) person;
            return m.getManagerId();
        }
        return -1;
    }
    public static void main(String[] args) {
        Person manager = new Manager(42, "Karen");
        System.out.println(getId(manager));
    }
}
