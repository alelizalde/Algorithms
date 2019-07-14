package com.practices;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Test {

	public static void main(String args[]) {
		/*		System.out.println("test");
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(1);
		myList.add(3);
		myList.add(2);
		for(int x=0;x<myList.size();x++) {
			System.out.println(myList.get(x));
		}
		Collections.sort(myList);
		for(int x=0;x<myList.size();x++) {
			System.out.println(myList.get(x));
		}*/


		/*		BinaryTree tree = new BinaryTree( 20 );
		int[] nums = {15, 200, 25, -5, 0, 100, 20, 12, 126, 1000, -150};
		for(int i : nums ) {
		tree.addNode( i );
		}

		tree.traversePreOrder();
		tree.traverseInOrder();
		tree.traversePostOrder();*/
		/*		MyTreeNode<String> root = new MyTreeNode<>("Root");

		MyTreeNode<String> child1 = new MyTreeNode<>("Child1");
		child1.addChild("Grandchild1");
		child1.addChild("Grandchild2");

		MyTreeNode<String> child2 = new MyTreeNode<>("Child2");
		child2.addChild("Grandchild3");

		root.addChild(child1);
		root.addChild(child2);
		root.addChild("Child3");

		root.addChildren(Arrays.asList(
		        new MyTreeNode<>("Child4"),
		        new MyTreeNode<>("Child5"),
		        new MyTreeNode<>("Child6")
		));

		for(MyTreeNode node : root.getChildren()) {
		    System.out.println(node.getData());
		}*/

		/*		Trie trie = new Trie();
		System.out.println(trie.checkPresentAndAdd("google.com"));
		System.out.println(trie.checkPresentAndAdd("google.org"));
		System.out.println(trie.checkPresentAndAdd("test.org"));
		System.out.println(trie.checkPresentAndAdd("google.com"));*/

		/*		MaxStack maxstack = new MaxStack();
		maxstack.push(3);
		maxstack.push(3);		
		maxstack.push(4);
		maxstack.push(4);
		maxstack.push(3);
		maxstack.push(3);

		maxstack.pop();
		System.out.println("getMax: "+maxstack.getMax());
		maxstack.pop();
		System.out.println("getMax: "+maxstack.getMax());
		maxstack.pop();
		System.out.println("getMax: "+maxstack.getMax());
		maxstack.pop();
		System.out.println("getMax: "+maxstack.getMax());*/


		final String FILENAME = "/Users/alfonso/Documents/tmp.txt";


		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME,true))) {

			String content = "This is the content to write into file\n";
			//bw.newLine();
			bw.write(System.currentTimeMillis()+" - "+content);
			//bw.append(content);

			// no need to close it.
			//bw.close();

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		}

		String line = null;
		try (BufferedReader br = new BufferedReader(new FileReader("/Users/alfonso/Documents/tmp.txt"))){
			while((line = br.readLine())!=null) {
				System.out.println(line);
			}
		}catch (IOException e) {

			e.printStackTrace();

		}


		HashMap<Integer,String> map = new HashMap<Integer,String> ();
		map.put(12323213, "original");

		File directory = new File("/Users/alfonso/Documents/");
		File[] contents = directory.listFiles();
		for ( File f : contents) {
			System.out.println(f.getAbsolutePath()+" - "+ f.isFile() +" - "+f.isDirectory() +" - "+ f.lastModified()+
					" - "+ f.length());
		}
	}
}
