package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor1;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor1 = new Visitor(15, 1.55, 20);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void visitorTallEnoughAndOldEnough() {
        assertEquals(true, rollerCoaster.isAllowedTo(visitor1));
    }

    @Test
    public void visitorTallEnoughButNotOldEnough() {
        visitor1 = new Visitor(10, 1.5, 15);
        assertEquals(false, rollerCoaster.isAllowedTo(visitor1));
    }

    @Test
    public void visitorNotTallEnoughAndOldEnough() {
        visitor1 = new Visitor(11, 1.4, 18);
        assertEquals(false, rollerCoaster.isAllowedTo(visitor1));
    }
}
