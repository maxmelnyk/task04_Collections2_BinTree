package com.melnyk.bintree;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyBinTree<K extends Comparable, V> {

  private Node<K, V> root;

  public void showBinTree() {
    System.out.println(root);
  }

  private Node<K, V> putRecursive(Node<K, V> current, K key, V value) {
    if (current == null) {
      return new Node<>(key, value);
    }
    if (key.hashCode() < current.key.hashCode()) {
      current.left = putRecursive(current.left, key, value);
    } else if (key.hashCode() > current.key.hashCode()) {
      current.right = putRecursive(current.right, key, value);
    } else {
      // value already exists
      return current;
    }
    return current;
  }

  public void put(K key, V value) {
    root = putRecursive(root, key, value);
  }

  private boolean containsKeyRecursive(Node<K, V> current, K key) {
    if (current == null) {
      return false;
    }
    if (key.equals(current.key)) {
      return true;
    }
    return key.hashCode() < current.key.hashCode()
        ? containsKeyRecursive(current.left, key)
        : containsKeyRecursive(current.right, key);
  }

  public boolean containsKey(K key) {
    return containsKeyRecursive(root, key);
  }

  private V getRecursive(Node<K, V> node, K key) {
    if (node == null) {
      return null;
    }
    if (key.equals(node.key)) {
      return node.getValue();
    }
    return key.hashCode() < node.key.hashCode()
        ? getRecursive(node.left, key)
        : getRecursive(node.right, key);
  }

  public V get(K key) {
    return getRecursive(root, key);
  }

  private K findSmallestValue(Node<K, V> root) {
    return root.left == null ? root.key : findSmallestValue(root.left);
  }

  private Node<K, V> removeRecursive(Node<K, V> current, K key) {
    if (current == null) {
      return null;
    }

    if (key.equals(current.key)) {
      if (current.left == null && current.right == null) {
        return null;
      }
      if (current.right == null) {
        return current.left;
      }

      if (current.left == null) {
        return current.right;
      }
      K smallestValue = findSmallestValue(current.right);
      current.key = smallestValue;
      current.right = removeRecursive(current.right, smallestValue);
      return current;
    }
    if (key.hashCode() < current.key.hashCode()) {
      current.left = removeRecursive(current.left, key);
      return current;
    }
    current.right = removeRecursive(current.right, key);
    return current;
  }

  public void remove(K key) {
    root = removeRecursive(root, key);
  }

  public boolean isEmpty() {
    return root == null;
  }

  public int size() {
    return 0;
  }

  public boolean containsValue(Object value) {
    return false;
  }

  public void putAll(Map<? extends K, ? extends V> m) {

  }

  public void clear() {

  }

  public Set<K> keySet() {
    return null;
  }

  public Collection<V> values() {
    return null;
  }
}
