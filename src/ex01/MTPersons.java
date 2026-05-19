package ex01;

public class MTPersons implements IPersons {
    public MTPersons() {}

    @Override
    public boolean contains(Person p) {
        return false;
    }

    @Override
    public Person findParent(Person child) {
        return null;
    }
}