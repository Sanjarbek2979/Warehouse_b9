package uz.pdp.warehouse_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.warehouse_app.dto.InputDTO;
import uz.pdp.warehouse_app.dto.Response;
import uz.pdp.warehouse_app.repository.*;
import uz.pdp.warehouse_app.service.InputService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Sanjarbek Allayev, сб 9:29. 26.02.2022
 */
@Controller
@RequestMapping("/input")
public class InputController {
    @Autowired
    InputRepository inputRepository;
    @Autowired
    InputService inputService;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    ProductRepository productRepository;
@GetMapping
    public String getAll(Model model){
        model.addAttribute("inputList",inputRepository.findAll());
        model.addAttribute(new Response("Input list",true));
        return "input";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("inputList",inputRepository.findAll());
        model.addAttribute(new Response("Input list",true));
        model.addAttribute("currencyList",currencyRepository.findAll());
        model.addAttribute("warehouseList",warehouseRepository.findAll());
        model.addAttribute("supplierList",supplierRepository.findAll());
        model.addAttribute("productList",productRepository.findAll());
        return "input-add";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute InputDTO inputDTO){
        Response add = inputService.add(inputDTO);
        return "redirect:/input";
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model,@PathVariable Integer id){
        model.addAttribute("inputList",inputRepository.findAll());
        model.addAttribute(new Response("Input list",true));
        model.addAttribute("currencyList",currencyRepository.findAll());
        model.addAttribute("warehouseList",warehouseRepository.findAll());
        model.addAttribute("supplierList",supplierRepository.findAll());
        model.addAttribute("productList",productRepository.findAll());


        model.addAttribute("input",inputRepository.findById(id).get());
        return "input-edit";
    }
    @PostMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, @ModelAttribute InputDTO inputDTO){
        Response edit = inputService.edit(id,inputDTO);
        return "redirect:/input";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id,Model model){
    model.addAttribute("inputList",inputRepository.findAll());
    inputService.delete(id);
    return "redirect:/input";
    }

}
