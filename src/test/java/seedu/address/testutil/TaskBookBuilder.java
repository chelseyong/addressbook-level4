package seedu.address.testutil;

import seedu.address.model.AddressBook;
import seedu.address.model.task.Task;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code AddressBook ab = new AddressBookBuilder().withPerson("John", "Doe").build();}
 */
public class TaskBookBuilder {

    private AddressBook addressBook;

    public TaskBookBuilder() {
        addressBook = new AddressBook();
    }

    public TaskBookBuilder(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    /**
     * Adds a new {@code Task} to the {@code AddressBook} that we are building.
     */
    public TaskBookBuilder withTask(Task task) {
        addressBook.addTask(task);
        return this;
    }

    public AddressBook build() {
        return addressBook;
    }
}
