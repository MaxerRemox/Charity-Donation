package pl.coderslab.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.repostiory.DonationRepo;
import pl.coderslab.charity.repostiory.InstitutionRepo;


@Controller
public class HomeController {

    @Autowired
    DonationRepo donationRepo;

    @Autowired
    InstitutionRepo institutionRepo;

    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("allBags", donationRepo.allBags().orElse(0));
        model.addAttribute("allGifts", donationRepo.count());
        model.addAttribute("fundations",institutionRepo.findAll());
        return "index";
    }

}
