package duke.commands;

import duke.commands.Command;
import duke.tasks.TaskList;
import duke.tasks.Task;
import duke.tasks.ToDo;
import duke.storage.Storage;
import duke.ui.UI;

public class TodoCommand extends Command {
    public static final String COMMAND_WORD = "todo";

    public TodoCommand(String commandBody) {
        super(commandBody, false);
    }

    @Override
    public void execute(TaskList taskList, UI ui, Storage storage) {
        Task task = new ToDo(commandDescription);
        taskList.addToList(task);
        ui.displayAddedTask(task, taskList.getListSize());
    }
}
