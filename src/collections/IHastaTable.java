package collections;

public interface IHastaTable<T> {
	void createTable();
	boolean isEmpty();
	
	void insert(T elem);
	void search(T elem);

}
