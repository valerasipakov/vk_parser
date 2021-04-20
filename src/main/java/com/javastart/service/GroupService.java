package com.javastart.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javastart.response.Group;
import com.javastart.response.GroupResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Service
public class GroupService {

    @Value("6ef3638a6ef3638a6ef3638ad46e845a6966ef36ef3638a0e9a9cf68503993762890549")
    private String serviceToken;

    private final RestTemplate restTemplate;

    private final ObjectMapper objectMapper;

    @Autowired
    public GroupService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public ResponseEntity<String> getLastPost(String domain){

        //https://api.vk.com/method/wall.get?domain=&access_token=token&v=5.52
        String requestUrl = new String("https://api.vk.com/method/wall.get?domain="
                + domain + "&count=1&access_token=" + serviceToken + "&v=5.52" );

        ResponseEntity<String> response
                = restTemplate.getForEntity(requestUrl, String.class);
        return response;
    }

    //https://api.vk.com/method/groups.getById?group_ids=countryballs_re&fields=activity,age_limits,description,members_count,site&access_token=6ef3638a6ef3638a6ef3638ad46e845a6966ef36ef3638a0e9a9cf68503993762890549&v=&v=5.52
    public Group getGroupByDomain(String domain) throws IOException {
        String requestUrl = new String("https://api.vk.com/method/groups.getById?group_ids="+ domain +"&fields=activity,age_limits,description,members_count,site&access_token=6ef3638a6ef3638a6ef3638ad46e845a6966ef36ef3638a0e9a9cf68503993762890549&v=&v=5.52");

        GroupResponse groupResponse = restTemplate.getForObject(requestUrl, GroupResponse.class);
        List<Group> groupList = groupResponse.getResponse();
        Group group = groupList.get(0);

        return group;
    }

    public String groupResponseHandler(Group group){
        String responseStr = null;
        String isClosed = null;
        String ageLimits = null;
        String groupWebsite;
        if (group.getIsClosed() == 0){
            isClosed = "this is an open access group";
        }else if (group.getIsClosed() == 1){
            isClosed = "this is a group with private access";
        }

        if (group.getAgeLimits()==0){
            ageLimits = ", this group has no age limit";
        }else if (group.getAgeLimits() == 1){
            ageLimits = ", the age limit for this group is 16 years";
        }else if (group.getAgeLimits()==2){
            ageLimits = ", the age limit for this group is 18 years";
        }

        if (group.getSite().length() >=5 ){
            groupWebsite = ", WebSite:" + group.getSite();
        }else {
            groupWebsite = ", this group does not have a website";
        }

        if (group.getId() != null){
            responseStr = "Account Id: " + group.getId() + ", group name = " + group.getName() +
                    ", screen name = " +group.getScreenName() + ", group type: " + group.getType() + ", group activity: "
                    + group.getActivity() + ", privacy type: "+isClosed + ageLimits + ", the number of subscribers of this group: "
                    + group.getMembersCount() + groupWebsite;
        }
        return responseStr;
    }

    public String splitLink(String link){
        String[] splintedLink = link.split("/");
        return  splintedLink[3];
    }
}
