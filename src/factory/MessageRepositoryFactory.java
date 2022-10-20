package factory;

import enums.MessageRepositoryType;
import repository.MessageRepository;
import repository.impl.MessageQueueBasedRepository;
import repository.impl.MessageStackBasedRepository;

public class MessageRepositoryFactory {
    private MessageRepositoryFactory() {
    }

    public static final MessageRepository getMessageRepository(MessageRepositoryType msgRepoType) {
        switch (msgRepoType) {
            case STACK_BASED_DOUBLY_LINKED_LIST:
                return new MessageStackBasedRepository();

            case QUEUE_BASED_DOUBLY_LINKED_LIST:
                return new MessageQueueBasedRepository();

            default:
                throw new IllegalArgumentException("This message repository type is unsupported");
        }
    }
}
