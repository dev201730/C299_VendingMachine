package com.example.vendingmachine;

import com.example.controller.Controller;
import com.example.dao.AuditDaoFileImpl;
import com.example.dao.PersistenceException;
import com.example.dao.VendingMachineDaoFileImpl;
import com.example.service.DataValidationException;
import com.example.service.NoMerchInventoryException;
import com.example.service.NoSuchMerchException;
import com.example.service.NotEnoughMoneyException;
import com.example.service.ServiceLayerImpl;
import com.example.ui.UserIOConsoleImpl;
import com.example.ui.View;

public class App {

    public static void main(String[] args) throws PersistenceException, NoMerchInventoryException, DataValidationException, NoSuchMerchException, NotEnoughMoneyException {
        
    	UserIOConsoleImpl user1 = new UserIOConsoleImpl();
    	View view1 = new View(user1);
    	
    	VendingMachineDaoFileImpl daofile1 = new VendingMachineDaoFileImpl();
    	AuditDaoFileImpl auditdao1 = new AuditDaoFileImpl();
    	ServiceLayerImpl service1 = new ServiceLayerImpl(daofile1, auditdao1);
    	
    	Controller controller = new Controller(service1, view1);
        controller.run();
    }

}
