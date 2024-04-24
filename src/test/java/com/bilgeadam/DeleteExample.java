package com.bilgeadam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteExample {
    public static void main(String[] args) {

            String jdbcURL = "jdbc:postgresql://localhost:5432/veritabani_adi";
            String kullaniciAdi = "postgres"; //ppostgresql kullanici adi
            String sifre = "root"; //postgresql default sifresi
            try {
                Connection conn = DriverManager.getConnection(jdbcURL, kullaniciAdi, sifre);
                String deletSQL = " DELETE FROM tablo_adi WHERE name = ?";
            PreparedStatement deleteStatement= conn.prepareStatement(deletSQL);
            deleteStatement.setString(1,"Meryem");
            int affectedRows = deleteStatement.executeUpdate();
                System.out.println("Dekete işlemi sonucunda etkilenen satır sayısı : " + affectedRows);
    }catch (SQLException e){
                e.printStackTrace();
            }
            }
    }
