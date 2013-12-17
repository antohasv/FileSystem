/**
 * Created with IntelliJ IDEA.
 * User: Антон
 * Date: 18.12.13
 * Time: 1:17
 * To change this template use File | Settings | File Templates.
 */
public class TouchCmd implements Command {
    private String pattern;

    public TouchCmd() {
        pattern = new StringBuffer(Main.TOUCH).append(" ").append("(?<fileName>[a-zA-Z0-9]+)").toString();
    }

    @Override
    public String getRegExp() {
        return pattern;
    }

    @Override
    public void execute(FileSystem fileSystem, String fileName) {
        File file = fileSystem.getFile();
        File tFile = new File(file, fileName);
        file.getFiles().add(tFile);
    }
}
