package com.campusdual.appmazing.service;
import com.campusdual.appmazing.api.IContactsService;
import com.campusdual.appmazing.model.Contacts;
import com.campusdual.appmazing.model.dao.ContactsDao;
import com.campusdual.appmazing.model.dto.ContactsDTO;
import com.campusdual.appmazing.model.dto.dtomapper.ContactsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ContactService")
@Lazy
public class ContactService implements IContactsService {
    @Autowired
    private ContactsDao contactsDao;

    @Override
    public ContactsDTO queryContacts (ContactsDTO contactDTO) {

        Contacts contact = ContactsMapper.INSTANCE.toEntity(contactDTO);
        Contacts contactFinal = this.contactsDao.getReferenceById(contact.getId());
        ContactsDTO dto = ContactsMapper.INSTANCE.toDto(contactFinal);
        return dto;
    }

    @Override
    public List<ContactsDTO> queryAllContacts() {
        return ContactsMapper.INSTANCE.toDTOList(this.contactsDao.findAll());

    }

    @Override
    public int insertContact(ContactsDTO contactDTO) {
        Contacts contact= ContactsMapper.INSTANCE.toEntity(contactDTO);
        Contacts contact1 = this.contactsDao.saveAndFlush(contact);
        return contact1.getId();
    }

    @Override
    public int updateContact(ContactsDTO contactDTO) {
        return this.insertContact(contactDTO);
    }

    @Override
    public int deleteContact(ContactsDTO contactDTO) {
        int id = contactDTO.getId();
        Contacts contact = ContactsMapper.INSTANCE.toEntity(contactDTO);
        contactsDao.delete(contact);
        return id;
    }

}


