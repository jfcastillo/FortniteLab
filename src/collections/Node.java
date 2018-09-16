package collections;

public class Node<P> {
	
	private Node<P> next;
	private P info;
	
	public Node(P elem){
		info = elem;
	}
	public boolean NodoEnlazadoSimple() {
		return true;
	}
	public Node<P> getNext() {
		return next;
	}
	public void setNext(Node<P> next) {
		this.next = next;
	}
	public P getInfo() {
		return info;
	}
	public void setInfo(P info) {
		this.info = info;
	}
	public void disconectNext() {
		next = next.next;
	}
	
}
