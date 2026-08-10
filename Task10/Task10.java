public class Task10 {
    public static void main(String[] args) {
        Student[] students = new Student[] {
            new Student("Hinolan", "John Neo"),
            new Student("Bonifacio", "John"),
            new Student("nolan", "Neo"),
        };

        for (Student s : students) {
            s.printFullName();
        }
    }
}

class Student {
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void printFullName() {
        System.out.println(this.firstName + " " + this.lastName);
    }
}