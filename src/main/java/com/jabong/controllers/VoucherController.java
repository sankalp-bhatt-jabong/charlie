package com.jabong.controllers;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jabong.controllers.AppController;
import com.jabong.models.Voucher;
import com.jabong.models.dao.VoucherDAO;
import com.jabong.services.response.BaseResponse;
import com.jabong.services.response.VoucherListResponse;
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
    public @ResponseBody BaseResponse detail() throws Exception
    {
        String id = request.getParameter("id");
        if (StringUtils.isBlank(id)) {
            throw new Exception("Please Supply valid parameter value.");
        }
        int voucherId = Integer.valueOf(id);
        Voucher voucher = voucherDao.getDetailById(voucherId);
        BaseResponse response = new VoucherResponse(voucher);
        return response;
    }

	@RequestMapping("/list")
	public @ResponseBody BaseResponse list() throws Exception {
		List<Object> vouchers = voucherDao.getActiveList();
		BaseResponse response = new VoucherListResponse(vouchers, voucherDao);
		return response;
	}

}
