import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Антон
 * Date: 08.12.13
 * Time: 1:11
 * To change this template use File | Settings | File Templates.
 */

public class Main {
    public static final String MKDIR = "mkdir";
    public static final String CD = "cd";
    public static final String LS = "ls";
    public static final String RM = "rm";
    public static final String TOUCH = "touch";

    private Command[] commands = new Command[]{
            new MkdirCmd(), new CdCmd(), new LsCmd(), new RmCmd(), new TouchCmd()
    };

    Main() {
        // Root File
        FileSystem fileSystem = FileSystem.newInstance();

        while (true) {
            String inCommand = "";
            System.out.print(fileSystem.getFile().getFullPath() + ">");

            // Read Input Stream(Console)
            try {
                BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                inCommand = bufferRead.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < commands.length; i++) {
                Command command = commands[i];
                Matcher matcher = Pattern.compile(command.getRegExp()).matcher(inCommand);
                if (matcher.matches()) {
                    String fileName = matcher.group("fileName");
                    command.execute(fileSystem, fileName);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
