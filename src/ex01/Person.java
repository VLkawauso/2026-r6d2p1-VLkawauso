package ex01;

public class Person {
    String name;
    int birthYear;
    IPersons children;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.children = new MTPersons(); // 最初は子供がいない空リストで初期化
    }

    // 子供を追加するメソッド
    public void addChild(Person child) {
        this.children = new ConsPersons(child, this.children);
    }

    // 自身が指定された人物の直接の親であるか判定
    boolean isParentOf(Person child) {
        return this.children.contains(child);
    }

    // 自身または自身の子孫の中から、指定された人物の親を探し出す
    public Person findParent(Person child) {
        if (this.isParentOf(child)) {
            return this;
        }
        return this.children.findParent(child);
    }

    // 【補助メソッド】家系図の起点(this)から見て、adultがchildの「おじ/おば」か判定する
    public boolean isUncleOrAuntOf(Person adult, Person child) {
        Person childParent = this.findParent(child);
        if (childParent == null) {
            return false;
        }
        Person grandparent = this.findParent(childParent);
        if (grandparent == null) {
            return false;
        }
        // 祖父母の子供（＝親の兄弟姉妹）にadultが含まれており、かつadultが親自身ではないこと
        return grandparent.children.contains(adult) && adult != childParent;
    }

    // 【メインメソッド】2人の人物がいとこ関係にあるかを判定する
    public boolean areCousins(Person a, Person b) {
        Person parentA = this.findParent(a);
        if (parentA == null) {
            return false;
        }
        // 「aの親」が「bのおじ/おば」であれば、aとbはいとこ関係になる
        return this.isUncleOrAuntOf(parentA, b);
    }
}