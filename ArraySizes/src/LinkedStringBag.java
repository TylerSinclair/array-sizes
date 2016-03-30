import java.util.Random;


public class LinkedStringBag implements UnboundedStringBag {
	
	LinkList theList;
	private String name;
	
	public LinkedStringBag(String Name){
		this.name = Name;
		this.theList = new LinkList();
	}

	@Override
	public String remove() throws EmptyBagException {
		
		Random rand = new Random();
		int randomInt=1;
		if(!isEmpty()){
			if(theList.size() != 0)
				randomInt = 1 + rand.nextInt(theList.size());
			String theReturn = theList.get(randomInt);
			theList.remove(randomInt);
			return theReturn;
		}
		else
			throw new EmptyBagException("This bag is empty, there is nothing to remove");
	}

	@Override
	public boolean isEmpty() {
		if(theList.size() == 0)
			return true;
		else
			return false;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void insert(String newElement) {
		theList.add(newElement);
	}

	@Override
	public String toString() {
		System.out.println("======================");
		System.out.println("The " + this.name + " bag contains:");
		System.out.println("======================");
		for(int i = 1; i < theList.size()+1; i++)
			System.out.println(theList.get(i));
		System.out.println("======================");
		return null;
	}
	
}
