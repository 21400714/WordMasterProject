package com.mycom.word;

import java.util.Scanner;

/**
 * wordCRUD 클래스를 사용해 영단어 마스터 프로그램을 실제로 관리하는 클래스입니다.
 * 사용자에게 영단어 마스터 프로그램을 사용하기 위한 UI를 제공합니다.
 */

public class WordManager {
    Scanner s = new Scanner(System.in);
    WordCRUD wordCRUD;

    WordManager() {
        wordCRUD = new WordCRUD();
    }

    public int menu() {
        System.out.print("\n*** 영단어 마스터 ***\n\n" +
                "*********************\n" +
                "1. 모든 단어 보기\n" +
                "2. 수준별 단어 보기\n" +
                "3. 단어 검색\n" +
                "4. 단어 추가\n" +
                "5. 단어 수정\n" +
                "6. 단어 삭제\n" +
                "7. 파일 저장\n" +
                "0. 나가기\n" +
                "*********************\n" +
                "=> 원하는 메뉴의 번호를 입력하세요: ");

        return s.nextInt();
    }

    public void start() {
        wordCRUD.loadFile();

        while (true) {
            int menu = menu();
            if (menu == 0) {
                System.out.println("\n[영단어 마스터를 종료합니다. 이용해주셔서 감사합니다.]");
                break;
            } else if (menu == 1) {
                wordCRUD.showWordList();
            } else if (menu == 2) {
                wordCRUD.searchByLevel();
            } else if (menu == 3) {
                wordCRUD.searchByKeyword();
            } else if (menu == 4) {
                wordCRUD.create();
            } else if (menu == 5) {
                wordCRUD.update();
            } else if (menu == 6) {
                wordCRUD.delete();
            } else if (menu == 7) {
                wordCRUD.saveFile();
            }
        }
    }
}
