package main.java;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: jeffrep
 * Date: 7/9/14
 * Time: 12:28 PM
 * To change this template use File | Settings | File Templates.
 */

class Item implements Comparable<Item>{

    int orderNumber;
    String type;
    int size;
    int boxNumber;
    String status;

    @Override
    public int compareTo(Item i) {
        return type.compareTo(i.getType());
    }

    @Override
    public boolean equals(Object item) {
        Item i = (Item) item;
        return getType().equals(i.getType());

    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }



    Item(int o, String t, int s, int b, String st) {

        orderNumber = o;
        type = t;
        size = s;
        boxNumber = b;
        status = st;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public int getBoxNumber() {
        return boxNumber;
    }

    public String getStatus() {
        return status;
    }

    public String toString() {

        return "\norder number: " + orderNumber + " type: " + type + " size: " + size + " in box number: " + boxNumber + " status: " + status;

    }

}

public class Packager {

    ArrayList<Item> completeOrder = new ArrayList<Item>();
    ArrayList<Item> types = new ArrayList<Item>(); //list is populated from uniqueSet
    //HashSet<Item> uniqueSet = new HashSet<Item>();
    TreeSet<Item> uniqueSet = new TreeSet<Item>(); //removes duplicate from order to create the types available
    ArrayList<ArrayList<Item>> listOfOrders = new ArrayList<ArrayList<Item>>();


    private int orderNumber = 1, boxID = 1, setNums = 50;


    public static void main(String[] args) {

        new Packager().go();

    }

    class TypeCompare implements Comparator<Item> {
        public int compare(Item one, Item two) {
            return one.getType().compareTo(two.getType());

        }

    }

    class BoxCompare implements Comparator<Item> {
        public int compare(Item one, Item two) {

            if (one.getBoxNumber() < two.getBoxNumber())
                return -1;
            else return 1;

        }

    }

    public void go() {

        makeCompleteOrder();

        BoxCompare boxCompare = new BoxCompare();
        Collections.sort(completeOrder, boxCompare);

        System.out.println(completeOrder);
        // System.out.println("HashSet: ");
        // System.out.println(uniqueSet);

    }

    public void setOrderNumber() { //updates order number (for multiple orders)

        orderNumber = orderNumber + 1;
    }

    public String getRandomType() { //randomly assigns a type of product that we sell

        Random r = new Random();
        int typeNumber;

        typeNumber = 1 + r.nextInt(6);

        switch(typeNumber)
        {
            case 1: return "shoes";

            case 2: return "clothes";

            case 3: return "bags";

            case 4: return "housewares";

            case 5: return "beauty";

            case 6: return "accessories";

            default:

                System.out.println(typeNumber);
                return "error";

        }
    }

    public ArrayList makeCompleteOrder() {

        Random r = new Random();
        int numOfItems =  1 + r.nextInt(setNums); //chooses a random number that will be of items in the order.

        for (int x = 0; x < numOfItems; x++ ) {

            String tempType = getRandomType();
            int tempSize = getSize(tempType);

            Item item = new Item(orderNumber, tempType, tempSize, boxID, "unboxed" );

            completeOrder.add(item);
        }

        boxOrder(completeOrder);

        return completeOrder;
    }

    public int getSize(String type) { // returns the size value of the item

        switch (type) {

            case "shoes": return 3;

            case "clothes": return 2;

            case "bags": return 3;

            case "housewares": return 5;

            case "beauty": return 2;

            case "accessories": return 1;

            default: return 0;
        }

    }

    public ArrayList<Item> boxOrder (ArrayList<Item> completeOrder) {

        int boxSize = 9;

        while (!isComplete(completeOrder)) {  //loops until every item is boxed

            for (int x = 0; x < completeOrder.size(); x++) {

                boolean full = isFull(boxSize, completeOrder.get(x).size);

                if (full) { //if full, increments the boxID, resets boxSize variable, assigns ID to ordered item, subtracts boxSize, and advises that it has been boxed

                    boxID++;
                    boxSize = 9;
                    completeOrder.get(x).boxNumber = boxID;
                    boxSize -= completeOrder.get(x).size;
                    completeOrder.get(x).status = "boxed";
                    continue;
                }
                else if (!full) { //subtracts from boxSize, assigns ID to ordered item, and updates the status
                    boxSize -= completeOrder.get(x).size;
                    completeOrder.get(x).boxNumber = boxID;
                    completeOrder.get(x).status = "boxed";
                    continue;
                }

            }

        }

        return completeOrder;
    }

    public boolean isComplete (ArrayList<Item> completeOrder) {

        for (int x = 0; x < completeOrder.size(); x++ ) {

            if (completeOrder.get(x).status.equals("unboxed")) {

                return false;

            }

        }

        return true;

    }

/*    public ArrayList<Item> boxOrder_old (ArrayList<Item> completeOrder) {

        int boxSize = 9;



        uniqueSet.addAll(completeOrder);
        types.addAll(uniqueSet);

        for (int x = 0; x < types.size(); x++) { //runs through each category, comparing the type to the type of the ordered item

            boxID++;
            boxSize = 9;

            for (int y = 0; y < completeOrder.size(); y++ ) {

                //System.out.println("types.get(x): " + types.get(x) + " completeOrder.get(y).type: " + completeOrder.get(y).type);

                if (types.get(x).type == completeOrder.get(y).type) {

                    //System.out.println("isFull results: " + isFull(boxSize, completeOrder.get(x).size));

                    boolean full = isFull(boxSize, completeOrder.get(y).size); //checks to see if box is full

                    if (full) { //if full, increments the boxID, resets boxSize variable, assigns ID to ordered item, subtracts boxSize, and advises that it has been boxed

                        // System.out.println("Out of room! Need a new box.");
                        boxID++;
                        boxSize = 9;
                        completeOrder.get(y).boxNumber = boxID;
                        boxSize -= completeOrder.get(y).size;
                        completeOrder.get(y).status = "boxed";
                        continue;
                    }
                    else if (!full) { //subtracts from boxSize, assigns ID to ordered item, and updates the status
                        boxSize -= completeOrder.get(y).size;
                        completeOrder.get(y).boxNumber = boxID;
                        completeOrder.get(y).status = "boxed";
                        continue;
                    }

                }

            }

        }

        return completeOrder;


    }
*/

    public boolean isFull (int boxSize, int typeSize) {

        //System.out.println("boxSize = " + boxSize + " typeSize = " + typeSize + " box ID is: " + boxID);
        //System.out.println("true/false: " + (boxSize < typeSize || boxSize == 0));

        if (boxSize < typeSize || boxSize == 0) { //if the box doesn't have any space left or doesn't have enough space, returns true

            return true;
        }

        return false;
    }



}
