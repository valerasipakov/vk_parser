package com.javastart.controller;

import com.javastart.dto.urlDTO;
import com.javastart.response.Group;
import com.javastart.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class GroupController {

//https://api.vk.com/method/METHOD_NAME?PARAMETERS&access_token=ACCESS_TOKEN&v=V
// сервисный ключ доступа
//6ef3638a6ef3638a6ef3638ad46e845a6966ef36ef3638a0e9a9cf68503993762890549
    //https://api.vk.com/method/groups.getById?group_ids=countryballs_re&access_token=6ef3638a6ef3638a6ef3638ad46e845a6966ef36ef3638a0e9a9cf68503993762890549&v=&v=5.52
    //https://api.vk.com/method/groups.getById&fields=activity,age_limits,description,members_count,site?group_ids=countryballs_re&access_token=6ef3638a6ef3638a6ef3638ad46e845a6966ef36ef3638a0e9a9cf68503993762890549&v=&v=5.52

    private  GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/get_last_post")
    public ResponseEntity<String> getGroupLastPost(@RequestBody urlDTO urlDTO){
       String domain = groupService.splitLink(urlDTO.getLink());
       return groupService.getLastPost(domain);
    }

    @PostMapping("/group_info")
    public String getGroupInfo(@RequestBody urlDTO urlDTO) throws IOException {
        String domain = groupService.splitLink(urlDTO.getLink());
        Group group =  groupService.getGroupByDomain(domain);
        return groupService.groupResponseHandler(group);
    }
}
