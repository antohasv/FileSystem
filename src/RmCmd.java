import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Антон
 * Date: 18.12.13
 * Time: 1:14
 * To change this template use File | Settings | File Templates.
 */
public class RmCmd implements Command {
    private String pattern;

    public RmCmd() {
        pattern = new StringBuffer(Main.RM).append(" ").append("(?<fileName>[a-zA-Z0-9]+)").toString();
    }

    @Override
    public String getRegExp() {
        return pattern;
    }

    @Override
    public void execute(FileSystem fileSystem, String fileName) {
        File file = fileSystem.getFile();
        File rmFile =  findFile(file, fileName);

        if (rmFile == null) {
            System.out.println("File not found");
        } else if (rmFile.getParent() == null) {
            System.out.println("You can't remove top directory");
        } else {
            file.getFiles().remove(rmFile);
        }
    }

    private File findFile(File curFile, String fileName) {
        List<File> fileList = curFile.getFiles();

        if (fileList.size() == 0) {
            return null;
        }

        for (File file : fileList) {
            if (file.getFileName().equalsIgnoreCase(fileName)) {
                return file;
            }
        }
        return null;
    }
}
