package duke.commands;

import java.util.ArrayList;

import duke.storage.Storage;
import duke.tasks.Task;
import duke.tasks.TaskList;
import duke.ui.UI;

/**
 * Represents a list command when the user wants to see
 * a list of all tasks.
 */
public class ListCommand extends Command {
    public static final String COMMAND_WORD = "list";

    /**
     * Creates an instance of a List Command.
     */
    public ListCommand() {
        super("List command called", false);
    }

    /**
     * Executes the command.
     * Shows the user a list of all tasks.
     *
     * @param taskList List of tasks currently being tracked.
     * @param ui       User interface object.
     * @param storage  Storage object.
     * @return String of Duke response.
     */
    @Override
    public String execute(TaskList taskList, UI ui, Storage storage) {
        assert ui != null;
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            for (int i = 0; i < taskList.getListSize(); i++) {
                Task task = taskList.getTaskAtIndex(i);
                tasks.add(task);
            }
            return ui.displayAllItems(tasks);
        } catch (IndexOutOfBoundsException e) {
            return ui.showError("There's no such element!");
        }
    }
}
