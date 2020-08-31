package net.code.java.projectmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



import java.util.List;

@Controller
public class AppController {
    @Autowired
    private ProductService service;
   @RequestMapping("/")
    public String viewHomePage(Model model){
       List<product> listProducts= service.listAll();
       model.addAttribute("ListProducts",listProducts);

       return "index";
   }

   @RequestMapping("/new")
    public String showNewProductForm(Model model){
       product product=new product();
       model.addAttribute("product",product);
       return "new_product";
   }

   @RequestMapping(value="/save", method = RequestMethod.POST)
   public String saveProduct(@ModelAttribute("product") product product){
       service.save(product);
         return "redirect:/";
   }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id")Long id){
       ModelAndView mav= new ModelAndView("edit_product");
       product product=service.get(id);
       mav.addObject("product",product);
       return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name="id") Long id) {
       service.delete(id);
       return "redirect:/";
    }
}
