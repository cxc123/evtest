package utility;

import org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.List;

/**
 * Created by aakumar on 11/11/17.
 */
public class ListComparator {
    /* compare two object or List of object
     */
    public static boolean compareObject(Object o1, Object o2)
    {
        if (o1 instanceof List<?> && o2 instanceof List<?>)
        {
            List l1 = (List<Object>) o1;
            List l2 = (List<Object>) o2;
            if(l1.size() != l2.size()) return false;
            return compareList(l1,l2);
        }
        else return EqualsBuilder.reflectionEquals(o1,o2);

    }


    /*
    Compare two generic List
     */
    private static boolean compareList(List<Object> l1, List<Object> l2)
    {
        int count=0;
        for (Object o : l1)
        {
            Object temp = o;
            for (Object otemp : l2)
            {
                if (EqualsBuilder.reflectionEquals(temp, otemp))
                {
                    count++;
                }
            }

        }

        if(count == l1.size()) return  true;
        return  false;

    }

}
