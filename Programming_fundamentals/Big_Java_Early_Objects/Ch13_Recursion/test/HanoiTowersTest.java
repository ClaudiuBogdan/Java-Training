import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class HanoiTowersTest {
    private HanoiTowers mHanoiTower;

    @Test
    public void getRandomOrderOfDiscs() {
        int oneDisc = 1;
        int threeDiscs = 3;
        int discOfSizeOne = 1;
        int discOfSizeTwo = 2;
        int discOfSizeThree = 3;
        mHanoiTower = new HanoiTowers(oneDisc);
        assertTrue(mHanoiTower.getOrderOfDiscs().size() == oneDisc);
        assertTrue(mHanoiTower.getOrderOfDiscs().contains(discOfSizeOne));

        mHanoiTower = new HanoiTowers(threeDiscs);
        assertTrue(mHanoiTower.getOrderOfDiscs().size() == threeDiscs);
        assertTrue(mHanoiTower.getOrderOfDiscs().contains(discOfSizeOne));
        assertTrue(mHanoiTower.getOrderOfDiscs().contains(discOfSizeTwo));
        assertTrue(mHanoiTower.getOrderOfDiscs().contains(discOfSizeThree));
        System.out.println("Random order: " + mHanoiTower.getOrderOfDiscs().toString());
    }

    @Test
    public void getSpecificOrderOfDiscs() {
        Integer[] orderOfDiscSize = {3, 1, 2};
        mHanoiTower = new HanoiTowers(orderOfDiscSize);
        assertThat(mHanoiTower.getOrderOfDiscs().toArray(), is(orderOfDiscSize));
        System.out.println("Specific order: " + mHanoiTower.getOrderOfDiscs().toString());
    }
}