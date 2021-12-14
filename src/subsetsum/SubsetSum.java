package subsetsum;

import com.sun.org.apache.xpath.internal.axes.SubContextList;

import java.util.ArrayList;

/**
 * Given a set of values and a value sum, this class attempts to find out if there exists a subset in an array
 * whose sum is equal to the given sum
 *
 * @author CS1C, Foothill College, Michael Bernal
 * @version 1.0
 */
public class SubsetSum
{

    private static ArrayList<Sublist> collection = new ArrayList<Sublist>();
    private static ArrayList<Double> subSet;

    /**
     * Loop through all elements in S, as well as through all subsets and find the sublist L with the largest
     * sum.
     * @param shoppingList list of prices
     * @param budget inputted budget sum
     * @return sum of the subsets
     */
    public static ArrayList<Double> findSubset(ArrayList<Double> shoppingList, double budget)
    {
        Sublist newList =  new Sublist(shoppingList);
        collection.add(newList);

        for(int i = 0; i <shoppingList.size(); i++)
        {
            for(int k = 0; k < collection.size() - k; k++)
            {
                newList = collection.get(k);
                double sum = newList.getSum() + shoppingList.get(i);

                if(sum <= budget)
                {
                    try
                    {
                        collection.add(newList.addItem(i));
                    }
                        catch (CloneNotSupportedException e)
                    {
                        e.printStackTrace();
                    }
                }
                else if(newList.getSum() + shoppingList.get(i) == budget)
                    break;
            }
        }
        double highest = collection.get(0).getSum();
        int highIdx = 0;

        for(int i = 0; i < collection.size(); i++)
        {
            double currentVal = collection.get(i).getSum();
            if(currentVal > highest)
            {
                highest = currentVal;
                highIdx = i;
            }
        }
        subSet = collection.get(highIdx).getSubSet();
        return subSet;
    }
}
