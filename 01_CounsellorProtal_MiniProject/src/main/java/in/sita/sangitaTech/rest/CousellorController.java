package in.sita.sangitaTech.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.sita.sangitaTech.DTO.CounsellorDTO;
import in.sita.sangitaTech.DTO.CounsellorDashboradDTO;
import in.sita.sangitaTech.serviceInterface.CounsellorInterface;
import in.sita.sangitaTech.serviceInterface.EnquiryInterface;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CousellorController {
	@Autowired
	private CounsellorInterface counsellorInterface;

	@Autowired
	private EnquiryInterface enquiryInterface;

	@GetMapping("/")
	public String index(Model model) {
		CounsellorDTO counsellor = new CounsellorDTO();
		model.addAttribute("counsellor", counsellor);
		return "index";
	}

	@GetMapping("/logout")
	public String logOut(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession(false);
		session.invalidate();
		CounsellorDTO counsellor = new CounsellorDTO();
		model.addAttribute("counsellor", counsellor);
		return "index";
	}

	@PostMapping("/login")
	public String showLoginPage(HttpServletRequest req, @ModelAttribute("counsellor") CounsellorDTO counsellor,
			Model model) {
		CounsellorDTO counsellorDto = counsellorInterface.login(counsellor);
		if (counsellorDto == null) {
			model.addAttribute("emsg", "Invalid EmailId and Password");
			return "index";
		} else {
			Integer counsellorId = counsellorDto.getCounsellorId();
			HttpSession session = req.getSession(true);
			session.setAttribute("counsellorId", counsellorId);
			CounsellorDashboradDTO dashboradDTO = enquiryInterface.getDashboardInfo(counsellorId);
			model.addAttribute("dashboradDTO", dashboradDTO);
		}
		return "dashboard";
	}

	@GetMapping("/register")
	public String registerPage(Model model) {
		CounsellorDTO counsellor = new CounsellorDTO();
		model.addAttribute("counsellor", counsellor);
		return "register";
	}

	@PostMapping("/register")
	public String handlRegister(@ModelAttribute("counsellor") CounsellorDTO counsellor, Model model) {

		boolean enqEmail = counsellorInterface.uniqueEmailCheck(counsellor.getEmail());

		if (enqEmail) {
			boolean register = counsellorInterface.register(counsellor);
			if (register) {
				model.addAttribute("smsg", "Register Successful");
			} else {
				model.addAttribute("emsg", "Register Faild");
			}

		} else {
			model.addAttribute("emsg", "Enter unique Email");
		}
		return "register";
	}

	@GetMapping("/dashboard")
	public String dispalyDashboard(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession(false);
		Integer counsellorId = (Integer) session.getAttribute("counsellorId");
		CounsellorDashboradDTO dashboradDTO = enquiryInterface.getDashboardInfo(counsellorId);
		model.addAttribute("dashboradDTO", dashboradDTO);
		return "dashboard";
	}

}
