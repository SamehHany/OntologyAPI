/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.ontology.common;

/**
 *
 * @author sameh
 */
public class ID {
    private String id;
    
    public ID(String id) {
        this.id = canonicalize(id);
    }
    
    public ID(Object obj) {
        this.id = obj != null ? canonicalize(obj.toString()) : "";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ID) {
            return id.equals(((ID)obj).id);
        }
        
        return false;
    }
    
    @Override
    public int hashCode() {
        return id.hashCode();
    }
    
    @Override
    public String toString() {
        return id;
    }
    
    private static String HTTP = "http://";
    private static String HTTPS = "https://";
    private static String canonicalize(String id) {
        if (id == null) {
            return "";
        }
        id = id.toLowerCase().trim();
        if (id.startsWith(HTTP)) {
            id = id.substring(HTTP.length());
        } else if (id.startsWith(HTTPS)) {
            id = id.substring(HTTPS.length());
        }
        
        StringBuilder sb = new StringBuilder();
        for (char ch : id.toCharArray()) {
            if (ch == '/') {
                if (sb.charAt(sb.length() - 1) != ch) {
                    sb.append(ch);
                }
            } else {
                sb.append(ch);
            }
        }
        
        if (sb.charAt(sb.length() - 1) == '/') {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        return sb.toString();
    }
}
