package com.javastart.controller;

import com.javastart.dto.urlDTO;
import com.javastart.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupController {

//https://api.vk.com/method/METHOD_NAME?PARAMETERS&access_token=ACCESS_TOKEN&v=V
// сервисный ключ доступа
//6ef3638a6ef3638a6ef3638ad46e845a6966ef36ef3638a0e9a9cf68503993762890549

    private  GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/group_info")
    public ResponseEntity<String> getGroupLink(@RequestBody urlDTO urlDTO){
       String domain = groupService.splitLink(urlDTO.getLink());
       return groupService.getGroupPosts(domain);
    }

}
