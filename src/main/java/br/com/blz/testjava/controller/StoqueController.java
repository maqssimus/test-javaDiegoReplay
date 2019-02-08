package br.com.blz.testjava.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.blz.testjava.modelo.Produto;
import br.com.blz.testjava.servico.StoqueService;

@RestController
@RequestMapping(value = "/stoque")
public class StoqueController {
	
	@Autowired
	StoqueService stoqueService;
	
	 @RequestMapping(value = "/adicionar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
	 @ResponseBody
	 public ResponseEntity<String> stockAdd(@RequestBody Produto produto) throws Exception {
		 
		 HttpStatus httpStatus;
		 
		 httpStatus = stoqueService.add(produto);
		 
		 return new ResponseEntity<String>(httpStatus);
		 
	 }

	 @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseBody
	 public List<Produto> stockList() throws Exception {
		 List<Produto> produtoList = new ArrayList<Produto>();
		 
		 produtoList = stoqueService.getList();
		 
		 return produtoList;
	 }

	 @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
	 @ResponseBody
	 public ResponseEntity<String> stockUpdate(@RequestBody Produto produto) throws Exception {
		 
		 HttpStatus httpStatus;
		 
		 httpStatus = stoqueService.update(produto);
		 
		 return new ResponseEntity<String>(httpStatus);
	 }

	 @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE  )
	 @ResponseBody
	 public ResponseEntity<String> stockDelete (@RequestBody Produto produto) throws Exception {
		 HttpStatus httpStatus;
		 
		 httpStatus = stoqueService.delete(produto);
		 
		 return new ResponseEntity<String>(httpStatus);
		 
	 }
}
