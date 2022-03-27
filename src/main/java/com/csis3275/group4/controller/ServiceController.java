package com.csis3275.group4.controller;

import com.csis3275.group4.entity.Service;
import com.csis3275.group4.entity.Table;
import com.csis3275.group4.repository.ServiceRepository;
import com.csis3275.group4.repository.TableRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ServiceController {
    private ServiceRepository serviceRepository;

    public ServiceController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @GetMapping("/service")
    public String showService(Model model){
        model.addAttribute("services", serviceRepository.findAll());
        return "service_display";
    }

    @GetMapping("/createservice")
    public String createServiceForm(Model model){
        Service service = new Service();
        model.addAttribute("service", service);
        return "service_create";
    }
    @PostMapping("/addservice")
    public String addService(@ModelAttribute("service") Service service, BindingResult result, Model model){
        if(result.hasErrors()){
            return "service_create";
        }

        serviceRepository.save(service);

        return "redirect:/service";

    }

    @GetMapping("/editservice/{id}")
    public String editService(@PathVariable("id") String id, Model model){
        Service service = serviceRepository.findById(id).get();
        model.addAttribute("service", service);
        return "service_update";
    }

    @PostMapping("/updateservice/{id}")
    public String updateService(@PathVariable("id") String id, @ModelAttribute("service") Service service, BindingResult result, Model model){
        if(result.hasErrors()){
            service.setId(id);
            return "service_update";
        }
        serviceRepository.save(service);
        return "redirect:/service";

    }

    @GetMapping("/deleteservice/{id}")
    public String deteleService(@PathVariable("id") String id, Model model){
        Service service = serviceRepository.findById(id).get();
        serviceRepository.delete(service);
        return "redirect:/service";
    }

    // Test
    public boolean checkService(Service service) {
        if(service.getServicePrice() > 200 || service.getServicePrice() < 20){
            return  false;
        }
        else  return true;
    }

}
