package com.manuel_iglesias.util;

import java.util.List;

public class TreeGenerator {

	public <T extends Comparable<T>> Node<T> generateTree(List<T> values) {
		if(values.size() == 0) {
			return null;
		}
		
		Node<T> n = new Node<>();
		n.value = values.get(values.size() / 2);
		n.left = generateTree(values.subList(0, values.size() / 2));
		n.right = generateTree(values.subList((values.size() / 2) + 1, values.size()));
		
		return n;
	}

}
