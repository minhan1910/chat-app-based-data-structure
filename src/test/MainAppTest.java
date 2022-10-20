package test;

import java.io.IOException;
import java.util.Scanner;

import controller.Account;
import enums.MessageRepositoryType;
import factory.MessageRepositoryFactory;
import model.Message;
import repository.MessageRepository;

public class MainAppTest {
    public static void main(String[] args) {
        MessageRepositoryType basedQueue = MessageRepositoryType.QUEUE_BASED_DOUBLY_LINKED_LIST;
        MessageRepository repoOne = MessageRepositoryFactory.getMessageRepository(basedQueue);

        Account MinAn = new Account(repoOne, "Min An");
        Account KyHung = new Account(repoOne, "Ky Hung");

        Message msgAn = new Message("Min An", "Ky Hung");
        Message msgHung = new Message("Ky Hung", "Min An");

        msgAn.setData("Hi, How are u ?");
        msgHung.setData("I'm tired");

        // Send Message
        MinAn.send(msgAn);
        KyHung.send(msgHung);
        System.out.println();

        MinAn.showAllMessages();
    }
}
