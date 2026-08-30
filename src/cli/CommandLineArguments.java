package cli;

public class CommandLineArguments {
    private final String csvFilePath;
    private final String outputMethod;
    private final String outputFilePath;

    private CommandLineArguments(String csvFilePath,String outputMethod,String outputFilePath){
        this.csvFilePath = csvFilePath;
        this.outputMethod = outputMethod;
        this.outputFilePath = outputFilePath;
    }

    public static CommandLineArguments parseArg(String[] args) {

        return new CommandLineArguments(args[0],args[1],args.length > 2 ? args[2] : null);
    }

    public String getCsvFilePath() {
        return csvFilePath;
    }

    public String getOutputMethod() {
        return outputMethod;
    }

    public String getOutputFilePath() {
        return outputFilePath;
    }

}
