package munna.ds;

import java.util.LinkedList;

public class CSLL<E> {

	public Node<E> head;

	private static class Node<E> {
		private E value;
		private Node<E> next;
		private Node(E value, Node<E> node) {
			this.value = value;
			this.next = node;
		}
	}

	void add(E e) {
		head = new Node<E>(e, head);
	}

	public int size() {
		int count = 1;
		Node<E> node;
		if (head == null)
			return 0;
		else {
			node = head;
			for (; node.next != null; node = node.next)
				count++;
		}
		return count;
	}

	E get(int index) {
		int size = size();
		Node<E> node;
		if (index <= size - 1) {
			node = head;			
			for (int count = size-1; count > index; node = node.next, count--);				
			return node.value;
		} else
			throw new IndexOutOfBoundsException("ArrayIndexOutOfBoundExcepton");

	}
	void addAfter(int x , E e)
	{
		Node<E> nodeIndex = head;
		Node<E> prevoiusNode = nodeIndex;
		for(int count =size()-1 ; count>x;prevoiusNode = nodeIndex,nodeIndex=nodeIndex.next,count--);
			System.out.println("\n [After ]"+nodeIndex.value);
		Node<E> newNode = new Node<E>(e,nodeIndex);//or prevoiusNode.next
		prevoiusNode.next=newNode;
		
		
	}
	void addBefore(int x , E e)
	{
		Node<E> nodeIndex = head;		
		for(int count=size()-1; count>x;nodeIndex =nodeIndex.next,count--);			
		System.out.println("\n [Before ]"+nodeIndex.value);
		Node<E> newNode = new Node<E>(e,nodeIndex.next);
		nodeIndex.next=newNode;
		
	}
	void addFirst(E e)
	{
		Node<E> first = head;	
		for(;first.next!=null;first=first.next);		
		Node<E> newNode = new Node<E>(e,null);
		first.next=newNode;
		
	}
	void addLast(E e)
	{
		add(e);
	}
	void remove(E e)
	{
		Node<E> node,prenode;
		node = head;
		prenode=head;
		for(;!e.equals(node.value)&& node!=null ;prenode = node ,node=node.next);					
			prenode.next = node.next;
		node=null;
		
		
	}
	void retreiveNodesInReverseOrder()
	{
		System.out.println();
		System.out.print(" [Reverse Print] ");
		//for(Node<E> node=head; node!=null;node=node.next)
			//System.out.print(node.value+",");
		//System.out.println("");
		Node<E> tail;		
		Node<E> previous=null;
		for(Node<E> node=head; node!=null ;node=node.next)
		{
			for(tail=head;tail.next!=previous;tail=tail.next);
			previous =tail;			
			System.out.print(tail.value+",");
			 			
		}
	}

	public static void main(String[] args) {
		CSLL<String> cll = new CSLL<String>();	
		// ll.g
		cll.add("One");// 0
		cll.add("two");// 1
		cll.add("three");// 2
		cll.add("four");// 3
		cll.retreiveNodesInReverseOrder();
		cll.addBefore(3, "addBefore");
		cll.retreiveNodesInReverseOrder();
		cll.addAfter(1, "addAfter");
		cll.retreiveNodesInReverseOrder();
		cll.addFirst("addFirst");
		cll.retreiveNodesInReverseOrder();
		//cll.retreiveAllNodes();
		//cll.remove("three");		
		//cll.retreiveAllNodes();
		//System.out.println(cll.get(5));// +"[]"+cll.size());
		
		LinkedList<String> ll = new LinkedList<String>();	
		//ll.clear().pop()
		//ll.add(index, element)
		ll.add("One");// 3
		ll.add("two");// 2
		ll.add("three");// 1
		ll.add("four");// 0
		//System.out.println(ll.get(5));// +"[]"+cll.size());
	}

}
