package collections;

public class HashTable<K,V> implements IHashTable<K,V> {
	//Prime number used to the hash table size and his function
	public static final int INITIAL_SIZE = 100003;
	private int length;
	private int size;
	private long amountOfElements;
	private HashEntry[] entries;
//	private ILinkedList<T>[] entries;

	public HashTable() {
		size = INITIAL_SIZE;
	}

	@Override
	public void createTable() {
		
		    
		
		int[] arr = new int[2];
		entries = new HashEntry [size];
		
	}

	@Override
	public boolean isEmpty() {
		
		return entries[0] == null;
	}

	/**
	 * Determines the number of items in the table.
	 */
	@Override
	public long tableLength() {
		return length;
	}

	@Override
	public void tableInsert(K key, V newItem) {
		entries[hashFunction(key)] = new HashEntry<K,V>(key, newItem);
		
	}
	public int hashFunction(K key) {
		return (Integer)key%INITIAL_SIZE;
	}

	@Override
	public void tableDelete(K searchKey) {
		int index = hashFunction(searchKey);
		if (entries[index].getKey() == searchKey) {
			entries[index] = null;
		}
		
	}

	@Override
	public K tableRetrieve(K searchKey) {
		// TODO Auto-generated method stub
		//castear el return con (K)
		return null;
	}

	@Override
	public long size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
