package com.practices;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TreeNodePC<T> implements Iterable<TreeNodePC<T>> {

    T data;
    TreeNodePC<T> parent;
    List<TreeNodePC<T>> children;

    public TreeNodePC(T data) {
        this.data = data;
        this.children = new LinkedList<TreeNodePC<T>>();
    }

    public TreeNodePC<T> addChild(T child) {
        TreeNodePC<T> childNode = new TreeNodePC<T>(child);
        childNode.parent = this;
        this.children.add(childNode);
        return childNode;
    }

	@Override
	public Iterator<TreeNodePC<T>> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

    // other features ...

}