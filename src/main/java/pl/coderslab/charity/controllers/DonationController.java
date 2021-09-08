package pl.coderslab.charity.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repostiory.CategoryRepo;
import pl.coderslab.charity.repostiory.DonationRepo;
import pl.coderslab.charity.repostiory.InstitutionRepo;


import javax.validation.Valid;
import java.util.List;

@Controller
public class DonationController {

    @Autowired
    DonationRepo donationRepo;

    @Autowired
    InstitutionRepo institutionRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @ModelAttribute("categories")
    public List<Category> categoryList(){
        return categoryRepo.findAll();
    }

    @ModelAttribute("institution")
    public List<Institution> institutionList(){
        return institutionRepo.findAll(PageRequest.of(0 , 4)).getContent();
    }

    @GetMapping("/add")
    public String addDonation(Model model){
        model.addAttribute("add", new Donation());
        return "addDona";
    }

    @PostMapping("/save")
    public String saveDonation(@Valid Donation donation, BindingResult result){
        if(result.hasErrors()){
            return "add";
        }
        donationRepo.save(donation);
        return "redirect:/";
    }
}
