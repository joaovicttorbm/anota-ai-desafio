package com.jm.anota_ai_desafio.services.aws;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Map;

public class AwsSnsService {
    private final AmazonSNS amazonSNS;
    private final String catalogTopicArn;

    @Autowired
    public AwsSnsService(AmazonSNS amazonSNS, String catalogTopicArn) {
        this.amazonSNS = amazonSNS;
        this.catalogTopicArn = catalogTopicArn;
    }

    public PublishResult publishMessage(MessageDTO messageDTO) {
        PublishRequest publishRequest = new PublishRequest()
                .withTopicArn(catalogTopicArn)
                .withMessage(messageDTO.getMessage())
                .withSubject(messageDTO.getSubject()) // Optional, if you have a subject
                .withMessageAttributes(Map.of(
                        "MessageType", new MessageAttributeValue()
                                .withDataType("String")
                                .withStringValue(messageDTO.getMessageType())
                ));
        return amazonSNS.publish(publishRequest);
    }
}
