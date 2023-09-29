package com.campusdual.appmazing.controller;

import com.campusdual.appmazing.api.IContactsService;
import com.campusdual.appmazing.model.dto.ContactsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/contacts")
public class ContactsController {

    @Autowired
    private IContactsService contactsService;

    @GetMapping
    public String testController() {
    return "Contact controller works!";
    }

    @PostMapping
    public String testController(@RequestBody String name){
        return "Contact controller works " + name + "!";
    }

    @GetMapping (value="/testMethod")
    public String testControllerMethod() {
        return  "Contact controller method works!";
    }

    @PostMapping(value="/get")
    public ContactsDTO queryContact(@RequestBody ContactsDTO contact){
        return this.contactsService.queryContacts(contact);
    }

    @GetMapping (value="/getAll")
    public List<ContactsDTO> queryAllContacts() {
    return this.contactsService.queryAllContacts();
    }

    @PostMapping (value="/add")
    public int insertContact (@RequestBody ContactsDTO contact) {
        return this.contactsService.insertContact(contact);
    }
    @PutMapping (value="/update")
    public int updateContact (@RequestBody ContactsDTO contact) {
        return this.contactsService.updateContact(contact);
}
    @DeleteMapping(value="/delete")
    public int deleteContact (@RequestBody ContactsDTO contact) {
        return this.contactsService.deleteContact(contact);
}
}
