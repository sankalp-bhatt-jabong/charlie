package com.jabong.controllers;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jabong.controllers.AppController;
import com.jabong.models.Voucher;
import com.jabong.models.dao.VoucherDAO;
import com.jabong.services.response.BaseResponse;
import com.jabong.services.response.VoucherResponse;


/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/voucher")
public class VoucherController extends AppController {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private VoucherDAO voucherDao;
	
	@RequestMapping("/detail")
	public @ResponseBody BaseResponse detail(@RequestParam(value="id") int id) {
		List<Voucher> vouchers = voucherDao.getDetailById(id);
		//Map<String, String[]> m = request.getParameterValues();
		BaseResponse response = new VoucherResponse(vouchers);
		return response;
		
		//return vouchers;
		//return "sdsds";
	}

}
