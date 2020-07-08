package com.aking.excel.utils;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class CollectionUtil {
    public CollectionUtil() {
    }

    public static <T> T getFirstMatched(Set<T> referSet, List<T> curList) {
        if (!isEmpty(referSet) && !isEmpty(curList)) {
            Iterator var2 = curList.iterator();

            Object t;
            do {
                if (!var2.hasNext()) {
                    return null;
                }

                t = var2.next();
            } while(!referSet.contains(t));

            return (T) t;
        } else {
            return null;
        }
    }

    public static <T> T getFirstMatched(Set<T> referSet, Set<T> curSet) {
        if (!isEmpty(referSet) && !isEmpty(curSet)) {
            Iterator var2 = curSet.iterator();

            Object t;
            do {
                if (!var2.hasNext()) {
                    return null;
                }

                t = var2.next();
            } while(!referSet.contains(t));

            return (T) t;
        } else {
            return null;
        }
    }

    public static <K, V> List<K> mapKeyToList(Map<K, V> map) {
        if (isEmpty(map)) {
            return Collections.emptyList();
        } else {
            List<K> list = new ArrayList();
            list.addAll(map.keySet());
            return list;
        }
    }

    public static <K, V> List<V> mapValueToList(Map<K, V> map) {
        if (isEmpty(map)) {
            return Collections.emptyList();
        } else {
            List<V> list = new ArrayList();
            list.addAll(map.values());
            return list;
        }
    }

    public static <K, V> Set<V> mapValueToSet(Map<K, V> map) {
        if (isEmpty(map)) {
            return Collections.emptySet();
        } else {
            Set<V> set = new HashSet();
            set.addAll(map.values());
            return set;
        }
    }

    public static <K, V> Set<K> mapKeyToSet(Map<K, V> map) {
        return isEmpty(map) ? Collections.emptySet() : map.keySet();
    }

    public static <K, V> Map<K, V> newHashMap() {
        return new HashMap();
    }

    public static <T> Set<T> newHashSet() {
        return new HashSet();
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList();
    }

    public static <T> boolean largeOrEqualSize(List<T> list, int size) {
        return null != list && 0 <= size ? size <= list.size() : false;
    }

    public static <T> boolean largeOrEqualSize(T[] array, int size) {
        return null != array && 0 <= size ? size <= array.length : false;
    }

    public static <T> boolean largeOrEqualSize(Set<T> set, int size) {
        return null != set && 0 <= size ? size <= set.size() : false;
    }

    public static <K, V> boolean largeOrEqualSize(Map<K, V> map, int size) {
        return null != map && 0 <= size ? size <= map.size() : false;
    }

    public static <T> boolean largeSize(List<T> list, int size) {
        return null != list && 0 <= size ? size < list.size() : false;
    }

    public static <T> boolean largeSize(T[] array, int size) {
        return null != array && 0 <= size ? size < array.length : false;
    }

    public static <T> boolean largeSize(Set<T> set, int size) {
        return null != set && 0 <= size ? size < set.size() : false;
    }

    public static <K, V> boolean largeSize(Map<K, V> map, int size) {
        return null != map && 0 <= size ? size < map.size() : false;
    }

    public static <T> boolean equalsSize(List<T> list, int size) {
        return null != list && 0 <= size ? size == list.size() : false;
    }

    public static <T> boolean equalsSize(T[] array, int size) {
        return null != array && 0 <= size ? size == array.length : false;
    }

    public static <T> boolean equalsSize(Set<T> set, int size) {
        return null != set && 0 <= size ? size == set.size() : false;
    }

    public static <K, V> boolean equalsSize(Map<K, V> map, int size) {
        return null != map && 0 <= size ? size == map.size() : false;
    }

    public static <T> boolean isEmpty(T[] array) {
        return null == array || 0 >= array.length;
    }

    public static boolean isEmpty(Collection<?> collection) {
        return null == collection || 0 >= collection.size();
    }

    public static boolean isEmpty(List<?> list) {
        return null == list || 0 >= list.size();
    }

    public static boolean isEmpty(Set<?> set) {
        return null == set || 0 >= set.size();
    }

    public static <T extends Collection<?>> boolean isNotEmpty(T collection) {
        return !isEmpty(collection);
    }

    public static <K, V> boolean isEmpty(Map<K, V> map) {
        return null == map || 0 >= map.size();
    }

    public static <T> List<T> arrayToList(T[] array) throws Exception {
        List<T> list = new ArrayList();
        if (null != array && 0 < array.length) {
            Object[] var2 = array;
            int var3 = array.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                T t = (T) var2[var4];
                list.add(t);
            }

            return list;
        } else {
            return list;
        }
    }

    public static <T> Set<T> arrayToSet(T[] array) {
        Set<T> set = new HashSet();
        if (null != array && 0 < array.length) {
            Object[] var2 = array;
            int var3 = array.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                T t = (T) var2[var4];
                set.add(t);
            }

            return set;
        } else {
            return set;
        }
    }

    public static <T> List<T> setToList(Set<T> set) {
        if (null != set && 0 < set.size()) {
            List<T> list = new ArrayList();
            list.addAll(set);
            return list;
        } else {
            return Collections.emptyList();
        }
    }

    public static <T> List<T> toList(Collection<T> set) {
        if (null != set && 0 < set.size()) {
            List<T> list = new ArrayList();
            list.addAll(set);
            return list;
        } else {
            return Collections.emptyList();
        }
    }

    public static <T> Set<T> listToSet(List<T> list) {
        if (null != list && 0 < list.size()) {
            Set<T> set = new HashSet();
            set.addAll(list);
            return set;
        } else {
            return Collections.emptySet();
        }
    }

    public static <T> List<T> collectionToList(Collection<T> collection) throws Exception {
        List<T> list = new ArrayList();
        if (null != collection && 0 < collection.size()) {
            Iterator var2 = collection.iterator();

            while(var2.hasNext()) {
                T t = (T) var2.next();
                list.add(t);
            }

            return list;
        } else {
            return list;
        }
    }

    public static <T> void addAllTrimNull(List<T> orginList, List<T> targetList) {
        if (null != orginList && 0 < orginList.size() && null != targetList) {
            Iterator var2 = orginList.iterator();

            while(var2.hasNext()) {
                T t = (T) var2.next();
                if (null != t) {
                    targetList.add(t);
                }
            }

        }
    }

    public static <T> void copyListNoNull(List<T> orginList, List<T> targetList) {
        if (null != orginList && 0 < orginList.size() && null != targetList) {
            Iterator var2 = orginList.iterator();

            while(var2.hasNext()) {
                T t = (T) var2.next();
                if (null != t) {
                    targetList.add(t);
                }
            }

        }
    }

    public static <T> List<T> getNoNullCopy(List<T> orginList) {
        if (null != orginList && 0 < orginList.size()) {
            List<T> targetList = new ArrayList();
            Iterator var2 = orginList.iterator();

            while(var2.hasNext()) {
                T t = (T) var2.next();
                if (null != t) {
                    targetList.add(t);
                }
            }

            return targetList;
        } else {
            return Collections.emptyList();
        }
    }

    public static <T> List<T> combine(List<T> firstList, List<T> secondList) {
        List<T> combinedList = new ArrayList();
        combinedList.addAll(firstList);
        combinedList.addAll(secondList);
        return combinedList;
    }

    public static <T> T first(Collection<T> collection) {
        return isEmpty(collection) ? null : collection.iterator().next();
    }
}
