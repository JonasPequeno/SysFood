package com.ifpb.factory;

import com.ifpb.interfaces.DaoFactoryIF;

/**
 *
 * @author jonas
 */
public class DaoFactory {
    
    public static DaoFactoryIF createFactoryDao(){
        return new DaoFactoryPostgres();
    }
}
