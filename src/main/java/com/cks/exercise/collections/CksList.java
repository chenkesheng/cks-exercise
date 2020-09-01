package com.cks.exercise.collections;

/**
 * @Author: cks
 * @Date: Created by 下午2:36 2020/8/21
 * @Package: com.cks.exercise.collections
 * @Description:
 */
public class CksList<E> {

    private int size;

    transient Object[] elementData;

    private static final int DEFAULT_CAPACITY = 10;//默认容量

    public CksList() {
        elementData = new Object[DEFAULT_CAPACITY];//开辟默认大小数组

    }

    public CksList(int capacity) {
        if (capacity < 0) {
            throw new OutOfMemoryError();
        } else if (capacity == 0) {
            elementData = new Object[DEFAULT_CAPACITY];//开辟默认大小数组
        } else {
            elementData = new Object[capacity];//自定义数组大小
        }

    }


    //新增
    public void add(E e) {
        //扩容
        if (size == elementData.length) {
            Object[] newArray = new Object[(int) (elementData.length + elementData.length * 0.5)];
            //增加为原来的1.5倍
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
        }
        elementData[size] = e;
        size = size + 1;
    }

    public E get(int index) {
        //get方法
        checkRange(index);
        return elementData(index);
    }

    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) elementData[index];
    }

    public void checkRange(int index) {
        if (index < 0 || index > size - 1) {
            //下标不合法
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    public void add(int index, E e) {
        checkRange(index);
        final int s;
        Object[] elementData;
        if ((s = size) == (elementData = this.elementData).length) {
            Object[] newArray = new Object[(int) (elementData.length + elementData.length * 0.5)];
            //增加为原来的1.5倍
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
        }
        elementData[size] = e;
        System.arraycopy(elementData, index,
                elementData, index + 1,
                s - index);
        elementData[index] = e;
        size = s + 1;
    }

    public void set(int index, E e) {
        checkRange(index);
        elementData[index] = e;
    }

    public void remove(E element) {
        //通过元素删除元素
        for (int i = 0; i < size; i++) {
            if (element.equals(elementData[i])) {
                remove(i);
            }
        }
    }

    public void remove(int index) {
        //通过下标删除
        checkRange(index);
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
