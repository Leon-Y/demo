package com.example.templete;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Xiao
 * @Date: 2019/6/27 :8:42
 * @Description:
 */
public class Controller {
    private List<Event> eventList = new ArrayList();
    public void addEvent(Event event){
        this.eventList.add(event);
        event.start();
    }
    public void run(){
        List<Event> events = new ArrayList<>(eventList);

        while (eventList.size() > 0) {
            for (Event e : events) {
                if (e.reday()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
            events.clear();
            events.addAll(eventList);
        }
    }
}
