package main.java.com.kostr.services.interfaces;

import main.java.com.kostr.dto.ClientDTO;
import main.java.com.kostr.models.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ClientServiceInterface {
    public Client addClient(ClientDTO client) throws SQLException;
    public ArrayList<Client> getAllClients() throws SQLException;
    public Client getClientByEMail(String email) throws SQLException;
}
