package com.example.templete;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Xiao
 * @Date: 2019/6/27 :8:42
 * @Description:
 */
public class Room extends Controller {
    public Room(){
        super();
    }
    private boolean light =false;
    class lightOff extends Event{
        public lightOff(long delayTime){
            super(delayTime);
            addEvent(this);
        }
        @Override
        public void action() {
            light=false;
        }

        @Override
        public String toString() {
            return "light off";
        }
    }
    class lightOn extends Event{
        public lightOn(long delayTime){
            super(delayTime);
            addEvent(this);
        }
        @Override
        public void action() {
            light=true;
        }
        @Override
        public String toString() {
            return "light on";
        }
    }
    class restart extends Event{
        private List<Event> eventList = new ArrayList();
        public restart(long delayTime,List<Event> eventList) {
            super(delayTime);
            this.eventList = eventList;
            addEvent(this);
        }

        @Override
        public void action() {
            for (Event event:eventList){
                addEvent(event);
                event.start();
            }
            addEvent(this);
        }
        @Override
        public String toString() {
            return "restart";
        }
    }
    class terminate extends Event{

        public terminate(long delayTime) {
            super(delayTime);
            addEvent(this);
        }

        @Override
        public void action() {
            System.exit(0);
        }
    }
}
