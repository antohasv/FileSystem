import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Антон
 * Date: 18.12.13
 * Time: 0:55
 * To change this template use File | Settings | File Templates.
 */
public class CdCmd implements Command {
    String pattern;

    public CdCmd() {
        pattern = new StringBuffer(Main.CD).append(" ").append("(?<fileName>[a-zA-Z0-9\\.]+)").toString();
    }

    @Override
    public String getRegExp() {
        return pattern;
    }

    @Override
    public void execute(FileSystem fileSystem, String fileName) {
        File file = fileSystem.getFile();
        if (fileName.equals("..")) {
            if (file.getParent() == null) {
                System.out.println("Top directory");
            } else {
                fileSystem.setFile(file.getParent());
            }
        } else {
            File findFile = findFile(file, fileName);
            if (findFile != null) {
                if (findFile.isDirectory()) {
                    fileSystem.setFile(findFile);
                } else {
                    System.out.println("There isn't directory");
                }
            } else {
                System.out.println("File not found");
            }
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
