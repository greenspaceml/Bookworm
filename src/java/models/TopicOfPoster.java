/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author hongq
 */
public class TopicOfPoster {
    private Topic topic;
    private Poster poster;

    public TopicOfPoster() {
    }

    public TopicOfPoster(Topic topic, Poster poster) {
        this.topic = topic;
        this.poster = poster;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Poster getPoster() {
        return poster;
    }

    public void setPoster(Poster poster) {
        this.poster = poster;
    }
    
}
