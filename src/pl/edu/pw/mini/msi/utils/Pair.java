package pl.edu.pw.mini.msi.utils;

public class Pair<K,V> {
	public K key;
	public V value;
	
	public Pair() {}
	public Pair(K k, V v)
	{
		this.key = k;
		this.value = v;
	}
}
