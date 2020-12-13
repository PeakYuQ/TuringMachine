package com.peakyu.application;

public class State {

    private int id;
    private static int index = 0;

    public static void setIndex(int index) {
        State.index = index;
    }

    public State() {
        this(index++);
    }

    private State(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static int getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this.getClass() != other.getClass()) {
            return false;
        }
        if (this.id != ((State)other).id) {
            return false;
        }
        return true;
    }

}
