package org.gfs.glowcore.core.util.sql.core;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Configuration {
    
    String url;
    String user;
    String password;
    
    int poolSize;
    
    //time: 1000 = 1 second
    
    int timeout;
    int leakDetectThreshold;
    
    public void configure(String url, String user, String password, int poolSize, int timeout, int leakDetectThreshold) {
        HikariConfig dbconfig = new HikariConfig();
          dbconfig.setJdbcUrl(url);
          dbconfig.setUsername(user);
          dbconfig.setPassword(password);
          dbconfig.setMaximumPoolSize(poolSize);
          dbconfig.setConnectionTimeout(timeout);
          dbconfig.setLeakDetectionThreshold(leakDetectThreshold);
          
          HikariDataSource datasource = new HikariDataSource(dbconfig);

    }
}