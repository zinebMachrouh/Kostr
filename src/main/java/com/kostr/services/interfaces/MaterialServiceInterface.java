package main.java.com.kostr.services.interfaces;

import main.java.com.kostr.dto.MaterialDTO;
import main.java.com.kostr.models.Material;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface MaterialServiceInterface {
    public Material addMaterial(MaterialDTO material) throws SQLException;

}
