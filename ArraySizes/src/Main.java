import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		int choice = 0;
		String bagName;
		int bagSize = 0;
		String bagItem;
		Scanner in = new Scanner(System.in);
		
		do {
			System.out.println("Please choose a bag (1 - bounded, 2 - unbounded)");
			try {
				choice = in.nextInt();
				choiceChk(choice);
			} catch (Exception e) {
				System.out.println("please enter only numbers between 1-2!!");
				choice = 0;
				in.next();
			}
		} while (choice == 0);
		
		System.out.println("Please enter a name for the bag");
		bagName = in.next();
		
		if(choice == 1){
			do {
				System.out.println("Please enter the size of the bag");
				try {
					bagSize = in.nextInt();
					sizeChk(bagSize);
				} catch (Exception e) {
					System.out.println("please enter only positive numbers");
					bagSize = 0;
					in.next();
				}
			} while (bagSize == 0);
			
			ArrayStringBag ABag = new ArrayStringBag(bagSize, bagName);
			System.out.println("Enter the desired strings:");
			do{
				bagItem = in.next();
				if(!bagItem.equals("xxx")){
					try {
						ABag.insert(bagItem);
					} catch (FullBagException e) {
						System.out.println(e.getMessage());
						bagItem = "xxx";
					}
				}
			}while(!bagItem.equals("xxx"));
			ABag.toString();
			try {
				System.out.println("Random pick and remove: " + ABag.remove());
			} catch (EmptyBagException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
			ABag.toString();
			
		}else{
			LinkedStringBag LBag = new LinkedStringBag(bagName);
			System.out.println("Enter the desired strings:");
			do{
				bagItem = in.next();
				if(!bagItem.equals("xxx")){
					LBag.insert(bagItem);
				}
			}while(!bagItem.equals("xxx"));
			LBag.toString();
			try {
				System.out.println("Random pick and remove: " + LBag.remove());
			} catch (EmptyBagException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
			LBag.toString();
			
		}
		in.close();
	}

	public static void choiceChk(int x){
		if(x<1 || x>2)
			throw new IllegalArgumentException();
	}
	public static void sizeChk(int x){
		if(x <= 0)
			throw new IllegalArgumentException();
	}
}
