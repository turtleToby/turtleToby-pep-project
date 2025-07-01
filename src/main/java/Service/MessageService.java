package Service;

import Model.Message;
import DAO.MessageDAO;

import java.util.List;

public class MessageService {
    private MessageDAO messageDAO;

    public MessageService() {
        messageDAO = new MessageDAO();
    }

    public Message addMessage(Message message) {
        if (!message.getMessage_text().isEmpty() && message.getMessage_text().length() <= 255) {
            return messageDAO.insertMessage(message);
        }

        return null;
    }

    public List<Message> getAllMessages() {
        return messageDAO.getAllMessages();
    }

    public Message getMessageById(int messageId) {
        return messageDAO.getMessageById(messageId);
    }

    public Message deleteMessageById(int messageId) {
        Message searchMessage = getMessageById(messageId);
        if (searchMessage != null) {
            boolean deleted = messageDAO.deleteMessageById(messageId);
            if (deleted) {
                return searchMessage;
            }
        }
        
        return null;
    }

    public Message updateMessage(int messageId, String messageText) {
        Message searchedMessage = getMessageById(messageId);
        if (searchedMessage != null && !messageText.isEmpty() && messageText.length() <= 255) {
            if (messageDAO.updateMessage(messageId, messageText) == true) {
                searchedMessage.message_text = messageText;
                return searchedMessage;
            }
        }
        
        return null;
    }

    public List<Message> getAllMessagesFromUser(int accountId) {
        return messageDAO.getAllMessagesFromUser(accountId);
    }
}
