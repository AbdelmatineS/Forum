package esprit.forum.goffre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import esprit.forum.goffre.entity.Interview;
import esprit.forum.goffre.entity.Offre;
import esprit.forum.goffre.entity.User;
import esprit.forum.goffre.service.IOfferService;

@RestController
@RequestMapping("/Offre")
public class OffreController {
	
	@Autowired
	IOfferService oService;
	
	@PostMapping("/addOffre/{id}")
	@ResponseBody
	public ResponseEntity<Long> addOffre(
			@PathVariable("id") Long id, 
			@RequestBody Offre o) {
		Offre response = oService.addOffre(id, o);
		return ResponseEntity.ok(response.getId());
	}
	
	@PostMapping("/demanderInterview/{userId}/{offreId}")
	@ResponseBody
	public ResponseEntity<Long> demanderInterview(
			@PathVariable("userId") Long userId,
			@PathVariable("offreId") Long offreId,
			@RequestBody Interview i) {
		Interview response = oService.demanderInterview(userId,offreId, i);
		return ResponseEntity.ok(response.getId());
	}
	
	@PutMapping("/addInterview")
	@ResponseBody
	public ResponseEntity<Long> addInterview(@RequestBody Interview i) {
		Interview response = oService.addInterview(i);
		return ResponseEntity.ok(response.getId());
	}
	
	@PostMapping("/addUser")
	@ResponseBody
	public ResponseEntity<Long> addUser(@RequestBody User u) {
		User response = oService.addUser(u);
		return ResponseEntity.ok(response.getId());
	}
	
	@GetMapping("/getAllOffre")
	@ResponseBody
	public List<Offre> getAllOffre(){
		return oService.getAllOffre();
	}

	@GetMapping("/getOffreByDomain/{domain}")
	@ResponseBody
	public List<Offre> getOffreByDomain(@PathVariable("domain") String domain){
		return oService.getOffreByDomain(domain);
	}
	
}
