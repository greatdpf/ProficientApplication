[toc]



# ProficientApplication

探究Java集合的魅力



### ArrayList

继承：AbstractList< E > 抽象类

实现：List< E > 接口，Cloneable 接口，Serializable 接口

#### ArrayList 1.7 源码分析

属性：

```java
// ArrayList 底层数组且类型为 Object
private transient Object[] elementData;
// 数组中的有效数据
private int size;
```



构造器

```java
// 空构造器
public ArrayList() {
    // 调用有参构造器
    this(10);
}
// 有参构造器
public ArrayList(int initialCapacity) {
    super();
    // 健壮性代码，略过
    if (initialCapacity < 0) 
        throw new IllegalArgumentException("Illegal Capacity: "+
                                           initialCapacity);
    // 将数组初始化为 10；
	this.elementData = new Object[initialCapacity];
}
```



方法：

```java
// 添加元素
public boolean add(E e) {
    // 只有扩容时，才需要这个方法，当数组满了，即 size = 10
    ensureCapacityInternal(size + 1);  // Increments modCount!!
    // 向数组中添加元素 e ，并且 size + 1
    elementData[size++] = e;
    // 返回 true 
    return true;
}
private void ensureCapacityInternal(int minCapacity) {
    modCount++;
	// overflow-conscious code
    // minCapacity = 11 length = 10，11 - 10 > 0，就扩容
    if (minCapacity - elementData.length > 0)
        grow(minCapacity);
}

private void grow(int minCapacity) {
    // minCapacity = 11
    // oldCapacity = 10
    int oldCapacity = elementData.length;
    // new Capacity = 10 + 10 / 2 扩容 1.5倍
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    // 
    if (newCapacity - minCapacity < 0)
        newCapacity = minCapacity;
    if (newCapacity - MAX_ARRAY_SIZE > 0)
        newCapacity = hugeCapacity(minCapacity);
    // 将老数组的元素，拷贝到新数组中，然后让 elementData 指向新数组
    elementData = Arrays.copyOf(elementData, newCapacity);
}
```





#### ArrayList 1.8 源码分析

属性：

```java
private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
// 默认长度
private static final int DEFAULT_CAPACITY = 10;
// ArrayList 底层数组且类型为 Object
private transient Object[] elementData;
// 数组中的有效数据
private int size;
```



构造器：

```java
// 空构造器
public ArrayList() {
    // 赋值为 空 ，但在 1.7 中直接赋值为一个大小为10的数组
    this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
}

public ArrayList(int initialCapacity) {
    if (initialCapacity > 0) {
        this.elementData = new Object[initialCapacity];
    } else if (initialCapacity == 0) {
        this.elementData = EMPTY_ELEMENTDATA;
    } else {
        throw new IllegalArgumentException("Illegal Capacity: "+
                                           initialCapacity);
    }
}
// 添加元素
public boolean add(E e) {
    // 数组初始化 当前 size = 0
    ensureCapacityInternal(size + 1);  // Increments modCount!!
    // 向数组中添加元素 e ，并且 size + 1
    elementData[size++] = e;
    // 返回 true 
    return true;
}
private void ensureCapacityInternal(int minCapacity) {
    // elementData = {} minCapacity = 1
    ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
}
private static int calculateCapacity(Object[] elementData, int minCapacity) {
    // elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA{} minCapacity = 1
    // 数组确定长度
    if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
        // 当前DEFAULT_CAPACITY = 10, minCapacity = 1
        return Math.max(DEFAULT_CAPACITY, minCapacity);
    }
    // 如果原来数组已经有值，就返回 size + 1
    return minCapacity;
}

private void ensureExplicitCapacity(int minCapacity) {
    modCount++;

    // 如果大于当前数组长度，就扩容 minCapacity = 10 elementData.length = 0
    if (minCapacity - elementData.length > 0)
        grow(minCapacity);
}
private void grow(int minCapacity) {
    // minCapacity = 10;
    // oldCapacity = 0;
    int oldCapacity = elementData.length;
    // newCapacity = 0 + 0/2 
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    // 0 - 10 < 0
    if (newCapacity - minCapacity < 0)
        // newCapacity = 10;
        newCapacity = minCapacity;
    if (newCapacity - MAX_ARRAY_SIZE > 0)
        newCapacity = hugeCapacity(minCapacity);
    // 复制 elementData 数组，并且长度为 10；然后赋给 elementData
    elementData = Arrays.copyOf(elementData, newCapacity);
}
```





#### 知识点

1. ArrayList 继承 AbstractList  ，而 AbstractList 已经实现了 List 接口，但是 ArrayList 依然实现了 List 接口，这是一个失误。
2. ArrayList 底层是一个 Object 类型的数组 。
3. ArrayList 1.7 源码：ArrayList 在初始化时，就指定数组长度为 10，扩容的大小为原来数组的1.5倍
4. ArrayList 1.8 源码：ArrayList 在初始化时，底层数组为空，只有在调用add方法以后，才会赋值为新数组，长度为10。如果不调用 add 方法，则不会创建数组，节省了内存。