package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BOB;

import org.junit.jupiter.api.Test;

public class ParentTest {

    @Test
    public void addChild_validStudent_childAddedToSet() {
        Parent parent = new Parent(new Name("Bob"));
        parent.addChild(ALICE);
        assertTrue(parent.hasChild(ALICE));
        assertTrue(parent.hasChildName(ALICE.getName()));
    }

    @Test
    public void removeChild_validStudent_childRemovedToSet() {
        Parent parent = new Parent(new Name("Bob"));
        parent.addChild(ALICE);
        assertTrue(parent.hasChild(ALICE));
        assertTrue(parent.hasChildName(ALICE.getName()));

        parent.removeChild(ALICE);
        assertFalse(parent.hasChild(ALICE));
        assertFalse(parent.hasChildName(ALICE.getName()));
    }

    @Test
    public void removeChild_emptySet_childRemovedToSet() {
        Parent parent = new Parent(new Name("Bob"));

        parent.removeChild(ALICE);
        assertFalse(parent.hasChild(ALICE));
        assertFalse(parent.hasChildName(ALICE.getName()));
    }

    @Test
    public void getChildren_modifySet_throwsUnsupportedOperationException() {
        Parent parent = new Parent(new Name("Bob"));
        parent.addChild(ALICE);
        assertTrue(parent.hasChild(ALICE));
        assertTrue(parent.hasChildName(ALICE.getName()));

        assertThrows(UnsupportedOperationException.class, () -> parent.getChildren().add(BOB));
    }
}
