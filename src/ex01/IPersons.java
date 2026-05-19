package ex01;

public interface IPersons {
    // リストの中に指定された人物が含まれているか判定する
    boolean contains(Person p);
    
    // リスト内の人物またはその子孫から、指定された人物の親を探す
    Person findParent(Person child);
}