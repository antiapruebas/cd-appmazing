package com.campusdual.appmazing.api;

import com.campusdual.appmazing.model.dto.ContactsDTO;


import java.util.List;

public interface IContactsService {
    ContactsDTO queryContacts(ContactsDTO product);
    List<ContactsDTO> queryAllContacts();

    int insertContact(ContactsDTO contact);
    int updateContact(ContactsDTO contact);

    int deleteContact(ContactsDTO contact);
}
