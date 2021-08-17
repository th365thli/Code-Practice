package Problems;

import java.util.ArrayList;
import java.util.Random;

public class LC843GuessTheWord {


	public static String[] wordlist;


	public static void findSecretWord(String[] wordlist, Master master) {
		LC843GuessTheWord.wordlist = wordlist;
		int k = 10;
		int match = 0;
		int oldMatch = 0;
		String word = "";
		Random rand = new Random();
		int selection;
		while (k >= 0) {
			if (LC843GuessTheWord.wordlist.length > 0) {
				selection = rand.nextInt(LC843GuessTheWord.wordlist.length);
				word = LC843GuessTheWord.wordlist[selection];
			}
			match = master.guess(word);
			if (match == 6) {
				System.out.println("Congrats you found the fucking word");
				return;
			} 
//			else if (match <= oldMatch) {
//				String[] newList = new String[GuessTheWord843.wordlist.length-1];
//				for (int i = 0; i < GuessTheWord843.wordlist.length-1; i++) {
//					newList[i] = GuessTheWord843.wordlist[i+1];
//				}
//				GuessTheWord843.wordlist = newList;
//			} 
			else {
				LC843GuessTheWord.wordlist = match(word, master, match);
				oldMatch = match;
			}
			k--;
		}

	}

	public static String[] match(String guess, Master master, int match) {
		ArrayList<String> list = new ArrayList<String>();
		for (String word : LC843GuessTheWord.wordlist) {
			if (!word.equals(guess)) {
				int count = 0;
				for (int k = 0; k < 6; k++) {
					if (word.charAt(k) == guess.charAt(k)) {
						count++;
					}
				}
				if (count == match) {
					list.add(word);
				}
			}
		}

		String[] array = new String[list.size()];
		array = list.toArray(array);
		return array;

	}


	public static void main(String[] args) {
		LC843GuessTheWord guess = new LC843GuessTheWord();
		String[] wordlist =	{"gaxckt","trlccr","jxwhkz","ycbfps","peayuf","yiejjw","ldzccp","nqsjoa","qrjasy","pcldos","acrtag","buyeia","ubmtpj","drtclz","zqderp","snywek","caoztp","ibpghw","evtkhl","bhpfla","ymqhxk","qkvipb","tvmued","rvbass","axeasm","qolsjg","roswcb","vdjgxx","bugbyv","zipjpc","tamszl","osdifo","dvxlxm","iwmyfb","wmnwhe","hslnop","nkrfwn","puvgve","rqsqpq","jwoswl","tittgf","evqsqe","aishiv","pmwovj","sorbte","hbaczn","coifed","hrctvp","vkytbw","dizcxz","arabol","uywurk","ppywdo","resfls","tmoliy","etriev","oanvlx","wcsnzy","loufkw","onnwcy","novblw","mtxgwe","rgrdbt","ckolob","kxnflb","phonmg","egcdab","cykndr","lkzobv","ifwmwp","jqmbib","mypnvf","lnrgnj","clijwa","kiioqr","syzebr","rqsmhg","sczjmz","hsdjfp","mjcgvm","ajotcx","olgnfv","mjyjxj","wzgbmg","lpcnbj","yjjlwn","blrogv","bdplzs","oxblph","twejel","rupapy","euwrrz","apiqzu","ydcroj","ldvzgq","zailgu","xgqpsr","wxdyho","alrplq","brklfk"};
		Master master = guess.new Master();

		findSecretWord(wordlist, master);

	

	}



	class Master {

		public String secret = "hbaczn";

		public int guess(String word) {
			int count = 0;
			for (int i = 0; i < 6; i++) {
				if (word.charAt(i) == this.secret.charAt(i)) {
					count++;
				}
			}
			return count;
		}



	}

}
