package com.mycom.word;

/**
 * CRUD를 위한 interface입니다.
 * CRUD에 사용되는 메소드의 이름이 선언된 템플릿입니다.
 * CRUD는 영단어 마스터 외의 프로그램에도 사용될 수 있는 기능이므로
 * 새로운 프로그램을 추가하는 경우 이 interface를 활용할 수 있습니다.
 */

public interface ICRUD {
    void create();
    void update();
    void delete();
}
