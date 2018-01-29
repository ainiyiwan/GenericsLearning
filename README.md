# GenericsLearning
泛型学习
### 1. 夯实JAVA基本之一 —— 泛型详解(1):基本使用
[夯实JAVA基本之一 —— 泛型详解(1):基本使用](http://blog.csdn.net/harvic880925/article/details/49872903)
#### 1.1
任意一个大写字母都可以。他们的意义是完全相同的，但为了提高可读性，大家还是用有意义的字母比较好，一般来讲，在不同的情境下使用的字母意义如下：

 E — Element，常用在java Collection里，如：List<E>,Iterator<E>,Set<E>
 
 K,V — Key，Value，代表Map的键值对
 
 N — Number，数字
 
 T — Type，类型，如String，Integer等等

#### 1.2

函数返回值是List<T>类型。至于传入参数Class<T> object的意义，我们下面会讲。这里也就是想通过这个例子来告诉大家，泛型变量其实跟String,Integer，Double等等的类的使用上没有任何区别，T只是一个符号，可以代表String,Integer，Double……这些类的符号，在泛型函数使用时，直接把T看到String,Integer，Double……中的任一个来写代码就可以了。唯一不同的是，要在函数定义的中在返回值前加上<T>标识泛型；

#### 1.3
注意到，我们用的Class<T> object来传递类的class对象，即我们上面提到的SuccessModel.class。
这是因为Class<T>也是一泛型，它是传来用来装载类的class对象的，它的定义如下：
```java
public final class Class<T> implements Serializable {  
    …………  
}
```
### 2. 夯实JAVA基本之一——泛型详解(2)：高级进阶
[夯实JAVA基本之一——泛型详解(2)：高级进阶](http://blog.csdn.net/harvic880925/article/details/49883589)

#### 2.1
首先，我们要知道一点，任何的泛型变量（比如这里的T）都是派生自Object，所以我们在填充泛型变量时，只能使用派生自Object的类，比如String,Integer,Double，等而不能使用原始的变量类型，比如int,double,float等。

#### 2.2
```java
<T extends BoundingType>  
```
此定义表示T应该是BoundingType的子类型（subtype）。T和BoundingType可以是类，也可以是接口。另外注意的是，此处的”extends“表示的子类型，不等同于继承。
一定要非常注意的是，这里的extends不是类继承里的那个extends！两个根本没有任何关联。在这里extends后的BoundingType可以是类，也可以是接口，意思是说，T是在BoundingType基础上创建的，具有BoundingType的功能。目测是JAVA的开发人员不想再引入一个关键字，所以用已有的extends来代替而已。
#### 2.3
而无边界通配符？则只能用于填充泛型变量T，表示通配任何类型！！！！再重复一遍：？只能用于填充泛型变量T。它是用来填充T的！！！！只是填充方式的一种！！！
#### 2.4
也就是说，编译器，只要能确定通配符类型，就会允许，如果无法确定通配符的类型，就会报错。
#### 2.5
◆ 如果你想从一个数据类型里获取数据，使用 ? extends 通配符（能取不能存）

◆ 如果你想把对象写入一个数据结构里，使用 ? super 通配符（能存不能取）

◆ 如果你既想存，又想取，那就别用通配符。

### 3. 夯实JAVA基本之二 —— 反射（1）：基本类周边信息获取
[夯实JAVA基本之二 —— 反射（1）：基本类周边信息获取](http://blog.csdn.net/harvic880925/article/details/50072739)
#### 3.1
这里要先声明一个观点：Class类，不同于定义类的class标识，Class类是一个泛型。类对象是由Class对象来表示，而接口对象同样也是用Class对象来表示！
所以同样是Class对象，它可能表示的类对象，也可能表示的是接口对象！

#### 3.2
**getInterfaces()将获取指定类直接继承的接口列表！注意一点：直接继承！！！如果不是直接继承，那将是获取不到的。**

#### 3.3
最后，我们总结一下，Class.forName(String className)不仅会将类加载进来，而且会对其进行初始化，而ClassLoader.loadClass(String ClassName)则只是将类加载进来，而没有对类进行初始化。一般来讲，他们两个是通用的，但如果你加载类依赖初始化值的话，那ClassLoader.loadClass(String ClassName)将不再适用。

### 4. 夯实JAVA基本之二 —— 反射（2）：泛型相关周边信息获取
[夯实JAVA基本之二 —— 反射（2）：泛型相关周边信息获取](http://blog.csdn.net/harvic880925/article/details/50085595)
#### 4.1
getActualTypeArguments()：用来返回当前泛型表达式中，用来填充泛型变量的真正值的列表。像我们这里得到的Point，用来填充泛型变量T的是Integer类型，所以这里返回的Integer类型所对应的Class对象。（有关这一段，下面会补充，这里先看getRawType）
getRawType()：我们从我们上面的代码中，也可以看到，它返回的值是com.harvic.blog_reflect_2.Point，所以它的意义就是声明当前泛型表达式的类或者接口的Class对象。比如，我们这里的type对应的是Point，而声明Point这个泛型的当然是Point类型。所以返回的是Point.Class
#### 4.2
这里提前强调一点：大家需要注意是getGenericInterfaces()数与Class.getInterfaces()函数一样，都只能获取此类直接继承的接口列表！
#### 4.3
上面说们说过，Type接口是用来保存当前泛型被填充的类型的，它总共有五种类型：Class,ParameterizedType,TypeVariable,WildcardType,GenericArrayType

在这上面的例子中，我们用到了Class,ParameterizedType；

当type所代表的表达式是一个完整泛型时，比如Point,那这个Type类型就是ParameterizedType；如果type所代表的是一个确定的类，比如Integer,String,Double等，那这个type所对应的类型就是Class;强转之后，得到的就是他们所对应的Class对象，即Integer.Class,String.Class,Double.Class等

前面我们说过，如果type对应的是一个泛型变量，即类似于T,或U这种还没有被填充的泛型变量，那它的类型就是TypeVariable；

而如果type对应的是一个通配符表达式，比如？ extends Num，或者仅仅是一个通配符？，类似这种有通符符的类型就是WildcardType；

而如果type对应的类型是类似于String[]的数组，那它的类型就是GenericArrayType；

### 5. 夯实JAVA基本之二 —— 反射（3）：类内部信息获取
[夯实JAVA基本之二 —— 反射（3）：类内部信息获取](http://blog.csdn.net/harvic880925/article/details/50107951)
#### 5.1
```java
//获取public类型的构造函数  
Constructor<?>[] getConstructors();  
Constructor<T> getConstructor(Class<?>... parameterTypes);  
  
//获取所有类型的构造函数  
Constructor<?>[] getDeclaredConstructors();  
Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)  
```
这四种方法中，getConstructors与getConstructor获取的是声明为public的构造函数。无法得到声明为protected,private的构造函数。而加有Declared（声明）的两个函数getDeclaredConstructors，getDeclaredConstructor能获取所有声明的构造函数，无论它是public,proctected还是private类型，都能获取到。所以这两个函数较为常用。
#### 5.2
```java
//仅能获取声明类型为public的成员变量  
Field[] getFields();  
Field getField(String name);  
//可以获取全部的成员变量  
Field[] getDeclaredFields();  
Field getDeclaredField(String name)  
```
可以看到与Constructor的获取方法类似，这里也有四个函数，其中getFields()和getField(String name)只能够获取到声明为public类型的成员变量，而getDeclaredFields()和getDeclaredField(String name)则可以得到所有的成员变量，无论是设置为public,protected还是private都是可以得到的。
getFields()和getDeclaredFields()是得到所有能够得到的成员变量的Field数组。
getField(String name)和getDeclaredField(String name)的意义是得到指定变量名的对应的Field对象。
#### 5.3
```java
Method[] getMethods()  
Method getMethod(String name, Class<?>... parameterTypes)  
  
Method[] getDeclaredMethods()  
Method getDeclaredMethod(String name, Class<?>... parameterTypes)  
```
与上面所有的有Declared系列的函数组一样，getMethods()和getMethod()只能获取声明为public的函数。而getDeclaredMethods()、getDeclaredMethod()可以得到所有的函数，无论声明为public,protected还是private。
#### 5.4
```java
Object invoke(Object receiver, Object... args)  
```
Invoke函数无疑是Method类中最重要的方法，它的功能是用于执行Method对象所对应的函数。