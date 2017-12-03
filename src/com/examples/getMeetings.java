package com.examples;

import java.util.HashMap;
import java.util.Iterator;

public class getMeetings {
	public static void main(String[] args) {
		Meeting[] meetings = {
				new Meeting(4, 8),
				new Meeting(0, 1),
				new Meeting(3, 5),
				new Meeting(4, 6), 
				new Meeting(10, 12), 
				new Meeting(9, 10)};
		getMeetingSet(meetings);

	}

	private static void getMeetingSet(Meeting[] meetings) {
		HashMap<Integer,Integer> meeting = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> mergedMeetings = new HashMap<Integer,Integer>();
		for(int i=0;i<meetings.length;i++) {
			if(meeting.containsKey(meetings[i].getStartTime())) {
				meeting.put(meetings[i].getStartTime(),
						Math.max(meetings[i].getEndTime(), meeting.get(meetings[i].getStartTime())));
			}else { 
				meeting.put(meetings[i].getStartTime(), meetings[i].getEndTime());
			}
		}
		
		System.out.println(mergedMeetings);
		
/*		Iterator it = meeting.entrySet().iterator();
		while(it.hasNext()) {
			 Entry item = (Entry) it.next();
			for(int x=item.getKey();x<=item.getValue();x++)
				if(meeting.containsKey(x)) {
					meeting.put(k,
							Math.max(v, meeting.get(x)));
					if(x!=k)
						it. .remove(x);
					System.out.println(meeting);
				}	*/	

		
		meeting.forEach((k,v)->{
			for(int x=k;x<=v;x++)
				if(meeting.containsKey(x)) {
					meeting.put(k,
							Math.max(v, meeting.get(x)));
					if(x!=k)
					    meeting.remove(x);
					System.out.println(meeting);
				}

		});

		System.out.println(mergedMeetings);

	}
}
