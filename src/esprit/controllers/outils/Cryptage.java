/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.controllers.outils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mustapha
 */
public class Cryptage {
    
   public static String cypterPHP(String password, String salt)
   {
       try {
           URL a= new URL("http://localhost/test.php?password="+password+"&salt="+salt+"");
           URLConnection ac=a.openConnection();
           BufferedReader in=new BufferedReader(new InputStreamReader(ac.getInputStream()));
          
           String line;
          String res = "";
           while((line = in.readLine()) != null){
               res = res + line;
            } 
           return res;
       } catch (IOException ex) {
           Logger.getLogger(Cryptage.class.getName()).log(Level.SEVERE, null, ex);
              return "-1";
       }
       
   }
    public static String getSHA512(String toHash, String salt)
    {
        for (int i = 0; i < 5000; i++)
        {
            toHash = SHA512once(toHash+salt);
        }
        
        return SHA512once(toHash);
    }

    private static String SHA512once(String toHash)
    {

        MessageDigest md;
        String message = toHash;
        try 
        {
            md= MessageDigest.getInstance("SHA-512");

            md.update(message.getBytes());
            byte[] mb = md.digest();
            String out = "";
            for (int i = 0; i < mb.length; i++) 
            {
                byte temp = mb[i];
                String s = Integer.toHexString(new Byte(temp));
                while (s.length() < 2) 
                {
                    s = "0" + s;
                }
                s = s.substring(s.length() - 2);
                out += s;
            }
            return(out);

        } catch (NoSuchAlgorithmException e) 
        {
            System.out.println("ERROR: " + e.getMessage());
        }
        return "error";
    }

    public static String salt(String toSalt, String salt)
    {
        return "";
}
    
    
     public static String hash(String pwd,String s)
    {
        String password = pwd;
        String salt = s;
        String salted = password + "{"+salt+"}";
        String digest = Cryptage.SHA512once(salted);
        
        for (int i=1; i < 5000; i++)
        {
            digest  = Cryptage.SHA512once(digest+salted);
        }
       System.out.println(digest);
       return "s";
    }
    
    
    
    
    
    public static String  SHA(String input )
    {
        
        
        
        return "1";
    }

    public static String md5(String input) {
         
        String md5 = null;
         
        if(null == input) return null;
         
        try {
             
        //Create MessageDigest object for MD5
        MessageDigest digest = MessageDigest.getInstance("MD5");
         
        //Update input string in message digest
        digest.update(input.getBytes(), 0, input.length());
 
        //Converts message digest value in base 16 (hex) 
        md5 = new BigInteger(1, digest.digest()).toString(16);
 
        } catch (NoSuchAlgorithmException e) {
 
            e.printStackTrace();
        }
        return md5;
    }
    
}
