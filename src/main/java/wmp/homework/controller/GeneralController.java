package wmp.homework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import wmp.homework.form.RequestData;
import wmp.homework.parser.SplitParser;

@Controller
public class GeneralController {

	private static final String JSP_VIEW = "view_result";
	private static final String JSP_ERROR = "error";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		RequestData requestData = new RequestData();
		model.addAttribute("request", requestData);
		return JSP_VIEW;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String post(@ModelAttribute("request") RequestData request,
			ModelMap model) {
		try {
			SplitParser parser = new SplitParser();
			String[] response = parser.request(request.getUrl(), request.getDivision(), request.getType());
			request.setQuotient(response[0]);
			request.setRemainder(response[1]);

			model.addAttribute("request", request);
		} catch (Exception e) {
			model.addAttribute("message", "failed to run the Job: " + e.getMessage());
			return JSP_ERROR;
		}
		return JSP_VIEW;
	}
}
