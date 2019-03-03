package com.melnyk.bintree;

import java.util.Map;
import java.util.Objects;

public class Node<K, V> implements Map.Entry<K, V> {

  K key;
  private V value;
  Node<K, V> left;
  Node<K, V> right;

  Node(K key, V value) {
    this.key = key;
    this.value = value;
    right = null;
    left = null;
  }

  @Override
  public K getKey() {
    return key;
  }

  @Override
  public V getValue() {
    return value;
  }

  @Override
  public V setValue(V value) {
    return this.value = value;
  }

  @Override
  public String toString() {
    return "Node{" +
        "key=" + key +
        ", value=" + value +
        ", left=" + left +
        ", right=" + right +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Node)) {
      return false;
    }
    Node<?, ?> node = (Node<?, ?>) o;
    return Objects.equals(key, node.key) &&
        Objects.equals(value, node.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, value);
  }
}
