package dev.coderator.algopractice.datastructure.hashtable;

import java.util.*;
import java.util.LinkedList;

public class HashTable {

	private class Entry {
		private int key;
		private String value;

		public Entry(int key, String value) {
			this.key = key;
			this.value = value;
		}

		public String toString() {
			return "(" + key + ", " + value + ")";
		}
	}

	private LinkedList<Entry>[] buckets;

	public HashTable(int size) {
		buckets = new LinkedList[size];
	}

	public void put(int key, String value) {
		var bucket = bucket(key);
		entry(key).ifPresentOrElse(entry -> entry.value = value, () -> bucket.addLast(new Entry(key, value)));
	}

	public Optional<String> get(int key) {
		return entry(key).map(entry -> entry.value);
	}

	public void remove(int key) {
		entry(key).orElseThrow(() -> new IllegalStateException("entry not found"));
		bucket(key).removeLast();
	}

	public List<Entry> entryList() {
		var list = new ArrayList<Entry>();
		for (var linkedList : buckets)
			if (Objects.nonNull(linkedList))
				linkedList.forEach(entry -> list.add(entry));

		return list;
	}

	private int hash(int key) {
		return key % buckets.length;
	}

	private LinkedList<Entry> bucket(int key) {
		if (Objects.isNull(buckets[hash(key)]))
			buckets[hash(key)] = new LinkedList<>();
		return buckets[hash(key)];
	}

	private Optional<Entry> entry(int key) {
		var bucket = bucket(key);
		if (Objects.isNull(bucket))
			return Optional.empty();

		for (var entry : bucket)
			if (entry.key == key)
				return Optional.ofNullable(entry);

		return Optional.empty();
	}
}
