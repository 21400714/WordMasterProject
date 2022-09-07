package com.mycom.word;

public interface ICRUD { // CRUD를 위한 interface
    public Object add();
    public int update(Object obj);
    public int delete(Object obj);
    public void selectOne(int id);
}
