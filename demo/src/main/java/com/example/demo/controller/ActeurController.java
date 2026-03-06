// package com.example.demo.controller;

// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;

// import com.example.demo.entities.Acteur;
// import com.example.demo.service.IServiceActeur;

// import ch.qos.logback.core.model.Model;
// import lombok.AllArgsConstructor;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;


// @Controller
// @RequestMapping("/acteurs")
// @AllArgsConstructor
// public class ActeurController {
//     IServiceActeur iServiceActeur;

//     @GetMapping("/all")
//     public String listActeurs(Model model) {
//         model.addAttribute("acteurs", iServiceActeur.findAllActeurs());
//         return "acteursList";
//     }
    
//     @GetMapping("/add")
//     public String getMethodName(Acteur acteur) {
//         iServiceActeur.createActeur(acteur);
//         return "redirect:/acteurs/all";
//     }
    
// }
