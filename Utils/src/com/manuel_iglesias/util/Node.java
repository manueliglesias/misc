package com.manuel_iglesias.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Node<T extends Comparable<?>> {

	public T value;
	public Node<T> left;
	public Node<T> right;
	
	@Override
	public String toString() {
		
		//return this.print("", true);
		return BTreePrinter.printNode(this);
	}
	
	/**
	 * Adapted from http://stackoverflow.com/a/8948691/194974
	 * @param prefix
	 * @param isTail
	 * @return
	 */
	@SuppressWarnings("unused")
	private String print(String prefix, boolean isTail) {
		StringBuilder sb = new StringBuilder();
		
        sb.append(prefix + (isTail ? "'-- " : "|-- ") + this.value).append('\n');
        if(this.left != null) {
        	sb.append(this.left.print(prefix + (isTail ? "    " : "|   "), false));
        }
        if (this.right != null) {
        	sb.append(this.right.print(prefix + (isTail ?"    " : "|   "), true));
        }
        
        return sb.toString();
    }
	
	/**
	 * Adapted from http://stackoverflow.com/a/4973083/194974
	 */
	private static class BTreePrinter {

	    public static <T extends Comparable<?>> String printNode(Node<T> root) {
	        int maxLevel = BTreePrinter.maxLevel(root);

	        return printNodeInternal(Collections.singletonList(root), 1, maxLevel);
	    }

	    private static <T extends Comparable<?>> String printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {
	        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
	            return "";

	        StringBuilder sb = new StringBuilder();
	        int floor = maxLevel - level;
	        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
	        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
	        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

	        sb.append(BTreePrinter.printWhitespaces(firstSpaces));

	        List<Node<T>> newNodes = new ArrayList<Node<T>>();
	        for (Node<T> node : nodes) {
	            if (node != null) {
	            	sb.append(node.value);
	                newNodes.add(node.left);
	                newNodes.add(node.right);
	            } else {
	                newNodes.add(null);
	                newNodes.add(null);
	                sb.append(" ");
	            }

	            sb.append(BTreePrinter.printWhitespaces(betweenSpaces));
	        }
	        sb.append('\n');

	        for (int i = 1; i <= endgeLines; i++) {
	            for (int j = 0; j < nodes.size(); j++) {
	            	sb.append(BTreePrinter.printWhitespaces(firstSpaces - i));
	                if (nodes.get(j) == null) {
	                	sb.append(BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1));
	                    continue;
	                }

	                if (nodes.get(j).left != null)
	                	sb.append("/");
	                else
	                	sb.append(BTreePrinter.printWhitespaces(1));

	                	sb.append(BTreePrinter.printWhitespaces(i + i - 1));

	                if (nodes.get(j).right != null)
	                	sb.append("\\");
	                else
	                	sb.append(BTreePrinter.printWhitespaces(1));

	                	sb.append(BTreePrinter.printWhitespaces(endgeLines + endgeLines - i));
	            }

	            sb.append('\n');
	        }

	       sb.append(printNodeInternal(newNodes, level + 1, maxLevel));
	       
	       return sb.toString();
	    }

	    private static String printWhitespaces(int count) {
	    	if(count <= 0) {
	    		return "";
	    	}
	    	
	    	char[] chars = new char[count];
	    	Arrays.fill(chars, ' ');
	    	
	    	return String.valueOf(chars);
	    }

	    private static <T extends Comparable<?>> int maxLevel(Node<T> node) {
	        if (node == null)
	            return 0;

	        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
	    }

	    private static <T> boolean isAllElementsNull(List<T> list) {
	        for (Object object : list) {
	            if (object != null)
	                return false;
	        }

	        return true;
	    }

	}

}
