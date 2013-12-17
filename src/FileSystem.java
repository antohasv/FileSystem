/**
 * Created with IntelliJ IDEA.
 * User: Антон
 * Date: 18.12.13
 * Time: 0:44
 * To change this template use File | Settings | File Templates.
 */
public class FileSystem {
    private static FileSystem fileSystem = null;
    private File file;

    private FileSystem() {
        file = new File(null, null, true);
    }

    public static FileSystem newInstance() {
        if (fileSystem == null) {
            fileSystem = new FileSystem();
        }
        return fileSystem;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
