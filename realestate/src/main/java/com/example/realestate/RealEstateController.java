package com.example.realestate;

import com.sun.jdi.IntegerValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class RealEstateController {

    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyTypeRepository propertyTypeRepository;
    @Autowired
    private PropertyUseRepository propertyUseRepository;
    @Autowired
    private CommunicationsRepository communicationsRepository;

    @GetMapping("/")
    public String displayLogin(){
        return "login";
    }
    @GetMapping("/dashboard")
    public String displayLanding(){
        return "landing";
    }
    @GetMapping("/add-property")
    public String displayAddProperty(){
        return "add-property";
    }
    @GetMapping("/property-types")
    public String displayPropertyTypes(){
        return "property-types";
    }
    @GetMapping("/property-use")
    public String displayPropertyUse(){
        return "property-use";
    }
    @GetMapping("/add-property-type")
    public String displayAddPropertyType(){
        return "add-property-type";
    }
    @GetMapping("/add-property-use")
    public String displayAddPropertyUse(){
        return "add-property-use";
    }
    @GetMapping("/communications")
    public String displayCommunications(){
        return "communications";
    }

    @GetMapping("/landing-page-2")
    public String displayLanding2(Model model){
        model.addAttribute("data", propertyRepository.findAll());
        return "landing-page-2";
    }
    @GetMapping("/add-property-2")
    public String displayAddProperty2(){
        return "add-property-2";
    }
    @GetMapping("/property-use-2")
    public String displayPropertyUse2(Model model){
        model.addAttribute("data", propertyUseRepository.findAll());
        return "property-use-2";
    }




    @GetMapping("/add-property-use-2")
    public String displayAddPropertyUse2(){
        return "add-property-use-2";
    }
    @GetMapping("/add-property-type-2")
    public String displayAddPropertyType2(){
        return "add-property-type-2";
    }
    @GetMapping("/property-types-2")
    public String displayPropertyTypes2(Model model){
        model.addAttribute("data", propertyTypeRepository.findAll());
        return "property-types-2";
    }
    @GetMapping("/communications-2")
    public String displayCommunications2(Model model){
        model.addAttribute("data", communicationsRepository.findAll());
        return "communications-2";
    }

    @RequestMapping("/login2")
    public String loginMessage( ModelMap model){
        return "login2";
    }

    @PostMapping("/save")
    public String save(Property p){
        try {
            propertyRepository.save(p);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return "redirect:/landing-page-2";
    }

    @PostMapping("/save_property_type")
    public String savePropertyType(PropertyType pt){
        try {
            propertyTypeRepository.save(pt);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return "redirect:/property-types-2";
    }

    @PostMapping("/save_property_use")
    public String savePropertyUse(PropertyUse pu){
        try {
            propertyUseRepository.save(pu);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return "redirect:/property-use-2";
    }

    @RequestMapping("/execlogin")
    public String simulateLogin(){
        return "redirect:/landing-page-2";
    }

    @PostMapping("/updateproperty")
    public String updateProperty(
            @RequestParam("id") int id,
            @RequestParam("propertyname") String propertyname,
            @RequestParam("propertytype") String propertytype,
            @RequestParam("propertyuse") String propertyuse,
            @RequestParam("businesstype") String businesstype,
            @RequestParam("cost") Double cost,
            @RequestParam("location") String location,
            @RequestParam("status") String status
            ){
        //Document d2 = new Document("d","k","k");
        //documentRepo.save(d2);
        Property propertyToUpdate = propertyRepository.findById(id).get();
        propertyToUpdate.setPropertyname(propertyname);
        propertyToUpdate.setPropertytype(propertytype);
        propertyToUpdate.setPropertyuse(propertyuse);
        propertyToUpdate.setBusinesstype(businesstype);
        propertyToUpdate.setCost(cost);
        propertyToUpdate.setLocation(location);
        propertyToUpdate.setStatus(status);
        propertyRepository.save(propertyToUpdate);

        //documentRepo.save(d);
        return "redirect:/landing-page-2";
    }

    @PostMapping("/updatepropertytype")
    public String updatePropertyTypeMethod(
            @RequestParam("id") int id,
            @RequestParam("propertytype") String propertytype,
            @RequestParam("description") String description
    ){
        //Document d2 = new Document("d","k","k");
        //documentRepo.save(d2);
        PropertyType propertyTypeToUpdate = propertyTypeRepository.findById(id).get();

        propertyTypeToUpdate.setPropertytype(propertytype);
        propertyTypeToUpdate.setDescription(description);

        propertyTypeRepository.save(propertyTypeToUpdate);

        //documentRepo.save(d);

        return "redirect:/property-types-2";
    }


    @PostMapping("/updatepropertyuse")
    public String updatePropertyUseMethod(
            @RequestParam("id") int id,
            @RequestParam("propertyuse") String propertyuse,
            @RequestParam("description") String description
    ){
        //Document d2 = new Document("d","k","k");
        //documentRepo.save(d2);
        PropertyUse propertyUseToUpdate = propertyUseRepository.findById(id).get();

        propertyUseToUpdate.setPropertyuse(propertyuse);
        propertyUseToUpdate.setDescription(description);

        propertyUseRepository.save(propertyUseToUpdate);

        //documentRepo.save(d);
        return "redirect:/property-use-2";
    }

    @GetMapping("/deletepropertyuse")
    public String deletePropertyUseMethod(
            @RequestParam("id") int id
    ){
        //Document d2 = new Document("d","k","k");
        //documentRepo.save(d2);
        PropertyUse propertyUseToDelete = propertyUseRepository.findById(id).get();

        propertyUseRepository.delete(propertyUseToDelete);

        return "redirect:/property-use-2";
    }

    @GetMapping("/deletepropertytype")
    public String deletePropertyTypeMethod(
            @RequestParam("id") int id
    ){
        //Document d2 = new Document("d","k","k");
        //documentRepo.save(d2);
        PropertyType propertyTypeToDelete = propertyTypeRepository.findById(id).get();

        propertyTypeRepository.delete(propertyTypeToDelete);

        return "redirect:/property-types-2";
    }

    @GetMapping("/drawline")
    public String drawLineMethod(){
        return "drawlinepintopin";
    }

    @GetMapping("/deleteproperty")
    public String deletePropertyMethod(
            @RequestParam("id") int id
    ){
        //Document d2 = new Document("d","k","k");
        //documentRepo.save(d2);
        Property propertyToDelete = propertyRepository.findById(id).get();

        propertyRepository.delete(propertyToDelete);

        return "redirect:/landing-page-2";
    }

    /*@RequestMapping(value="/save", method= RequestMethod.POST)
    public String save2(Property p){
        try{
            propertyRepository.save(p);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return "redirect:/";
    }
    */

    @GetMapping("/geteditproperty")
    public String entry(Model model, @RequestParam(defaultValue = "0") int selected_id) {
        //Integer selectedIdInteger= (int) selected_id;
        try {
            Optional<Property> propertySelected = propertyRepository.findById(selected_id);

            if (propertySelected.isPresent()) {
                System.out.println("\n\npropertyfound\n\n ");
                model.addAttribute("data", propertySelected.get());
                model.addAttribute("datapropertytypes", propertyTypeRepository.findAll());
                model.addAttribute("datapropertyuse", propertyUseRepository.findAll());

            }
            return "editproperty";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            model.addAttribute("errormsg", "testabcdefgh");
            return "error";
        }


    }

    @GetMapping("/geteditpropertyuse")
    public String propertyUseEdit(Model model, @RequestParam(defaultValue = "0") int selected_id){
        //Integer selectedIdInteger= (int) selected_id;
        try {
            Optional<PropertyUse> propertyUseSelected = propertyUseRepository.findById(selected_id);

            if (propertyUseSelected.isPresent()) {
                System.out.println("\n\npropertyusefound\n\n ");
                model.addAttribute("data", propertyUseSelected.get());

            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return "edit-property-use";

    }

    @GetMapping("/geteditpropertytype")
    public String propertyTypeEdit(Model model, @RequestParam(defaultValue = "0") int selected_id){
        //Integer selectedIdInteger= (int) selected_id;
        try {
            Optional<PropertyType> propertyTypeSelected = propertyTypeRepository.findById(selected_id);

            if (propertyTypeSelected.isPresent()) {
                System.out.println("\n\npropertytypefound\n\n ");
                model.addAttribute("data", propertyTypeSelected.get());
            }
            return "edit-property-type";
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }


    }



}
