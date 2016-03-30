
public interface BoundedStringBag extends StringBag {
	public void insert(String newElement) throws FullBagException;
}
