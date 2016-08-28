package com.my.lc;

import java.util.List;

public class RunCases {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 332.Reconstruct Itinerary
		// https://leetcode.com/problems/reconstruct-itinerary/		
		String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		String[][] tickets2 = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		ReconstructItinerary itinerarySolution = new ReconstructItinerary();
//		List<String> itinerary = itinerarySolution.findItinerary(tickets);
//		System.out.println(itinerary);
		System.out.println(itinerarySolution.findItinerary(tickets2));
	}

}
