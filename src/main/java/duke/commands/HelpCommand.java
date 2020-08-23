package duke.commands;

import duke.storage.Storage;
import duke.tasks.TaskList;
import duke.ui.UI;

public class HelpCommand extends Command {
    public static final String COMMAND_WORD = "--help";

    @Override
    public void execute(TaskList taskList, UI ui, Storage storage) {
        ui.showHelp();
    }
}
