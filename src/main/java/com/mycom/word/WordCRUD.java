package com.mycom.word;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD { // ICRUD interface 구현체
    ArrayList<Word> list;
    Scanner s;

    /*
    => 난이도(1, 2, 3)와 새 단어를 입력하세요. 1 driveway
    뜻을 입력하세요. 차고 진입로

    새 단어가 단어장에 추가되었습니다.
    */

    WordCRUD(Scanner s) {
        list = new ArrayList<>();
        this.s = s;
    }

    @Override
    public Object add() { // Word 추가
        System.out.print("\n=> 난이도(1, 2, 3)와 새 단어를 입력하세요. ");
        int level = s.nextInt();
        String word = s.nextLine();
        System.out.print("뜻을 입력하세요. ");
        String meaning = s.nextLine();

        return new Word(0, level, word, meaning);
    }

    public void addWord() { // Word 추가
        Word one = (Word)add();
        list.add(one);
        System.out.println("\n새 단어가 단어장에 추가되었습니다.");
    }

    @Override
    public int update(Object obj) {
        return 0;
    }

    @Override
    public int delete(Object obj) {
        return 0;
    }

    @Override
    public void selectOne(int id) {

    }

    /*
    => 원하시는 메뉴의 번호를 입력하세요. 1

    --------------------------------------------------
     1 *** superintendent  관리자, 감독관
     2 *         electric  전기의, 전기를 생산하는
     3 **       equipment  장비, 용품
     4 *             pole  기둥, 장대
    --------------------------------------------------
    */

    public void listAll() { // Word 조회
        System.out.println("\n--------------------------------------------------");

        for (int i = 0; i < list.size(); i++) {
            System.out.print(" " + (i + 1) + " ");
            System.out.println(list.get(i).toString());
        }

        System.out.println("--------------------------------------------------");
    }
}
