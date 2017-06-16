package Problems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FriendMap {
	
	 static int[] getTheGroups(int n, String[] queryType, int[] students1, int[] students2) {
		 	int[] answer = new int[10*10*10*10*10];
		 	int answerCount = 0;
	        HashMap<Integer, HashSet<Integer>> friendMap = new HashMap<Integer, HashSet<Integer>>();
	        for (int i = 1; i <= n; i++) {
	        	HashSet<Integer> subSet = new HashSet<Integer>();
	        	subSet.add(i);
	        	friendMap.put(i, subSet);
	        }
	        for (String query : queryType) {
	            String[] params = query.split("");
	            if (params.equals("FRIEND")) {
	                	friendMap.get(students1).addAll(friendMap.get(students2));
	                	friendMap.get(students2).addAll(friendMap.get(students1));
	            }
	            else if (params.equals("TOTAL")) {
	            	int count = 0;
	            	Set<Integer> keySet = friendMap.keySet();
	            	for (Integer i : keySet) {
	            		count = count + friendMap.get(i).size();
	            	}
	            	answer[answerCount] = count;
	            	answerCount++;
	            }
	        }
	        
	        
	        
	        return answer;

	    }
	 
	 public static void main(String[] args) throws IOException{
	        Scanner in = new Scanner(System.in);
	        final String fileName = System.getenv("OUTPUT_PATH");
	        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
	        int[] res;
	        int _n;
	        _n = Integer.parseInt(in.nextLine().trim());
	        
	        
	        int _queryType_size = 0;
	        _queryType_size = Integer.parseInt(in.nextLine().trim());
	        String[] _queryType = new String[_queryType_size];
	        String _queryType_item;
	        for(int _queryType_i = 0; _queryType_i < _queryType_size; _queryType_i++) {
	            try {
	                _queryType_item = in.nextLine();
	            } catch (Exception e) {
	                _queryType_item = null;
	            }
	            _queryType[_queryType_i] = _queryType_item;
	        }
	        
	        
	        int _students1_size = 0;
	        _students1_size = Integer.parseInt(in.nextLine().trim());
	        int[] _students1 = new int[_students1_size];
	        int _students1_item;
	        for(int _students1_i = 0; _students1_i < _students1_size; _students1_i++) {
	            _students1_item = Integer.parseInt(in.nextLine().trim());
	            _students1[_students1_i] = _students1_item;
	        }
	        
	        
	        int _students2_size = 0;
	        _students2_size = Integer.parseInt(in.nextLine().trim());
	        int[] _students2 = new int[_students2_size];
	        int _students2_item;
	        for(int _students2_i = 0; _students2_i < _students2_size; _students2_i++) {
	            _students2_item = Integer.parseInt(in.nextLine().trim());
	            _students2[_students2_i] = _students2_item;
	        }
	        
	        res = getTheGroups(_n, _queryType, _students1, _students2);
	        for(int res_i=0; res_i < res.length; res_i++) {
	            bw.write(String.valueOf(res[res_i]));
	            bw.newLine();
	        }
	        
	        bw.close();
	    }


}
