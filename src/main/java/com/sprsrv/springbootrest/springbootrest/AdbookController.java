package com.baranee.springbootrest.springbootrest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/adbook")
public class AdbookController {
  @Autowired
  private AdbookRepository repo;
  
  @RequestMapping(method = RequestMethod.GET)
  public List<Adbook> findItems() {
    return repo.findAll();
  }
  
  @RequestMapping(value = "/{id}",method = RequestMethod.GET)
  public Adbook findone(@PathVariable Integer id) {
    return  repo.findOne(id);
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public Adbook addItem(@RequestBody Adbook adbook) {
	  adbook.setId(null);
    return repo.saveAndFlush(adbook);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public Adbook updateemployee(@RequestBody Adbook updatedadbook, @PathVariable Integer id) {
    updatedadbook.setId(id);
    return repo.saveAndFlush(updatedadbook);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteItem(@PathVariable Integer id) {
    repo.delete(id);
  }
}