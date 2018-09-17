package collections;

public interface IHastaTable<T> {
	void createTable();
	boolean isEmpty();
	long tableLength();
	void talbeInsert(T newItem);
	void tableDelete(T searchKey);
	T tableRetrieve(T searchKey);
	long size();
}
