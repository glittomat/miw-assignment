package com.miw.gildedrose.domain.messaging;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.logging.log4j.message.Message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.ToString;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({"messages"})
@ToString
public class BaseApiResponse implements Serializable{
	
	private static final long serialVersionUID = -5693009630924596762L;


    private List<Message> messages = new ArrayList<>();


    /**
     * Gets messages.
     *
     * @return the messages
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Sets messages.
     *
     * @param messages the messages
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        BaseApiResponse that = (BaseApiResponse) object;

        return new EqualsBuilder().append(messages, that.messages).isEquals();
    }

    @Override
    public int hashCode() {
    	//Needs explanantion
        return new HashCodeBuilder(17, 37).append(messages).toHashCode();
    }
    

//    @Override
//    public String toString() {
//        return new StringJoiner(", ", "BaseApiResponse{", "}").add("messages=" + messages).toString();
//    }

}
