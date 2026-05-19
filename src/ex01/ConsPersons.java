package ex01;

public class ConsPersons implements IPersons {
    Person fst;
    IPersons rst;

    public ConsPersons(Person fst, IPersons rst) {
        this.fst = fst;
        this.rst = rst;
    }

    @Override
    public boolean contains(Person p) {
        if (this.fst == p) {
            return true;
        }
        return this.rst.contains(p);
    }

    @Override
    public Person findParent(Person child) {
        // 先頭の人物の家系（子孫）から親を探す
        Person p = this.fst.findParent(child);
        if (p != null) {
            return p;
        }
        // 見つからなければ残りのリストから探す
        return this.rst.findParent(child);
    }
}