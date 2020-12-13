package com.peakyu.application.controller;

import com.peakyu.application.State;
import com.peakyu.application.Transition;
import com.peakyu.application.TuringMachine;

import java.util.HashSet;
import java.util.Set;

public class decrease {
    public static void main(String[] args) {
        // Create states q_0, q_1, ..., q_8, q_f
        State q[] = new State[4];
        for (int i = 0; i < 4; ++i) {
            q[i] = new State();
        }
        State qf = q[3];



        // Create transitions
        Set<Transition> transitions = new HashSet<>();
        transitions.add(new Transition(q[0], '1', q[0], '1', Transition.Direction.RIGHT));
        transitions.add(new Transition(q[0], ' ', q[1], '1', Transition.Direction.RIGHT));
        transitions.add(new Transition(q[1], '1', q[1], '1', Transition.Direction.RIGHT));
        transitions.add(new Transition(q[1], ' ', q[2], ' ', Transition.Direction.LEFT));

        transitions.add(new Transition(q[2], '1', q[2], ' ', Transition.Direction.NONE));
        transitions.add(new Transition(q[2], ' ', qf, ' ', Transition.Direction.NONE));
        // Create set with single final state q_f
        Set<State> finalStates = new HashSet<>();
        finalStates.add(qf);

        // Create TM
        TuringMachine Amul = new TuringMachine(transitions, q[0], finalStates);

        // Test Amul with different tapes
        System.out.println("1111 11 1-result：" + Amul.run("1111 1"));

    }
}
