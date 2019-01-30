package wmp.homework.parser;

import java.net.URL;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.Connection;

import wmp.homework.node.LinkedNodeList;
import wmp.homework.node.LowerCaseNode;
import wmp.homework.node.Node;
import wmp.homework.node.NumericNode;
import wmp.homework.node.UpperCaseNode;

public class SplitParser {
	private LinkedNodeList numericList = new LinkedNodeList('9'-'0' + 1);
	private LinkedNodeList alphabetList = new LinkedNodeList('Z'-'A' + 1);

	private void split0(Character character) {
		if (Character.isAlphabetic(character)) {
			if (Character.isLowerCase(character))
				alphabetList.addNode(new LowerCaseNode(character));
			else if(Character.isUpperCase(character))
				alphabetList.addNode(new UpperCaseNode(character));
		} else if (Character.isDigit(character)) {
			numericList.addNode(new NumericNode(character));
		}
	}

	protected StringBuilder build(StringBuilder builder) {
		Iterator<Node> aplhabetIter = alphabetList.iterator();
		Iterator<Node> numericIter = numericList.iterator();

		while(aplhabetIter.hasNext()) {
			builder.append(aplhabetIter.next());
			if (numericIter.hasNext())
				builder.append(numericIter.next());
		}

		while(numericIter.hasNext()) {
			builder.append(numericIter.next());
		}
		return builder;
	}

	protected String[] splitByDivision(StringBuilder builder, int division) {
		String quotientString = "";
		String remainderString = "";
		if (builder != null && division != 0) {
			int totalLength = builder.length();
			int quotient = totalLength / division;
			int remainder = totalLength % division;
			if (quotient != 0) {
				quotient = quotient * division;
				quotientString = builder.substring(0, quotient);
				if (remainder != 0)
					remainderString = builder.substring(quotient);
			} else if (remainder != 0) {
				remainderString = builder.toString();
			}
		}
		return new String[]{quotientString, remainderString};
	}

	public String[] request(String url, int division, String type) throws Exception {
		Document document = Jsoup.parse(new URL(url).openStream(), "UTF-8", url);
		return split(getData(document, type), division);
	}

	protected String[] split(String data, int division) {
		for (int i = 0; i < data.length(); i++) {
			split0(data.charAt(i));
		}
		return splitByDivision(build(new StringBuilder()), division);
	}

	protected String getData(Document document, String type) {
		if (type.equals("Text"))
			return document.text();
		return document.html();
	}
}
