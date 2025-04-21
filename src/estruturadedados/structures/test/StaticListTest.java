package estruturadedados.structures.test;

import estruturadedados.structures.domain.StaticList;

public class StaticListTest {
    public static void main(String[] args) {
        StaticList staticList = new StaticList(10);
        staticList.addAtTheStart(1);
        staticList.addAtTheEnd(2);
        staticList.addAtTheEnd(3);
        staticList.addAtTheEnd(4);
        staticList.addAtAnyPosition(10, 2);
        staticList.removeAtAnyPosition(4);

        staticList.printStaticList();
    }
}
