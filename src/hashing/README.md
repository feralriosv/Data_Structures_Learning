Recent Structural Improvements:
Class MyHashTable<K, V>
•	Now uses two generic types: K for keys and V for values.
•	insert(K key, V value) and find(K key) methods have been implemented (require review and testing).
•	The previous attribute List<HashCell<T>> has been removed.
•	Replaced with an array of HashEntry<K, V> to allow direct access and support chaining via linked lists.

Class HashCell → renamed to HashEntry
•	Complete redesign under the new name HashEntry.
•	Currently contains only the basic structure.
•	Includes a HashEntry<K, V> next attribute to enable simple singly linked list chaining for collision resolution.

TO-DO
•	Implement the first functional prototype of the MyHashTable (Minimum Viable Product) to test insertions, lookups, and basic collision handling.