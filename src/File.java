import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Антон
 * Date: 11.12.13
 * Time: 1:48
 * To change this template use File | Settings | File Templates.
 */
public class File {
    // Absolute Path
    private File parent;
    private String fileName;
    private boolean isDirectory;

    List<File> files = null;

    public File(File parent, String fileName) {
        this.parent = parent;
        this.fileName = fileName;
        this.isDirectory = false;
    }

    public File(File parent, String fileName, boolean isDirectory) {
        this.parent = parent;
        this.fileName = fileName;
        this.isDirectory = isDirectory;
        if (isDirectory) {
            this.files = new ArrayList<File>();
        }
    }

    public String getFullPath() {
        StringBuffer sb = new StringBuffer();
        if (parent != null) {
            sb.append(parent.getFullPath()).append("/").append(fileName).toString();
        } else {
            sb.append(".").toString();
        }
        return sb.toString();
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public String getPath() {
        return parent.getPath();
    }

    public String getFileName() {
        return fileName;
    }

    public List<File> getFiles() {
        return files;
    }

    public File getParent() {
        return parent;
    }
}
