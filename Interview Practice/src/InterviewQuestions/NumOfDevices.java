package InterviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class NumOfDevices {


	public static int[] numberOfDevices(String[][] connections, String[] toggleIps) {

		int[] log = new int[toggleIps.length];
		HashMap<String, Set<String>> cMap = new HashMap<String, Set<String>>();
		HashMap<String, Boolean> ipState = new HashMap<String, Boolean>();

		for (int i = 0; i < connections.length; i++) {
			ipState.put(connections[i][0], false);
			ipState.put(connections[i][1], false);
		}


		for (int i = 0; i < connections.length; i++) {
			//build connection map
			if (cMap.get(connections[i][0]) != null) {
				cMap.get(connections[i][0]).add(connections[i][1]);
			} else {
				HashSet<String> clist = new HashSet<String>();
				clist.add(connections[i][1]);
				cMap.put(connections[i][0], clist);
			}
			if (cMap.get(connections[i][1]) != null) {
				cMap.get(connections[i][1]).add(connections[i][0]);
			} else {
				HashSet<String> clist = new HashSet<String>();
				clist.add(connections[i][0]);
				cMap.put(connections[i][1], clist);
			}
		}

		Set<String> current = new HashSet<String>();
		int count = 0;
		int logCount = 0;
		for (String ip : toggleIps) {
			//get all connections for current connection
			//get current state;
			if (ipState.get(ip) != null) {
				Boolean state = ipState.get(ip);
				Boolean newState = !state;
				ipState.put(ip, newState);
				current = cMap.get(ip);
				for (String connection : current) {
					if (ipState.get(connection) == true) {
						count++;
					}
				}
				log[logCount] = count;
			}
			logCount++;
			count=0;
		}


		return log;

	}


	public static void main(String[] args) {
		String[] c1 = {"192.167.0.0", "192.167.0.1"};
		String[] c2 = {"192.167.0.2", "192.167.0.0"};
		String[] c3 = {"192.167.0.0", "192.167.0.3"}; 

		String[][] connections = {c1, c2, c3};

		String[] toggleIps = {"192.167.0.1", "192.167.0.0", "192.167.0.2", "192.167.0.0", "0.0.0.0"};

		System.out.println(Arrays.toString(numberOfDevices(connections, toggleIps)));


	}




}
