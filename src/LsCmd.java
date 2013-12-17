import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Антон
 * Date: 18.12.13
 * Time: 1:12
 * To change this template use File | Settings | File Templates.
 */
public class LsCmd implements Command {
    String pattern;

    public LsCmd() {
        pattern = new StringBuffer(Main.LS).append("").append("(?<fileName>[a-zA-Z0-9]+){0,1}").toString();
    }

    @Override
    public String getRegExp() {
        return pattern;
    }

    @Override
    public void execute(FileSystem fileSystem, String fileName) {
        File curFile = fileSystem.getFile();
        List<File> fileList = curFile.getFiles();

        if (fileList.size() == 0) {
            return;
        }

        StringBuffer msg = new StringBuffer();
        for (File file : fileList) {
            msg.append("\n");
            if (file.isDirectory()) {
                msg.append("Dir_").append(file.getFileName());
            } else {
                msg.append(file.getFileName());
            }
        }
        System.out.println(msg.toString());
    }
}
