
public class Link {
	Link next;
	String data;
	
	public Link(String Data){
		next = null;
		data = Data;
	}
	
	public Link(Link Next, String Data){
		this.next = Next;
		this.data = Data;
	}
	
	public String getData(){
		return this.data;
	}
	
	public void setData(String Data){
		this.data = Data;
	}
	
	public Link getNext(){
		return this.next;
	}
	
	public void setNext(Link Next){
		this.next = Next;
	}
}
