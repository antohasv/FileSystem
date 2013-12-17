/**
 * Created with IntelliJ IDEA.
 * User: Антон
 * Date: 18.12.13
 * Time: 0:24
 * To change this template use File | Settings | File Templates.
 */
public interface Command {
    String getRegExp();
    void execute(FileSystem fileSystem, String fileName);
}
