package collections;

public class HashTable<T> implements IHastaTable<T> {
	//Prime number used to the hash table size and his function
	public static final int INITIAL_SIZE = 100003;
	private int size;
	private long amountOfElements;
	private Object[] entries;
//	private ILinkedList<T>[] entries;

	public HashTable() {
		size = INITIAL_SIZE;
	}

	@Override
	public void createTable() {
		
		    
		
		int[] arr = new int[2];
		entries = new Object [size];
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long tableLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void talbeInsert(T newItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tableDelete(T searchKey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T tableRetrieve(T searchKey) {
		// TODO Auto-generated method stub
		//castear el return con (T)
		return null;
	}

	@Override
	public long size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
