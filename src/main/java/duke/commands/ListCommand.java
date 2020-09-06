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
        ArrayList<Task> tasks = new ArrayList<>();
        getAllTasks(tasks, taskList);
        return ui.displayAllItems(tasks);
    }

    private void getAllTasks(ArrayList<Task> tasks, TaskList taskList) {
        for (int i = 0; i < taskList.getListSize(); i++) {
            Task task = taskList.getTaskAtIndex(i);
            tasks.add(task);
        }
    }
}
