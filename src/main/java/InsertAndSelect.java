import java.sql.*;

public class InsertAndSelect {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/veritabani_adi";
        String kullaniciAdi = "postgres"; //ppostgresql kullanici adi
        String sifre = "root"; //postgresql default sifresi
        try {
            Connection conn = DriverManager.getConnection(jdbcURL, kullaniciAdi, sifre);
//            String createSQL = "CREATE TABLE public.tablo_adi ( name character varying(255),surname character varying(255));";
//            PreparedStatement createStatement= conn.prepareStatement(createSQL);
//            createStatement.executeQuery();

            //INSERT İŞLEMİ
            String insertSQL = "INSERT INTO public.tablo_adi(\n"+
                    "\tname,surname)\n"+
                    "\tVALUES (?,?);";
            PreparedStatement insertStatment =conn.prepareStatement(insertSQL);

            insertStatment.setString(1,"Meryem");
            insertStatment.setString(2,"Alanoglu");
            int affecteRows = insertStatment.executeUpdate();
//            System.out.println("INSERT islemi sonucunda etkilenen satır sayisi: " + affecteRows);
//
            //SELECT ISLEMİ
            String selectSQL= "SELECT*FROM tablo_adi";
            PreparedStatement selectStatment= conn.prepareStatement(selectSQL);
            ResultSet resultSet = selectStatment.executeQuery();
            while (resultSet.next()){
                String sutun1Degeri = resultSet.getString("name");
                String sutun2Degeri = resultSet.getString("surname");
                System.out.println("Name : " + sutun1Degeri+ "\nSurname : " + sutun2Degeri + "\n");
            }
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}