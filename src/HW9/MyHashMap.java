package HW9;

public class MyHashMap<K, V> {
    private static int DEFAULT_CAPACITY = 8;
    private Entry[] entries = new Entry[DEFAULT_CAPACITY];
    private int size;
    private int getBucketIndex(K key){
        return Math.abs(key.hashCode() % entries.length);
    }
    public void clear() {
        entries = new Entry[DEFAULT_CAPACITY];
        size = 0;
    }
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        Entry<K, V> entry = new Entry<>(key, value);
        if (entries[index] == null) {
            entries[index] = entry;
        } else {
            Entry<K, V> currentEntry = entries[index];
            if (currentEntry.equals(entry)) return;
            while (currentEntry.next != null) {
                currentEntry = currentEntry.next;
            }
            currentEntry.next = entry;
        }
        size++;
    }
    public V get(K key) {
        for (int i = 0; i < entries.length; i++) {
            Entry<K, V> currentEntry = entries[i];
            if (currentEntry == null) continue;
            if (currentEntry.equals(new Entry<>(key, null))) {
                return currentEntry.value;
            }
            while (currentEntry.next != null) {
                if (currentEntry.next.equals(new Entry<>(key, null))) return currentEntry.next.value;
                currentEntry = currentEntry.next;
            }
        }
        return null;
    }
    public void remove(K key) {
        for (int i = 0; i < entries.length; i++) {
            Entry<K, V> currentEntry = entries[i];
            if (currentEntry == null) continue;
            if (currentEntry.equals(new Entry<>(key, null))) {
                entries[i] = currentEntry.next;
                size--;
                break;
            }
            while (currentEntry.next != null) {
                if (currentEntry.next.equals(new Entry<>(key, null))) {
                    if (currentEntry.next.next != null) {
                        currentEntry.next = currentEntry.next.next;
                    } else {
                        currentEntry.next = null;
                    }
                    size--;
                    break;
                }
                currentEntry = currentEntry.next;
            }
        }
    }
    public int size() {
        return this.size;
    }
    private static class Entry<K, V> {
        V value;
        K key;
        MyHashMap.Entry<K, V> next;
        public Entry(K key, V value) {
            this.value = value;
            this.key = key;
        }
        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (o != null && this.getClass() == o.getClass()){
                return this.key == ((Entry<?, ?>) o).key;
            }
            return false;
        }
    }


}
