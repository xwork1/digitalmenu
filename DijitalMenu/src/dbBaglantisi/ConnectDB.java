
package dbBaglantisi;

import java.sql.Connection;

public abstract class ConnectDB {
    public abstract Connection Connect();
    public abstract void Disconnected();
}
