package uz.pdp.warehouse_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.warehouse_app.dto.Response;
import uz.pdp.warehouse_app.dto.SupplierDTO;
import uz.pdp.warehouse_app.entity.Supplier;
import uz.pdp.warehouse_app.repository.SupplierRepository;
import uz.pdp.warehouse_app.service.SupplierService;

import java.util.List;

/**
 * @author Sanjarbek Allayev, сб 9:30. 26.02.2022
 */
@Controller
@RequestMapping("/supplier")
public class SupplierController {
@Autowired
    SupplierService supplierService;
@Autowired
SupplierRepository supplierRepository;

    @GetMapping
    public String getAll(Model model){

        List<Supplier> all = supplierService.getAll();
        model.addAttribute("supplierList",all);
        model.addAttribute("response",new Response("Supplier list",true));
        return "supplier";
    }
    @GetMapping("/add")
    public String add(){
        return "supplier";
    }
    @PostMapping("/add")
    public String add(Model model, @ModelAttribute SupplierDTO supplierDTO){
        Response add = supplierService.add(supplierDTO);
        model.addAttribute("response",add);
        return "redirect:/supplier";
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Integer id){
        model.addAttribute("supplier",supplierRepository.findById(id));
        return "supplier-edit";
    }
    @PostMapping("/edit/{id}")
    public String edit(Model model,@ModelAttribute SupplierDTO supplierDTO,@PathVariable Integer id){
        Response edit = supplierService.edit(id, supplierDTO);
        model.addAttribute("response",edit);
        model.addAttribute("supplierList",supplierRepository.findAll());
        return "redirect:/supplier";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id,Model model){
        Response delete = supplierService.delete(id);
        model.addAttribute("response",delete);
        model.addAttribute("supplierList",supplierRepository.findAll());
        return "redirect:/supplier";
    }


}
