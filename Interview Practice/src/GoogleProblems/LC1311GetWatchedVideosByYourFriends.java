package GoogleProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LC1311GetWatchedVideosByYourFriends {

	public static List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {


		HashMap<String, Integer> foundVideos = new HashMap<String, Integer>();
		HashSet<Integer> seenIds = new HashSet<Integer>();
		foundVideos(seenIds, foundVideos, watchedVideos, friends, id, level);




		return null;
	}


	public static void foundVideos(HashSet<Integer> seenIds, HashMap<String, Integer> foundVideos, List<List<String>> watchedVideos, int[][] friends, int id, int level) {

		seenIds.add(id);

		if (level == 1) {
			for (int j = 0; j < friends[id].length; j++) {
				if (!seenIds.contains(friends[id][j])) {
					seenIds.add(friends[id][j]);
					for (int k = 0; k < watchedVideos.get(friends[id][j]).size(); k++) {
						if (foundVideos.containsKey(watchedVideos.get(friends[id][j]).get(k))) {
							int value = foundVideos.get(watchedVideos.get(friends[id][j]).get(k));
							foundVideos.put(watchedVideos.get(friends[id][j]).get(k), value+1);
						}
						else {
							foundVideos.put(watchedVideos.get(friends[id][j]).get(k), 1);
						}
					}
				}
			}

			return;
		} 

		int newLevel = level-1;
		for (int i = 0; i < friends[id].length; i++) {
			foundVideos(seenIds, foundVideos, watchedVideos, friends, friends[id][i], newLevel);
		}


	}


	public static void main(String[] args) {
		List<List<String>> watchedVideos = new ArrayList<List<String>>();
		ArrayList<String> video1 = new ArrayList<String>();
		ArrayList<String> video2 = new ArrayList<String>();
		ArrayList<String> video3 = new ArrayList<String>();
		ArrayList<String> video4 = new ArrayList<String>();
		video1.add("A"); video1.add("B");
		video2.add("C");
		video3.add("B"); video3.add("C");
		video4.add("D");
		watchedVideos.add(video1); watchedVideos.add(video2); watchedVideos.add(video3); watchedVideos.add(video4);

		int[][] friends = {new int[] {1,2}, new int[] {0,3}, new int[] {0,3}, new int[] {1,2}};

		int id = 0;
		int level = 2;

		watchedVideosByFriends(watchedVideos, friends, id, level);


	}

}
