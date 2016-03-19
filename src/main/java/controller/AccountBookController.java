package main.java.controller;

import java.util.List;

import main.java.dao.CustomerDAO;
import main.java.domain.Category;
import main.java.domain.Client;
import main.java.domain.SaleRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountBookController {
	
	@Autowired
	private CustomerDAO hibernateUserDao;
	
//	@RequestMapping(value="/trade.page", method= RequestMethod.GET)
//	public ModelAndView showTrade() {	
//		List<SaleRecord> saleRecords = hibernateUserDao.getSaleRecords();
//		ModelAndView modelAndView = new ModelAndView("srecordslist");
//		modelAndView.addObject("alltransactions", saleRecords);
//		modelAndView.addObject("newSR", new SaleRecord());
//		return modelAndView;
//	}
	
	@RequestMapping(value="/clienttrade.page", method= RequestMethod.GET)
	public ModelAndView showClientTrade(@RequestParam(value="selectclient", required=false)
												Long id) {	
		List<Client> clients = hibernateUserDao.getAllClients();
		if(id == null) {
			id=clients.get(0).getIdClient();
		}	
		ModelAndView modelAndView = new ModelAndView("chooseclient");
		modelAndView.addObject("allclients", clients);
//		List<SaleRecord> saleRecords = hibernateUserDao.getClientSaleRecords(id);
//		modelAndView.addObject("clienttrans", saleRecords);
		modelAndView.addObject("clientid", id);
		return modelAndView;
	}	
	
	@RequestMapping(value="/clienttradelist.page", method= RequestMethod.GET)
	public ModelAndView showClientTotalTrade(@RequestParam(value="selectclient", required=false)
			Long id, @RequestParam(value="startdate", required=false) String sd, 
			@RequestParam(value="enddate", required=false) String ed) {	
		
		List<Client> clients = hibernateUserDao.getAllClients();		
		if(id == null) {
			id=clients.get(0).getIdClient();
		}
//		System.out.println("============================startdate = " + sd);
//		System.out.println("============================startdate = " + ed);
		Client client = hibernateUserDao.getClientActivity(id, sd, ed);
		ModelAndView modelAndView = new ModelAndView("clientactivity");
		modelAndView.addObject("allclients", clients);
		modelAndView.addObject("clientactiv", client);
//		modelAndView.addObject("clientid", id);
		return modelAndView;
	}	
}
