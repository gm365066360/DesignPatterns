package com.gm.designpatterns.iterator;

import java.util.ArrayList;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/16 17:37
 * Description: AMenu
 * Company : 北京四维图新科技股份有限公司
 */
public class AMenu implements Iteratable {

    ArrayList<MenuItem> menuItems;

    public AMenu() {
        this.menuItems = new ArrayList<>();
        this.menuItems.add(new MenuItem("A1","A1 is right",1d));
        this.menuItems.add(new MenuItem("A2","A2 is right",2d));
        this.menuItems.add(new MenuItem("A3","A3 is right",3d));
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }


    //Iterator


    @Override
    public Iterator createIterator() {
        return new AMenuIterator();
    }

    public class AMenuIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            return index < menuItems.size();
        }

        @Override
        public Object next() {
            //++
            return menuItems.get(index++);
        }
    }
}
