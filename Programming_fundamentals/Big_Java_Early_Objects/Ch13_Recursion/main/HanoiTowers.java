import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Class that solve the Towers of Hanoi given the number of discs.
 */
public class HanoiTowers {

    private List<Integer> orderOfDiscs;
    private List<Integer> towerOne;
    private List<Integer> towerTwo;
    private List<Integer> towerThree;

    /**
     * Constructor that creates and initialize a HanoiTower object given the number of discs.
     * The order of the discs will be generated randomly.
     * @param numOfDiscs Number of discs.
     */
    public HanoiTowers(int numOfDiscs){
        this(orderDiscsRandomly(numOfDiscs));
    }

    /**
     * Constructor that creates and initializes a HanoiTower object with the discs in a specific order.
     * @param orderOfDiscs Array that specifies the order of the discs.
     */
    public HanoiTowers(Integer[] orderOfDiscs){
        this.orderOfDiscs = new ArrayList<>();
        addDiscsToList(orderOfDiscs);
    }

    /**
     * Method that generate a list of numbers representing the discs size and shuffle the list.
     * @param numOfDiscs The number of different disc sizes to generate.
     * @return Array of disc order by different size.
     */
    private static Integer[] orderDiscsRandomly(int numOfDiscs) {
        ArrayList<Integer> listOfDiscs = new ArrayList<>();
        for(int i=1; i <= numOfDiscs; i++){
            listOfDiscs.add(i);
        }
        Collections.shuffle(listOfDiscs);
        return listOfDiscs.toArray(new Integer[numOfDiscs]);
    }

    /**
     * Method that insert the discs from an int array into a list of integers.
     * @param arrayOfDiscs The array of discs specifying the order of the discs.
     */
    private void addDiscsToList(Integer[] arrayOfDiscs){
        for(int discSize : arrayOfDiscs){
            orderOfDiscs.add(discSize);
        }
    }

    public List<Integer> getOrderOfDiscs() {
        return orderOfDiscs;
    }
}
