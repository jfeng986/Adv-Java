package beginner;

import com.sandwich.koan.Koan;

import static com.sandwich.koan.constant.KoanConstants.__;
import static com.sandwich.util.Assert.assertEquals;

public class AboutEquality {

    @Koan
    public void doubleEqualsTestsIfTwoObjectsAreTheSame() {
        Object object = new Object();
        Object sameObject = object;
        assertEquals(object, sameObject);
        assertEquals(object, sameObject);
    }

    @Koan
    public void equalsMethodByDefaultTestsIfTwoObjectsAreTheSame() {
        Object object = new Object();
        assertEquals(object.equals(object), object.equals(object));
        assertEquals(object.equals(new Object()), object.equals(new Object()));
    }

    @Koan
    public void equalsMethodCanBeChangedBySubclassesToTestsIfTwoObjectsAreEqual() {
        Object object = new Integer(1);
        assertEquals(object, object);
        assertEquals(object, new Integer(1));
        // Note: This means that for the class 'Object' there is no difference between 'equal' and 'same'
        // but for the class 'Integer' there is difference - see below
    }

    @Koan
    public void equalsMethodCanBeChangedBySubclassesToTestsIfTwoObjectsAreEqualExample() {
        Integer value1 = new Integer(4);
        Integer value2 = new Integer(2 + 2);
        assertEquals(value1, value1);
        assertEquals(value1, value2);
    }

    @Koan
    public void objectsNeverEqualNull() {
        assertEquals(null, null);
    }

    @Koan
    public void objectsEqualThemselves() {
        Object obj = new Object();
        assertEquals(obj, obj);
    }
}
