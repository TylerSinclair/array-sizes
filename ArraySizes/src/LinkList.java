
public class LinkList {
	
	private Link head;
	private int listCount;
	
	public LinkList(){
		this.head = new Link(null);
		this.listCount = 0;
	}
	
	public void add(String data){
		Link temp = new Link(data);
		Link current = head;
		while(current.getNext() != null){
			current = current.getNext();
		}
		current.setNext(temp);
		listCount++;
	}
	
	public String get(int index){
		if(index <= 0)
			return null;
		Link current = head.getNext();
		for(int i = 1; i < index; i++){
			if(current.getNext() == null)
				return null;
			
			current = current.getNext();
		}
		return current.getData();
	}
	
	public boolean remove(int index){
		if(index < 1 || index > size())
			return false;
		
		Link current = head;
		for(int i = 1; i < index; i++){
			if(current.getNext() == null)
				return false;
			
			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		listCount --;
		return true;
	}
	
	public int size(){
		return listCount;
	}
}
