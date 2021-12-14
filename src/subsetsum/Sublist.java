package subsetsum;

import java.util.ArrayList;

/**
 * Facilitates the creation of a sublist of elements
 * @author CS1C, Foothill College, Michael Bernal
 * @version 1.0
 */
public class Sublist implements Cloneable
{

    private double sum = 0;
    private ArrayList<Double> oldObj;
    private ArrayList<Integer> indices;

    /**
     * Constructor to create empty list.
     * @param shoppingList a list of prices
     */
    public Sublist(ArrayList<Double> shoppingList)
    {
        sum = 0;
        oldObj = shoppingList;
        indices = new ArrayList<Integer>();
    }

    /**
     * Required by addItem(), performs a shallow and deep copy.
     * @return new Object
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException
    {
        Sublist newObj = (Sublist)super.clone();
        newObj.indices = (ArrayList<Integer>)indices.clone();
        return newObj;
    }

    /**
     * Loop through indices and add to our returned set.
     * @return returns the subset
     */
    public ArrayList<Double> getSubSet()
    {
        ArrayList<Double> returnSet = new ArrayList<Double>();

        for(int i = 0; i < indices.size(); i++)
        {
            returnSet.add(oldObj.get(indices.get(i)));
        }
        return returnSet;
    }

    /**
     * Adds item to list
     * @param itemIdx the index of the item to add
     * @return the new list
     * @throws CloneNotSupportedException
     */
    Sublist addItem(int itemIdx) throws CloneNotSupportedException
    {
        Sublist newList = (Sublist)clone();
        newList.indices.add(itemIdx);
        newList.sum += oldObj.get(itemIdx);
        return newList;
    }

    double getSum()
    {
        return sum;
    }
}
