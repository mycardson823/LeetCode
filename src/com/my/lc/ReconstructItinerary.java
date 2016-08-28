package com.my.lc;

import java.util.ArrayList;
import java.util.List;

public class ReconstructItinerary {
	
	public List<String> findItinerary(String[][] tickets) {
        int i = tickets.length;
        int selected[] = new int[i];
        List<String> itinerary = new ArrayList<String>();
        String start = "JFK";
        itinerary.add(start);
        DFS(tickets, start, selected, itinerary);
        return itinerary;
    }

    boolean DFS(String[][] tickets, String departure, int[] selected, List<String> itinerary){
    	int i = tickets.length;
    	int count = itinerary.size();
    	if (count == i + 1)
    		return true;
    	ArrayList<Integer> arrivalList = new ArrayList<Integer>();
    	for (int j = 0; j < i; j++) {
    		if ((tickets[j][0] == departure) && (selected[j] == 0)) 
    			arrivalList.add(j);   				
    	}
    	int nArrival = arrivalList.size();
    	
    	// No next arrival found, back track
    	if ( nArrival == 0) {		  		
    		itinerary.remove(count - 1);
    		return false;
    	}
    	
    	// Sort by lexical order of arrival airport
    	for (int k = 1; k < nArrival; k++) {
    		int index = arrivalList.get(k);
    		String temp = tickets[index][1];
    		int in = k;
    		while (in > 0 && tickets[arrivalList.get(in - 1)][1].charAt(0) > temp.charAt(0)) {
    			arrivalList.set(in, arrivalList.get(in - 1));
    			in--;
    		}
    		arrivalList.set(in, index);
    	}
    	
    	// Search using different arrival airports as new departures
    	for (int l = 0; l < nArrival; l++) {
    		selected[arrivalList.get(l)] = 1;
    		departure = tickets[arrivalList.get(l)][1];
    		itinerary.add(departure);
    		if (DFS(tickets, departure, selected, itinerary)) {
    			
    			return true;
    		}
    		else
    			selected[arrivalList.get(l)] = 0;
    	}  	
    	return false;
    }
}
