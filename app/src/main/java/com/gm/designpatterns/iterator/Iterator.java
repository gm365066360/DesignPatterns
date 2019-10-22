package com.gm.designpatterns.iterator;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/16 17:32
 * Description: Menu
 * Company : 北京四维图新科技股份有限公司
 */
public interface Iterator {
   /**
   *  for( ;hasNext(); i++)
   */
   boolean hasNext();
   Object next();
}
