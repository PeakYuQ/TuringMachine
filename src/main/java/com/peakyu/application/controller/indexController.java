package com.peakyu.application.controller;


import com.peakyu.application.State;
import com.peakyu.application.Transition;
import com.peakyu.application.TuringMachine;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


@Controller
public class indexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }




    TuringMachine choseTransition(Integer rules){
        Set<Transition> transitions = new HashSet<>();
        if (rules == 1){
            State q[] = new State[4];
            for (int i = 0; i < 4; ++i) {
                q[i] = new State();
            }
            State qf = q[3];
            transitions.add(new Transition(q[0], '0', q[1], '1', Transition.Direction.RIGHT));
            transitions.add(new Transition(q[0], '1', q[2], '0', Transition.Direction.RIGHT));
            transitions.add(new Transition(q[0], ' ', qf, ' ', Transition.Direction.NONE));
            transitions.add(new Transition(q[1], '0', q[1], '0', Transition.Direction.RIGHT));
            transitions.add(new Transition(q[1], '1', q[1], '1', Transition.Direction.RIGHT));
            transitions.add(new Transition(q[1], ' ', qf, ' ', Transition.Direction.NONE));
            transitions.add(new Transition(q[2], '0', q[1], '1', Transition.Direction.RIGHT));
            transitions.add(new Transition(q[2], '1', q[2], '0', Transition.Direction.RIGHT));
            transitions.add(new Transition(q[2], ' ', qf, '1', Transition.Direction.NONE));
            Set<State> finalStates = new HashSet<>();
            finalStates.add(qf);
            TuringMachine TL = new TuringMachine(transitions, q[0], finalStates);
            return TL;

        }
        else if (rules == 2){
            State q[] = new State[9];
            for (int i = 0; i < 9; ++i) {
                q[i] = new State();
            }
            State qf = new State();

            transitions.add(new Transition(q[0], '0', q[1], ' ', Transition.Direction.RIGHT));
            transitions.add(new Transition(q[0], ' ', q[8], ' ', Transition.Direction.RIGHT));

            transitions.add(new Transition(q[1], '0', q[1], '0', Transition.Direction.RIGHT));
            transitions.add(new Transition(q[1], ' ', q[2], ' ', Transition.Direction.RIGHT));
            transitions.add(new Transition(q[2], '0', q[3], '1', Transition.Direction.RIGHT));
            transitions.add(new Transition(q[3], '0', q[3], '0', Transition.Direction.RIGHT));
            transitions.add(new Transition(q[3], ' ', q[4], ' ', Transition.Direction.RIGHT));
            transitions.add(new Transition(q[4], '0', q[4], '0', Transition.Direction.RIGHT));
            transitions.add(new Transition(q[4], ' ', q[5], '0', Transition.Direction.LEFT));
            transitions.add(new Transition(q[5], '0', q[5], '0', Transition.Direction.LEFT));
            transitions.add(new Transition(q[5], ' ', q[5], ' ', Transition.Direction.LEFT));
            transitions.add(new Transition(q[5], '1', q[2], '0', Transition.Direction.RIGHT));
            transitions.add(new Transition(q[2], ' ', q[6], ' ', Transition.Direction.LEFT));

            transitions.add(new Transition(q[6], '0', q[6], '0', Transition.Direction.LEFT));
            transitions.add(new Transition(q[6], ' ', q[7], ' ', Transition.Direction.LEFT));
            transitions.add(new Transition(q[7], '0', q[7], '0', Transition.Direction.LEFT));
            transitions.add(new Transition(q[7], ' ', q[0], ' ', Transition.Direction.RIGHT));

            transitions.add(new Transition(q[0], ' ', q[8], ' ', Transition.Direction.RIGHT));
            transitions.add(new Transition(q[8], '0', q[8], ' ', Transition.Direction.RIGHT));
            transitions.add(new Transition(q[8], ' ', qf, ' ', Transition.Direction.RIGHT));

            // Create set with single final state q_f
            Set<State> finalStates = new HashSet<>();
            finalStates.add(qf);

            TuringMachine TL = new TuringMachine(transitions, q[0], finalStates);
            return TL;

        }
        else if (rules == 3){
            State q[] = new State[8];
            for (int i = 0; i < 8; ++i) {
                q[i] = new State();
            }
            State qf = new State();

            transitions.add(new Transition(q[0], '0', q[1], '0', Transition.Direction.RIGHT));
            transitions.add(new Transition(q[0], '1', q[2], '0', Transition.Direction.RIGHT));

            transitions.add(new Transition(q[1], '0', q[6], '0', Transition.Direction.LEFT));

            transitions.add(new Transition(q[1], '1', q[2], '0', Transition.Direction.RIGHT));

            transitions.add(new Transition(q[2], '0', q[3], '0', Transition.Direction.RIGHT));
            transitions.add(new Transition(q[2], '1', q[2], '1', Transition.Direction.RIGHT));
            transitions.add(new Transition(q[3], '0', q[4], '1', Transition.Direction.LEFT));
            transitions.add(new Transition(q[3], '1', q[3], '1', Transition.Direction.RIGHT));
            transitions.add(new Transition(q[4], '0', q[5], '0', Transition.Direction.LEFT));
            transitions.add(new Transition(q[4], '1', q[4], '1', Transition.Direction.LEFT));
            transitions.add(new Transition(q[5], '0', q[1], '1', Transition.Direction.RIGHT));
            transitions.add(new Transition(q[5], '1', q[5], '1', Transition.Direction.LEFT));
            transitions.add(new Transition(q[6], '0', q[7], '0', Transition.Direction.RIGHT));

            transitions.add(new Transition(q[6], '1', q[6], '1', Transition.Direction.LEFT));
            transitions.add(new Transition(q[7], '0', qf, '0', Transition.Direction.NONE));
            transitions.add(new Transition(q[7], '1', qf, '1', Transition.Direction.NONE));


            // Create set with single final state q_f
            Set<State> finalStates = new HashSet<>();
            finalStates.add(qf);

            TuringMachine TL = new TuringMachine(transitions, q[0], finalStates);
            return TL;

        }
        else{

            State q[] = new State[4];
            for (int i = 0; i < 4; ++i) {
                q[i] = new State();
            }
            State qf = q[3];



            // Create transitions
            transitions.add(new Transition(q[0], '1', q[0], '1', Transition.Direction.RIGHT));
            transitions.add(new Transition(q[0], ' ', q[1], '1', Transition.Direction.RIGHT));
            transitions.add(new Transition(q[1], '1', q[1], '1', Transition.Direction.RIGHT));
            transitions.add(new Transition(q[1], ' ', q[2], ' ', Transition.Direction.LEFT));

            transitions.add(new Transition(q[2], '1', q[2], ' ', Transition.Direction.NONE));
            transitions.add(new Transition(q[2], ' ', qf, ' ', Transition.Direction.NONE));
            // Create set with single final state q_f
            Set<State> finalStates = new HashSet<>();
            finalStates.add(qf);

            TuringMachine TL = new TuringMachine(transitions, q[0], finalStates);
            return TL;
        }
    }



    @PostMapping("/tuling")
    public String dispose(@RequestParam("rules") Integer rules, @RequestParam("speed") Integer speed,
                          @RequestParam("data") String data, HttpSession session, Model model){
        State.setIndex(0);
        session.setAttribute("speed",speed);
        session.setAttribute("rules",rules);
        List<Character> da = new LinkedList<>();
        for (int i=0;i<data.length();i++)
        da.add(data.charAt(i));
        session.setAttribute("data",da);
        // Create transitions
        TuringMachine TL = choseTransition(rules);
        String result = TL.run(data);

        if (result.equals("error")){

            model.addAttribute("tip","error");
           // return "index";
        }

        Integer[] Pos =TL.getPos();
        String[] Str =TL.getStrings();
        String[] rul =TL.getRules();   //三项原则

        Integer total=0;
        for (int j = 0; j< Pos.length; j++)
            if (Pos[j] == null){
                total = j;
                break;
            }

        session.setAttribute("Str",Str);
        session.setAttribute("Pos",Pos);
        session.setAttribute("rul",rul);
        session.setAttribute("current",-1);
        session.setAttribute("total",total);
        for(int i=0;Str[i]!=null;i++){
            System.out.println("第"+i+"次："+Str[i]+"位置："+Pos[i]+"规则："+rul[i]);
        }


        return "addone";


    }


    @PostMapping("/addone")
    public String addone(@RequestParam(name = "current",defaultValue = "1") Integer current,HttpSession session, Model model){

        String[] str = (String[])session.getAttribute("Str");


        //设置纸带内容
        List<Character> da = new LinkedList<>();
        for (int i=0;i<str[current].length();i++)
            da.add(str[current].charAt(i));
        session.setAttribute("data",da);
        session.setAttribute("current",current+1);

        //设置位置
        Integer[] pos = (Integer[])session.getAttribute("Pos");
        model.addAttribute("pos",pos[current]);

        //设置规则
        String[] rul = (String[])session.getAttribute("rul");

        String[] a = new String[5];

        if(rul[current] != null){

            a[0] = rul[current].substring(0,1);
            a[1] = rul[current].substring(1,2);
            a[2] = rul[current].substring(2,3);
            a[3] = rul[current].substring(3,4);
            a[4] = rul[current].substring(4,5);
            if(a[1].equals(" "))
                a[1] = "B";
            if(a[3].equals(" "))
                a[3] = "B";
        }else{
            a =null;
        }
        model.addAttribute("rul",a);



        return "addone";

    }


    @PostMapping("/Noaddone")
    public String Noaddone(@RequestParam(name = "current",defaultValue = "1") Integer current,HttpSession session, Model model){

        String[] str = (String[])session.getAttribute("Str");


        //设置纸带内容
        List<Character> da = new LinkedList<>();
        for (int i=0;i<str[current].length();i++)
            da.add(str[current].charAt(i));
        session.setAttribute("data",da);
        session.setAttribute("current",current+1);

        //设置位置
        Integer[] pos = (Integer[])session.getAttribute("Pos");
        model.addAttribute("pos",pos[current]);

        //设置规则
        String[] rul = (String[])session.getAttribute("rul");

        String[] a = new String[5];

        if(rul[current] != null){

            a[0] = rul[current].substring(0,1);
            a[1] = rul[current].substring(1,2);
            a[2] = rul[current].substring(2,3);
            a[3] = rul[current].substring(3,4);
            a[4] = rul[current].substring(4,5);
            if(a[1].equals(" "))
                a[1] = "B";
            if(a[3].equals(" "))
                a[3] = "B";
        }else{
            a =null;
        }
        model.addAttribute("rul",a);



        return "NOaddone";

    }



    @GetMapping("/table")
    public String Page1Table(){
        return "table";
    }

    @GetMapping("/chart")
    public String Page1Chart(){
        return "chart";
    }


}
