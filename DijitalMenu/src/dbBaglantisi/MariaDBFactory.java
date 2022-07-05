package dbBaglantisi;


public class MariaDBFactory extends DBFactory{

    @Override
    public ConnectDB CreateConnection() {
        return new MariaDBConnection();
    }

    @Override
    public Command CreateCommand() {
        return new MariaDBCommand();
    }
    
}
