package GoogleProblems;

import java.util.ArrayList;
import java.util.List;

public class LC0068TestJustification {
	
	public static StringBuilder sb = new StringBuilder();
	public static int MAXWIDTH;

	public static List<String> fullJustify(String[] words, int maxWidth) {
		MAXWIDTH = maxWidth;
		int lineCounter = 0;
		ArrayList<String> line = new ArrayList<String>();
		ArrayList<String> answer = new ArrayList<String>();
		for (int i = 0; i < words.length; i++) {
			if (line.size() == 0) {
				line.add(words[i]);
				lineCounter = lineCounter + words[i].length();
			}
			else if (lineCounter + words[i].length() + 1 > maxWidth) { //The '1' accounts for the space
				answer.add(justify(line, lineCounter));
				line.clear();
				line.add(words[i]);
				lineCounter = words[i].length();
			}

			else {
				line.add(words[i]);
				lineCounter = lineCounter + words[i].length() + 1;
			}

		}

		answer.add(justifyLastLine(line, lineCounter));
		return answer;
	}


	public static String justify(List<String> line, int lineCounter) {
		
		sb.setLength(0);
		int numOfSpaces = MAXWIDTH - lineCounter + (line.size() -1);

		int spacePerWord = 0;
		int extraSpaces = 0;
		if (line.size() > 1) {
			spacePerWord = numOfSpaces/(line.size()-1);
			extraSpaces = numOfSpaces % (line.size() - 1);
		}
		else {
			spacePerWord = MAXWIDTH - line.get(0).length();
			extraSpaces = 0;
		}
		int spaceCount = 0;

		int extraSpaceCount = 0;
		int lineIndex = 0;
		int lineCount = 0;
		while(lineCount <= MAXWIDTH && lineIndex < line.size()) {
			sb.append(line.get(lineIndex));
			lineCount = lineCount + line.get(lineIndex).length();
			if (lineCount == MAXWIDTH) {
				break;
			}
			while (spaceCount < spacePerWord) {
				sb.append(" ");
				spaceCount++;
				lineCount++;
			}
			spaceCount = 0;
			if (extraSpaceCount < extraSpaces) {
				sb.append(" ");
				lineCount++;
			}
			extraSpaceCount++;
			lineIndex++;
		}

		return sb.toString();

	}

	public static String justifyLastLine(List<String> line, int lineCounter) {
		sb.setLength(0);
		int numOfSpaces = MAXWIDTH - lineCounter;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < line.size(); i++) {
			sb.append(line.get(i));
			if (i != line.size() -1) {
				sb.append(" ");
			}
		}
		
		int spaceCount = 0;
		while(spaceCount < numOfSpaces) {
			sb.append(" ");
			spaceCount++;
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String[] test = {"What","must","be","acknowledgment","shall","be"};

		int maxWidth = 16;

		List<String> answer = fullJustify(test, maxWidth);
		for (int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i));
		}

	}
}
