package com.shop.member.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.member.dao.ShoppingDao;
import com.shop.member.dto.TotalPriceDto;

public class SalesMemberListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 매출 순위 출력
		ShoppingDao dao = new ShoppingDao();
		List<TotalPriceDto> salesList = dao.salesList();
		request.setAttribute("salesList", salesList);
	}

}
