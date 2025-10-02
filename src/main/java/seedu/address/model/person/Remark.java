package seedu.address.model.person;

import static java.util.Objects.requireNonNull;


/**
 * Represents a person's remark in the address book.
 */
public class Remark {
    /** The remark value. */
    public String value;

    /**
     * Constructs a {@code Remark} with the given value.
     *
     * @param value The remark value.
     */
    public Remark(String value) {
        requireNonNull(value);
        this.value = value;
    }

    /**
     * Returns the remark value as a string.
     *
     * @return The remark value as a string.
     */
    @Override
    public String toString() {
        return value;
    }

    /**
     * Checks if this {@code Remark} is equal to another object.
     *
     * @param other The object to compare with.
     * @return True if the other object is the same as this {@code Remark} or has the same value, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Remark // instanceof handles nulls
                && value.equals(((Remark) other).value)); // state check
    }

    /**
     * Returns the hash code of the {@code Remark}'s value.
     *
     * @return The hash code of the {@code Remark}'s value.
     */
    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
