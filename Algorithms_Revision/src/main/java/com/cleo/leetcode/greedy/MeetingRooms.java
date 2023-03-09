package com.cleo.leetcode.greedy;

import java.util.*;

public class MeetingRooms {

    static class Activity{
        int start;
        int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Activity() {
        }
    }
    public int minMeetingRooms(int[][] intervals) {
        Queue<Activity> activitySet = new PriorityQueue<>((a, b) -> a.start - b.end);
        for (int[] interval : intervals) {
            activitySet.add(new Activity(interval[0], interval[1]));
        }
        int rooms = 1;
        if (intervals.length == 1)
            return 1;
        Activity first = activitySet.poll();
        int start = first.start;
        int end = first.end;

        while (activitySet.size() > 0) {
            Activity current = activitySet.poll();
            if (current.start < first.end) {
                rooms++;



            }
            first = current;



        }
        return rooms;
    }

    public static void main(String[] args) {
        int[][] intervals = {{2,11},{6,16},{11,16}};
        MeetingRooms meetingRooms = new MeetingRooms();
        System.out.println(meetingRooms.minMeetingRooms(intervals));
    }
}