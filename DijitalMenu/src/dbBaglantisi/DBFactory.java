
package dbBaglantisi;


public abstract class DBFactory {
    public abstract ConnectDB CreateConnection();
    public abstract Command CreateCommand();
}
