package com.peakyu.application;

import java.util.Iterator;
import java.util.Set;

public class TuringMachine {

    private Set<Transition> transitionRelation;
    private State initialState;
    private Set<State> finalStates;
    private String[] strings;   //记录串的变化
    private Integer[] pos;      //记录指向串的位置变化
    private String[] rules;    //记录规则的变化

    public String[] getRules() {
        return rules;
    }

    public Integer[] getPos() {
        return pos;
    }



    public TuringMachine(Set<Transition> transitions,
                         State initialState, Set<State> finalStates) {
        this.transitionRelation = transitions;
        this.initialState = initialState;
        this.finalStates = finalStates;
        this.strings=new String[500];
        this.pos=new Integer[500];
        this.rules= new String[500];;
    }

    public String run() {
        return run("");
    }

    public String[] getStrings() {
        return strings;
    }


    public String run(String tapeContent) {
        Tape tape = new Tape(tapeContent);
        State currentState = initialState;
        strings[0] = tapeContent;
        pos[0] = 0;
        System.out.println("输入串："+tape.getContent()+"当前指向："+tape.getPosition());
        System.out.println("当前状态"+currentState.getId());

        int i = 1;
        // execute transitions as long as possible
        for (Transition executableTransition = findExecutableTransition(tape, currentState);
             executableTransition != null;
             executableTransition = findExecutableTransition(tape, currentState)) {
            //找到当前正在运行的规则； 执行这个语句
            tape.executeTransition(executableTransition);
            System.out.println("当前串："+tape.getContent());
            strings[i] = tape.getContent();
            pos[i] = tape.getPosition();
            rules[i-1] =""+executableTransition.getOldState().getId()+executableTransition.getOldSymbol()+executableTransition.getNewState().getId()+executableTransition.getNewSymbol()+executableTransition.getCursorMovement();
            i++;
            //修改当前状态为正在运行的规则的新状态
            currentState = executableTransition.getNewState();
        }

        // check whether last state is a final state
        if (!finalStates.contains(currentState)) {
           return "error";
        }


        System.out.println(tape.getContent() );
        return tape.getContent();

    }

    private Transition findExecutableTransition(Tape tape, State state) {
        char currentSymbol = tape.getCurrentSymbol();
        System.out.println("当前符号："+currentSymbol+"第？符号："+tape.getPosition());
        Transition transition;

        for (Iterator<Transition> it = transitionRelation.iterator();
             it.hasNext();) {
            transition = it.next();
            if (!transition.getOldState().equals(state)) {
                continue;
            }
            if (transition.getOldSymbol() != currentSymbol) {
                continue;
            }
            System.out.println("当前的规则"+ transition.toString());
            return transition;
        }
        return null;
    }

    private class Tape {
        private String content;
        private int position;
        private int rules;

        public void setPosition(int position) {
            this.position = position;
        }

        public int getRules() {
            return rules;
        }

        public void setRules(int rules) {
            this.rules = rules;
        }

        public int getPosition() {
            return position;
        }

        public Tape(String content) {
            this.content = content;
            this.position = 0;
            this.rules = 0;
        }

        //执行这个规则
        public void executeTransition(Transition transition) {

            if (transition.getOldSymbol() != content.charAt(position)) {
                throw new RuntimeException("transition cannot be executed");
            }

            //修改纸带指向的值
            content = content.substring(0, position) +
                    transition.getNewSymbol() + content.substring(position + 1);

            //移动纸带指向
            switch (transition.getCursorMovement()) {
                case LEFT:
                    if (position != 0) {
                        --position;
                    } else {
                        content = " " + content;
                    }
                    break;
                case RIGHT:
                    ++position;
                    if (position == content.length()) {
                        content = content + " ";
                    }
                    break;
                case NONE:

            }
        }

        public String getContent() {
            return this.content;
        }

        public char getCurrentSymbol() {
            if (content.isEmpty()) {
                content = " ";
            }
            return this.content.charAt(position);
        }
    }
}
