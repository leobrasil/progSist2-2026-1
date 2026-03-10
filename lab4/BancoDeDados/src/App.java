    import java.math.BigDecimal;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;

    /**
     * 
     * 
     select * from paciente

    insert into paciente (id, nome)values(1,'Ronaldo')

    update paciente set nome='Neymar' where id =1

    delete from paciente where id=1
    * 
    */


    public class App {
        public static void main(String[] args) throws Exception {
            read();
        }

        public static Connection getConnection() throws Exception{
            //String url = "jdbc:postgresql://aws-1-us-east-1.pooler.supabase.com:6543/postgres?user=postgres.ryxhunaqbgqhapachrkh&password=GBfMoB9HJHy46zIi";
            
            String url = "jdbc:postgresql://aws-0-us-west-1.pooler.supabase.com:6543/postgres";
            String username="postgres.ryxhunaqbgqhapachrkh";
            String password="GBfMoB9HJHy46zIi";
            
            Connection con = DriverManager.getConnection(url,username,password);
            return con;

        }
        public static void read()throws Exception{
            String sql = "SELECT * FROM paciente";
            Connection con = null;
            try{
                con = getConnection();
                Statement pstmt = con.createStatement();

                ResultSet rs = pstmt.executeQuery(sql);
                while (rs.next()) {
                    long nro = rs.getLong(1);
                    String nome = rs.getString(2);
                    System.out.println(nro + " - " + nome);
                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }finally{
                con.close();
            }
        }
    }
