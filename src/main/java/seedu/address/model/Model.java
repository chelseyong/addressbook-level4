package seedu.address.model;

import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.model.tag.Tag;
import seedu.address.model.task.Deadline;
import seedu.address.model.task.Task;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Task> PREDICATE_SHOW_ALL_TASKS = unused -> true;

    /** Clears existing backing model and replaces with the provided new data. */
    void resetData(ReadOnlyTaskBook newData);

    /** Returns the AddressBook */
    ReadOnlyTaskBook getAddressBook();

    /**
     * Returns true if a task with the same identity as {@code task} exists in the task book.
     */
    boolean hasTask(Task task);

    //@@author emobeany
    /**
     * Returns true if there is a task in task book that has exactly the same fields as input task
     */
    boolean isTheExactSameTaskAs(Task task);

    void deferTaskDeadline(Task task, int deferredDay);
    /**
     * Deletes the given task.
     * The task must exist in the task book.
     */
    void deleteTask(Task target);

    /**
     * Completes the given task.
     * The task must exist in the task book.
     */
    void completeTask(Task target, int hours);

    /**
     * Adds the given task.
     * {@code task} must not already exist in the task book.
     */
    void addTask(Task task);

    //@@author ChanChunCheong
    /**
     * Adds the to the selected task.
     * {@code task} must not already exist in the task book.
     */
    void addTag(Task task, Tag tag);

    /**
     * Removes the tag from the selected task.
     * {@code task} must not already exist in the task book.
     */
    void removeTag(Task task, Tag tag);

    /** Selects the input tag as Tag.*/
    void selectTag(Tag tag);

    //@@author emobeany
    /** Selects the input date as deadline.*/
    void selectDeadline(Deadline deadline);

    /** Gets deadline previously selected from the TaskBook.*/
    Deadline getDeadline();

    /**
     * Gets year of previously selected year from the TaskBook
     */
    String getYear();

    /**
     * Replaces the given task {@code target} with {@code editedTask}.
     * {@code target} must exist in the task book.
     * The task identity of {@code editedTask} must not be the same as another existing task in the task book.
     */
    void updateTask(Task target, Task editedTask);

    //@@author ChanChunCheong
    void sortTask(String method);

    /** Returns an unmodifiable view of the filtered task list */
    ObservableList<Task> getFilteredTaskList();

    /**
     * Updates the filter of the filtered task list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredTaskList(Predicate<Task> predicate);

    /**
     * Returns true if the model has previous task book states to restore.
     */
    boolean canUndoTaskBook();

    /**
     * Returns true if the model has undone task book states to restore.
     */
    boolean canRedoTaskBook();

    /**
     * Restores the model's task book to its previous state.
     */
    void undoTaskBook();

    /**
     * Restores the model's task book to its previously undone state.
     */
    void redoTaskBook();

    /**
     * Saves the current task book state for undo/redo.
     */
    void commitTaskBook();

    /**
     * Updates task list to
     * contain only completed tasks
     */
    public void trackProductivity();
}
