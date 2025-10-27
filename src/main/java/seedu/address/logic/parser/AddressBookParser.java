package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.AddSessionCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.DeleteSessionCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.EditSessionCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.RemarkCommand;
import seedu.address.logic.commands.ViewCommand;
import seedu.address.logic.commands.ViewSessionCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class AddressBookParser {

    /** Used for initial separation of command word and args. */
    private static final Pattern BASIC_COMMAND_FORMAT =
            Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    private static final Logger logger = LogsCenter.getLogger(AddressBookParser.class);

    /**
     * Parse raw {@code userInput} into a concrete {@link Command}.
     * Splits first token as command and remainder as args.
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(MESSAGE_INVALID_COMMAND_FORMAT.formatted(HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");

        logger.fine("Command word: " + commandWord + "; Arguments: " + arguments);

        switch (commandWord) {
        case AddCommand.COMMAND_WORD:
            return new AddCommandParser().parse(arguments);
        case EditCommand.COMMAND_WORD:
            return new EditCommandParser().parse(arguments);
        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);
        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();
        case FindCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments);
        case RemarkCommand.COMMAND_WORD:
            return new RemarkCommandParser().parse(arguments);
        case ListCommand.COMMAND_WORD:
            return new ListCommand();
        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();
        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case AddSessionCommand.COMMAND_WORD:
            return new AddSessionCommandParser().parse(arguments);
        case EditSessionCommand.COMMAND_WORD:
            return new EditSessionCommandParser().parse(arguments);
        case DeleteSessionCommand.COMMAND_WORD:
            return new DeleteSessionCommandParser().parse(arguments);

        case ViewCommand.COMMAND_WORD:
            return new ViewCommandParser().parse(arguments);

        // Support both camel-case and lower-case + optional leading slash aliases.
        case ViewSessionCommand.COMMAND_WORD:
        case ViewSessionCommand.COMMAND_WORD_LOWER:
        case "/" + ViewSessionCommand.COMMAND_WORD:
        case "/" + ViewSessionCommand.COMMAND_WORD_LOWER:
            return new ViewSessionCommandParser().parse(arguments);

        default:
            logger.finer("This user input caused a ParseException: " + userInput);
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }
}
