package com.gs.springboot.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

   /* List<Topic> topicList = new ArrayList<>(Arrays.asList(
            new Topic("Spring", "Spring Framework", "Spring Framework Description"),
            new Topic("Java", "Core Java", "Core Java Description"),
            new Topic("Script", "Javascript", "Javascript Description")));*/

    public List<Topic> getAllTopics(){
        // return this.topicList;
        List<Topic> listOfTopics = new ArrayList<>();
        topicRepository.findAll().forEach(listOfTopics :: add);
        return listOfTopics;
    }

    public Optional<Topic> getTopic(String id) {
        // return topicList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id);
    }

    public void addTopic(Topic topic) {
        // topicList.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
        /* for(int idx = 0; idx < topicList.size(); idx++){
            Topic idxTopic = topicList.get(idx);
            if(idxTopic.getId().equals(id)){
                topicList.set(idx, topic);
                break;
            }
        }*/
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        // topicList.removeIf(t -> t.getId().equals(id));
        topicRepository.deleteById(id);
    }
}
