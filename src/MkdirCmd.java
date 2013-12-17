/**
 * Created with IntelliJ IDEA.
 * User: Антон
 * Date: 18.12.13
 * Time: 0:25
 * To change this template use File | Settings | File Templates.
 */
public class MkdirCmd implements Command {
    private String pattern;

    public MkdirCmd() {
        pattern = new StringBuffer(Main.MKDIR).append(" ").append("(?<fileName>[a-zA-Z0-9]+)").toString();
    }

    @Override
    public String getRegExp() {
        return pattern;
    }

    @Override
    public void execute(FileSystem fileSystem, String fileName) {
        File curFile = fileSystem.getFile();
        File file = new File(curFile, fileName, true);
        curFile.getFiles().add(file);
        fileSystem.setFile(file);
    }
}
