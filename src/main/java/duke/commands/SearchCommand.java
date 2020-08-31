package duke.commands;

import java.util.ArrayList;

import duke.storage.Storage;
import duke.tasks.Task;
import duke.tasks.TaskList;
import duke.ui.UI;


/**
 * Represents a seach command when the user wants to
 * search for tasks with a specific keyword.
 */
public class SearchCommand extends Command {
    public static final String COMMAND_WORD = "search";

    /**
     * Creates an instance of a Search Command with the appropriate
     * search keyword.
     *
     * @param commandDescription Search keyword.
     */
    public SearchCommand(String commandDescription) {
        super(commandDescription, false);
    }

    /**
     * Executes the Command.
     * Searches the list of tasks and prints the tasks that
     * match the keyword.
     *
     * @param taskList List of tasks currently being tracked.
     * @param ui       User interface object.
     * @param storage  Storage object.
     * @return String of Duke response.
     */
    @Override
    public String execute(TaskList taskList, UI ui, Storage storage) {
        ArrayList<Task> tasks = new ArrayList<>();
        String pattern = "(.*)" + commandDescription + "(.*)";
        for (int i = 0; i < taskList.getListSize(); i++) {
            Task task = taskList.getTaskAtIndex(i);
            if (task.toString().matches(pattern)) {
                tasks.add(task);
            }
        }
        return ui.displayAllItems(tasks);
    }
}
