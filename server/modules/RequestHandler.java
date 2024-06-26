package laba6.server.modules;

import laba6.common.interaction.Request;
import laba6.common.interaction.Response;
import laba6.common.interaction.ResponseCode;

public class RequestHandler {
    private CommandManager commandManager;

    public RequestHandler(CommandManager commandManager){
        this.commandManager = commandManager;
    }

    /**
     * Handles requests.
     *
     * @param request Request to be processed.
     * @return Response to request.
     */
    public Response handle(Request request) {
        ResponseCode responseCode = executeCommand(request.getCommandName(), request.getCommandStringArgument(),
                request.getCommandObjectArgument());
        return new Response(responseCode, ResponseOutputer.getAndClear());
    }

    /**
     * Executes a command from a request.
     *
     * @param command               Name of command.
     * @param commandStringArgument String argument for command.
     * @param commandObjectArgument Object argument for command.
     * @return Command execute status.
     */
    private ResponseCode executeCommand(String command, String commandStringArgument,
                                        Object commandObjectArgument) {
        switch (command) {
            case "":
                break;
            case "help":
                if (!commandManager.help(commandStringArgument, commandObjectArgument))
                    return ResponseCode.ERROR;
                break;
            case "info":
                if (!commandManager.info(commandStringArgument, commandObjectArgument))
                    return ResponseCode.ERROR;
                break;
            case "show":
                if (!commandManager.show(commandStringArgument, commandObjectArgument))
                    return ResponseCode.ERROR;
                break;
            case "add":
                if (!commandManager.add(commandStringArgument, commandObjectArgument))
                    return ResponseCode.ERROR;
                break;
            case "update":
                if (!commandManager.update(commandStringArgument, commandObjectArgument))
                    return ResponseCode.ERROR;
                break;
            case "remove_by_id":
                if (!commandManager.removeById(commandStringArgument, commandObjectArgument))
                    return ResponseCode.ERROR;
                break;
            case "clear":
                if (!commandManager.clear(commandStringArgument, commandObjectArgument))
                    return ResponseCode.ERROR;
                break;
            case "execute_script":
                if (!commandManager.executeScript(commandStringArgument, commandObjectArgument))
                    return ResponseCode.ERROR;
                break;
            case "exit":
                if (!commandManager.exit(commandStringArgument, commandObjectArgument))
                    return ResponseCode.ERROR;
                break;
            case "add_if_max":
                if (!commandManager.addIfMax(commandStringArgument, commandObjectArgument))
                    return ResponseCode.ERROR;
                break;
            case "reorder":
                if (!commandManager.reorder(commandStringArgument, commandObjectArgument))
                    return ResponseCode.ERROR;
                break;
            case "average_of_annual_turnover":
                if (!commandManager.avgOfAnnualTurnover(commandStringArgument, commandObjectArgument))
                    return ResponseCode.ERROR;
                break;
            case "min_by_employees_count":
                if (!commandManager.minByEmployeesCount(commandStringArgument, commandObjectArgument))
                    return ResponseCode.ERROR;
                break;
            case "print_field_descending_annual_turnover":
                if (!commandManager.printAnnualTurnovers(commandStringArgument, commandObjectArgument))
                    return ResponseCode.ERROR;
                break;
            case "insert_at":
                if (!commandManager.insertAt(commandStringArgument, commandObjectArgument))
                    return ResponseCode.ERROR;
                break;
            case "server_exit":
                if (!commandManager.serverExit(commandStringArgument, commandObjectArgument))
                    return ResponseCode.ERROR;
                return ResponseCode.SERVER_EXIT;
            default:
                ResponseOutputer.appendln("Command '" + command + "' not found. Type 'help' for help.");
                return ResponseCode.ERROR;
        }
        return ResponseCode.OK;
    }

}
