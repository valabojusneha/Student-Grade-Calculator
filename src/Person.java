// ==========================================
// ABSTRACTION
// ==========================================
// Person is an abstract class.
// We cannot create a Person object directly.

public abstract class Person {

    protected String name;

    // ==========================================
    // CONSTRUCTOR
    // ==========================================

    public Person(String name) {
        this.name = name;
    }

    // ==========================================
    // ABSTRACT METHOD
    // ==========================================
    // Child classes must implement this method.

    public abstract void displayDetails();

    // ==========================================
    // GETTER
    // ==========================================

    public String getName() {
        return name;
    }

    // ==========================================
    // SETTER
    // ==========================================

    public void setName(String name) {
        this.name = name;
    }
}