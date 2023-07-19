package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Produit;
import net.javaguides.springboot.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ProduitController {

	@Autowired
	private ProduitRepository  ProduitRepository;
	
	// get all Produits
	@GetMapping("/Produits")
	public List<Produit> getAllProduits(){
		return ProduitRepository.findAll();
	}		
	
	// create Produit rest api
	@PostMapping("/Produits")
	public Produit createProduit(@RequestBody Produit Produit) {
		return ProduitRepository.save(Produit);
	}
	
	// get Produit by id rest api
	@GetMapping("/Produits/{id}")
	public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
		Produit Produit = ProduitRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Produit not exist with id :" + id));
		return ResponseEntity.ok(Produit);
	}
	
	// update Produit rest api
	
	@PutMapping("/Produits/{id}")
	public ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody Produit ProduitDetails){
		Produit Produit = ProduitRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Produit not exist with id :" + id));

		Produit.setNom(ProduitDetails.getNom());
		Produit.setprix(ProduitDetails.getprix());
		Produit.setquantite(ProduitDetails.getquantite());

		Produit updatedProduit = ProduitRepository.save(Produit);
		return ResponseEntity.ok(updatedProduit);
	}
	
	// delete Produit rest api
	@DeleteMapping("/Produits/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProduit(@PathVariable Long id){
		Produit Produit = ProduitRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Produit not exist with id :" + id));

		ProduitRepository.delete(Produit);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
