
import java.util.Random;

public class ArrayStringBag implements BoundedStringBag {

	private String container[];
	private String name;
	public int lastIndex;
	private int size;

	public ArrayStringBag(int newSize, String name) {
		super();
		this.size = newSize;
		this.container = new String[size];
		this.name = name;
		this.lastIndex = -1;
	}

	@Override
	public String remove() throws EmptyBagException {
		Random rand = new Random();
		int randomInt=0;
		if(!isEmpty()){
			if(lastIndex != 0)
				randomInt = rand.nextInt(lastIndex+1);
			String theReturn = container[randomInt];
			this.lastIndex --;
				for(int i = randomInt; i < lastIndex+1; i++){
					container[i] = container[i+1];
				}
			container[lastIndex+1] = null;
			return theReturn;
		}
		else
			throw new EmptyBagException("This bag is empty, there is nothing to remove");
	}

	@Override
	public boolean isEmpty() {
		if(lastIndex < 0)
			return true;
		else
			return false;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void insert(String newElement) throws FullBagException {
			if(this.lastIndex == this.size - 1)
				throw new FullBagException("The bag is full!! The last item could not be added!");
			else{
				lastIndex ++;
				this.container[lastIndex] = newElement;
			}
	}

	@Override
	public String toString() {
		System.out.println("======================");
		System.out.println("The " + this.name + " bag contains:");
		System.out.println("======================");
		for(int i = 0; i < lastIndex+1; i++)
			System.out.println(this.container[i]);
		System.out.println("======================");
		return null;
	}
	
	

}
