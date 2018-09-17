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
		length = 0;
		createTable();
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
		length++;
		
	}
	public int hashFunction(K key) {
		return (Integer)key%INITIAL_SIZE;
	}

	@Override
	public void tableDelete(K searchKey) {
		int index = hashFunction(searchKey);
		if (entries[index].getKey() == searchKey) {
			entries[index] = null;
			length--;
		}
		
	}

	@Override
	public HashEntry<K, V> tableRetrieve(K searchKey) {
		int index = hashFunction(searchKey);
		HashEntry valueFound = entries[index];
		HashEntry ret = null;
		if (valueFound.getKey() == searchKey) {
			ret = entries[index];
		}		
		return ret;
	}

	/**
	 * Return the size of the hash table
	 */
	@Override
	public long size() {		
		return size;
	}

}
