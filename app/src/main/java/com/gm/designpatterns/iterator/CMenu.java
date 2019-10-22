package com.gm.designpatterns.iterator;

import java.util.Vector;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/16 17:37
 * Description: AMenu
 * Company : 北京四维图新科技股份有限公司
 */
public class CMenu implements Iteratable {

    private Vector<MenuItem> vector;

    public CMenu() {
        this.vector = new Vector<>();
        this.vector.add(  new MenuItem("C1", "C1 is right", 1d));
        this.vector.add(  new MenuItem("C2", "C2 is right", 2d));
        this.vector.add(  new MenuItem("C3", "C3 is right", 3d));
    }

    public Vector<MenuItem> getVector() {
        return vector;
    }

    //Iterator

    @Override
    public BaseIterator<MenuItem> createIterator() {
        return new CMenuIterator();
    }

    /**
     * 加入泛型 提高代码可读性
     */
   class BaseIterator<T> implements Iterator {
       int index;
       @Override
       public boolean hasNext() {
           return false;
       }
       @Override
       public T next() {
           return null;
       }
   }

    public class CMenuIterator extends BaseIterator<MenuItem> {
        @Override
        public boolean hasNext() {
            return index < vector.size() ;
        }
        @Override
        public MenuItem next() {
            MenuItem menuItem = vector.get(index);
            index++;
            return menuItem;
        }
    }
}
