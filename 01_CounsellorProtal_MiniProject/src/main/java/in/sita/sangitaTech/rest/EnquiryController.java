package in.sita.sangitaTech.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.sita.sangitaTech.DTO.EnquiryDTO;
import in.sita.sangitaTech.DTO.EnquiryFilterDTO;
import in.sita.sangitaTech.serviceInterface.EnquiryInterface;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {

    @Autowired
    private EnquiryInterface enquiryInterface;
    
    @GetMapping("/edit-enquiry")
    public String editEnquiry(@RequestParam("enqId") Integer enqId, Model model) {
        if (enqId == null) {
            System.out.println("Error: enqId is null");
            return "redirect:/error";
        }
        System.out.println("Received enqId: " + enqId);
        EnquiryDTO enqDto = enquiryInterface.getEnquiryById(enqId);
        model.addAttribute("enquiry", enqDto);
        return "addenquiry";
    }

    // Load the Add Enquiry Page
    @GetMapping("/enquiry-page")
    public String loadEnquiryPage(Model model) {
        EnquiryDTO dto = new EnquiryDTO();
        model.addAttribute("enquiry", dto);
        return "addenquiry";
    }

    // Handle Add Enquiry Form Submission
    @PostMapping("/addenquiry")
    public String addEnquiry(HttpServletRequest req, @ModelAttribute("enquiry") EnquiryDTO enquiryDTO, Model model) {
    	HttpSession session = req.getSession(false);
    	Integer counsellorId = (Integer)session.getAttribute("counsellorId");
      
        boolean isSaved = enquiryInterface.addEnquiry(enquiryDTO, counsellorId);

        // Show success or error message on the same page
        if (isSaved) {
            model.addAttribute("smsg", "Enquiry added successfully!");
        } else {
            model.addAttribute("emsg", "Failed to add enquiry.");
        }
        return "addenquiry";
    }

    // View All Enquiries for a Counsellor
    @GetMapping("/view-enquiries")
    public String viewAllEnquiries(HttpServletRequest req ,Model model) {
    	HttpSession session = req.getSession(false);
    	Integer counsellorId = (Integer)session.getAttribute("counsellorId");
        List<EnquiryDTO> enqList = enquiryInterface.getEnqiry(counsellorId);
        model.addAttribute("enquiries", enqList);
       EnquiryFilterDTO filterDTO=new EnquiryFilterDTO();
       model.addAttribute("filterDTO", filterDTO);
        return "viewenquiry";
    }

	 // Load the Filter Enquiries Page
	  
//	  @PostMapping("/filter-enquiries") 
//	  public String loadFilterPage(HttpServletRequest req,@ModelAttribute("filterDTO") EnquiryFilterDTO filterDTO,Model model) {
//		  HttpSession session = req.getSession(false);
//		  Integer counsellorId = (Integer)session.getAttribute("counsellorId");
//		  List<EnquiryDTO> enqList= 
//				  enquiryInterface.getEnqiry(filterDTO, counsellorId);
//		  	  model.addAttribute("filter", enqList);
//	  			return "viewenquiry"; 
//	  }
    
    
    @PostMapping("/filter-enquiries")
    public String loadFilterPage(HttpServletRequest req, @ModelAttribute("filterDTO") EnquiryFilterDTO filterDTO, Model model) {
        HttpSession session = req.getSession(false);
        Integer counsellorId = (Integer) session.getAttribute("counsellorId");
        List<EnquiryDTO> enqList = enquiryInterface.getEnqiry(filterDTO, counsellorId);
        model.addAttribute("enquiries", enqList); // Ensure consistency
        model.addAttribute("filterDTO", filterDTO); // Pass the current filter back to the view
        return "viewenquiry"; // Return the same view
    }

	
}
