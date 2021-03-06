package com.company;

import java.util.ArrayList;
import java.util.List;

public class Monsters implements ISavable {

    private String name;
    private int HP;
    private int SP;

    public Monsters(String name, int HP, int SP) {
        this.name = name;
        this.HP = HP;
        this.SP = SP;
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public int getSP() {
        return SP;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setSP(int SP) {
        this.SP = SP;
    }

    @Override
    public List<String> saving() {

        List<String> arrayList = new ArrayList<String>();

        arrayList.add(0, name);
        arrayList.add(1, "" + HP);
        arrayList.add(2, "" + SP);

        return arrayList;

    }

    @Override
    public void loading(List<String> values) {

        if (values != null && values.size() > 0) {

            name = values.get(0);
            HP = Integer.parseInt(values.get(1));
            SP = Integer.parseInt(values.get(2));
        }
    }

    @Override
    public String toString() {
        return name + " has HP: " + HP + " & SP: " + SP;
    }
}
