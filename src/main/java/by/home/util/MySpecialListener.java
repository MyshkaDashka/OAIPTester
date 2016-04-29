package by.home.util;

/**
 * Created by Darya on 29.04.16.
 */
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;

public class MySpecialListener implements ServletContextListener{

    ServletContext context;

    public void contextInitialized(ServletContextEvent contextEvent) {
        context = contextEvent.getServletContext();
    }
    public void contextDestroyed(ServletContextEvent contextEvent) {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
                // LOG.log(Level.INFO, String.format("deregistering jdbc driver: %s", driver));
            } catch (SQLException e) {
                // LOG.log(Level.SEVERE, String.format("Error deregistering driver %s", driver), e);
            }

        }

    }

}