package com.example.templete;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: Xiao
 * @Date: 2019/6/28 :9:07
 * @Description:
 */
public class testTemplete {
    public static void main(String[] args) {
        Room room = new Room();
        Room.lightOn lightOn = room.new lightOn(1000000000L);
        Event[] eventList = {
                room.new lightOff(2000000000L),
                room.new lightOn(3000000000L),
        };
        ArrayList<Event> events = new ArrayList<Event>(Arrays.asList(eventList));
        Room.restart restart = room.new restart(4000000000L, events);
//        room.new terminate(10000000000L);
        room.run();
    }
}
