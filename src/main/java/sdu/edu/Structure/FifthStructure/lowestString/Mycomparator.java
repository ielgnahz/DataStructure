package sdu.edu.Structure.FifthStructure.lowestString;

import java.util.Comparator;

public class Mycomparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return (o1+o2).compareTo(o2+o1);
	}

}
