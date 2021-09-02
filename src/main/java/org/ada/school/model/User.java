package org.ada.school.model;

import org.ada.school.dto.UserDto;
import org.ada.school.repository.UserDocument;

import java.util.Date;
import java.util.UUID;

public class User

{

    String id;

    String name;

    String email;

    String lastName;

    Date createdAt;


    public User( UserDto userDto )
    {
        id = UUID.randomUUID().toString();
        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
        createdAt = new Date();
    }

    public User( UserDocument userD )
    {
        id = userD.getId();
        name = userD.getName();
        lastName = userD.getLastName();
        email = userD.getEmail();
        createdAt = userD.getCreatedAt();
    }

    public String getName()
    {
        return name;
    }

    public String getId()
    {
        return id;
    }

    public String getEmail()
    {
        return email;
    }

    public String getLastName()
    {
        return lastName;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void update( UserDto userDto )
    {
        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
    }
}
