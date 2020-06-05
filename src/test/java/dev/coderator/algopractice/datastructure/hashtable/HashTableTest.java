package dev.coderator.algopractice.datastructure.hashtable;

import dev.coderator.algopractice.datastructure.hashtable.HashTable;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

	@Test
	void put() {
		assertEquals("[(10, Java), (20, Python), (1, C), (5, Ruby), (15, Go), (9, C++)]",
				hashTable().entryList().toString());
	}

	@Test
	void get() {
		HashTable hashTable = hashTable();
		assertEquals("Ruby", hashTable.get(5).get());
		assertEquals("C++", hashTable.get(9).get());
		assertEquals("Python", hashTable.get(20).get());
		assertEquals(Optional.empty(), hashTable.get(25));
	}

	@Test
	void remove() {
		HashTable hashTable = hashTable();
		hashTable.remove(9);
		assertEquals("[(10, Java), (20, Python), (1, C), (5, Ruby), (15, Go)]", hashTable.entryList().toString());

		hashTable.remove(15);
		assertEquals("[(10, Java), (20, Python), (1, C), (5, Ruby)]", hashTable.entryList().toString());

		hashTable.remove(5);
		assertEquals("[(10, Java), (20, Python), (1, C)]", hashTable.entryList().toString());

		assertThrows(IllegalStateException.class, () -> hashTable.remove(8));
		assertThrows(IllegalStateException.class, () -> hashTable.remove(35));
	}

	private HashTable hashTable() {
		HashTable hashTable = new HashTable(10);
		hashTable.put(10, "Java");
		hashTable.put(1, "C");
		hashTable.put(9, "C++");
		hashTable.put(20, "Python");
		hashTable.put(5, "Ruby");
		hashTable.put(15, "C#");
		hashTable.put(15, "Go");
		return hashTable;
	}
}