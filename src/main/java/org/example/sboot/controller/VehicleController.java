package org.example.sboot.controller;

import io.ebean.EbeanServer;
import org.example.sboot.domain.heroDomain.HeroContent;
import org.example.sboot.domain.vehicleDomain.Vehicle;
import org.example.sboot.service.ContentService;
import org.example.sboot.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private ContentService contentService;

    private List<Vehicle> list = new ArrayList<>();
    private List<HeroContent> listHero = new ArrayList<>();
    private HeroContent hero = new HeroContent();

    public List<Vehicle> getVehicles() {
        return vehicleService.getVehicles();
    }


    @RequestMapping(value = "/vehicleform", method = RequestMethod.GET)
    public String showform(Model model) {
//        listHero = heroDao.getHeroes();
        listHero = contentService.getContent();
        model.addAttribute("vehicle", new Vehicle());
        model.addAttribute("listHero", listHero);
        return "vehicle/vehicleform";
    }

    @RequestMapping("/savevehicle")
    public ModelAndView saveVehicle(@ModelAttribute(value = "vehicle") Vehicle vehicle,
                                    @ModelAttribute(value = "hero.id") String hero_id_Sting) {
        Integer hero_id = Integer.parseInt(hero_id_Sting);
//        listHero = heroDao.getHeroes();
        listHero = contentService.getContent();

        vehicle.setHero(listHero.get(hero_id));
        if (vehicle.getId() == null) {
            vehicle.setId(1L);
//            vehicle.setId(list.size()+1);
            vehicleService.createVehicle(vehicle);
//            vehicleDao.createVehicle(vehicle);
//            vehicle.setId(list.size());
            list.add(vehicle);

        } else {

//            listHero = heroDao.getHeroes();

            listHero = contentService.getContent();
            long index = vehicle.getId();
//            vehicle.setHero(listHero.get(index));
            vehicle.setHero(hero);
            vehicleService.updateVehicle(vehicle);
//            vehicleDao.updateVehicle(vehicle);

            list.set((int) (vehicle.getId() - 1), vehicle);
            updateVehicleInList(vehicle);
        }
        return new ModelAndView("redirect:/viewvehicle");
    }

    @RequestMapping(value = "/deletevehicle", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam(value = "vehicle_id") String vehicle_id) {
        Integer vehicleId = Integer.parseInt(vehicle_id);
        Vehicle vehicleToDelete = getVehicleById(vehicleId);
        vehicleService.deleteVehicle(vehicleToDelete);
//        vehicleDao.deleteVehicle(vehicleToDelete);
        list.remove(vehicleToDelete);
//        return new ModelAndView("redirect:/viewvehicle");
        return new ModelAndView("redirect:" + "vehicle/viewvehicle");
    }

    @RequestMapping(value = "/editvehicle")
    public ModelAndView edit(@RequestParam(value = "vehicle_id") String vehicle_id) {
        System.out.println();
        Integer vehicleId = Integer.parseInt(vehicle_id);
        Vehicle vehicle = getVehicleById(vehicleId);
        hero = vehicle.getHero();

        return new ModelAndView("vehicle/vehicleeditform", "vehicle", vehicle);
    }

    @RequestMapping("/viewvehicle")
    public ModelAndView viewvehicles(Model model) {
//        list = vehicleDao.getVehicles();
        list = vehicleService.getVehicles();
        return new ModelAndView("vehicle/viewvehicle", "list", list);

    }


    private Vehicle getVehicleById(@RequestParam Integer vehicle_id) {
        return list.stream().filter(f -> f.getId().equals(vehicle_id)).findFirst().get();
    }

    private void updateVehicleInList(Vehicle vehicle) {
        Vehicle vehicleTemp = getVehicleById(Math.toIntExact(vehicle.getId()));
        vehicleTemp.setName(vehicle.getName());
        vehicleTemp.setSpeed(vehicle.getSpeed());
        vehicleTemp.setValue(vehicle.getValue());
        vehicleTemp.setHero(vehicle.getHero());

    }

}
