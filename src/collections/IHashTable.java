package collections;

public interface IHashTable<K,V> {
	void createTable();
	boolean isEmpty();
	long tableLength();
	void tableInsert(K key,V newItem);
	void tableDelete(K searchKey);
	K tableRetrieve(K searchKey);
	long size();
}
