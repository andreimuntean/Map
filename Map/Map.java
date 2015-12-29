import java.util.ArrayList;

public class Map<K, V>
{
    private ArrayList<ArrayList<Pair<K, V>>> buckets = new ArrayList<>();

    public Map()
    {
        // Initializes the buckets.
        for (int index = 0; index < 16; ++index)
        {
            buckets.add(index, new ArrayList<>());
        }
    }

    public Map(int bucketCount)
    {
        // Initializes the buckets.
        for (int index = 0; index < bucketCount; ++index)
        {
            buckets.add(index, new ArrayList<>());
        }
    }

    // Gets the value indexed by the specified key.
    public V get(K key)
    {
        int index = key.hashCode() % buckets.size();

        for (Pair<K, V> pair : buckets.get(index))
        {
            // Looks for the pair with the specified key.
            if (pair.getKey().equals(key))
            {
                // Returns its value.
                return pair.getValue();
            }
        }

        // No value is indexed by this key.
        return null;
    }

    // Associates a value with the specified key.
    public void set(K key, V value)
    {
        int index = key.hashCode() % buckets.size();
        ArrayList<Pair<K, V>> bucket = buckets.get(index);

        for (int pairIndex = 0; pairIndex < bucket.size(); ++pairIndex)
        {
            // Gets this pair.
            Pair<K, V> pair = bucket.get(pairIndex);

            if (pair.getKey().equals(key))
            {
                // A pair with this key already exists. Overwrites it.
                bucket.set(pairIndex, new Pair<K, V>(key, value));

                return;
            }
        }

        bucket.add(new Pair<>(key, value));
    }

    // Removes the value indexed by the specified key.
    // Returns true if a value was removed.
    public boolean remove(Object key)
    {
        int index = key.hashCode() % buckets.size();
        ArrayList<Pair<K, V>> bucket = buckets.get(index);

        return bucket.removeIf(pair -> pair.getKey().equals(key));
    }
}